let index = {
init: function(){
    $("#kakaopay").on("click", () => {
        this.kakaoPay();
        });
    },

kakaoPay: function(userId) {

var IMP = window.IMP;

var today = new Date();
var hours = today.getHours(); // 시
var minutes = today.getMinutes();  // 분
var seconds = today.getSeconds();  // 초
var milliseconds = today.getMilliseconds();
var makeMerchantUid = `${hours}` + `${minutes}` + `${seconds}` + `${milliseconds}`;
var useremail = $("#userId").val();
var userId = $("#userName").val();



let data = {
			prdNum: $("#prdNum").val(),
			userId : $("#principalId").val(),
			orderCount: $("#orderCount").val(),
			orderPrice: $("#orderPrice").val()
		};


            IMP.init("imp53047217"); // 가맹점 식별코드
            IMP.request_pay({
                pg: 'kakaopay.TC0ONETIME', // PG사 코드표에서 선택
                pay_method: 'card', // 결제 방식
                merchant_uid: "IMP" + makeMerchantUid, // 결제 고유 번호
                name: $("#prdName").val(), // 제품명
                amount: data.orderPrice, // 가격
                //구매자 정보 ↓
                buyer_email: userId,
                buyer_name: useremail,
                // buyer_tel : '010-1234-5678',
                // buyer_addr : '서울특별시 강남구 삼성동',
                // buyer_postcode : '123-456'
            }, rsp =>{ //callback
              if( rsp.success) {
               $.ajax({
               			type: "POST",
               			url: "/api/board/"+data.prdNum+"/orderPrd",
               			data: JSON.stringify(data),
               			contentType: "application/json; charset=utf-8",
               			dataType: "json"

               		}).done(function(resp) {
               			if(resp.statuts == 500){
               				alert("상품구매 실패하였습니다.")
               			}else{
               			alert("상품구매가 완료되었습니다.")
               			}
               			location.href = "/";
               		}).fail(function(error) {
               			alert(JSON.stringify(error));
               		});
               } else{
               alert("실패");
               }
            });
    }
    }
index.init();