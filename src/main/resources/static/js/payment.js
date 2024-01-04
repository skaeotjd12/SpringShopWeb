let index = {
init: function(){
    $("#kakaopay").on("click", () => {
        this.kakaoPay();
        });
    },

kakaoPay: function(useremail, userId) {

var IMP = window.IMP;

var today = new Date();
var hours = today.getHours(); // 시
var minutes = today.getMinutes();  // 분
var seconds = today.getSeconds();  // 초
var milliseconds = today.getMilliseconds();
var makeMerchantUid = `${hours}` + `${minutes}` + `${seconds}` + `${milliseconds}`;
var useremail = $("#userId").val();
var userId = $("#userName").val();


            IMP.init("imp53047217"); // 가맹점 식별코드
            IMP.request_pay({
                pg: 'kakaopay.TC0ONETIME', // PG사 코드표에서 선택
                pay_method: 'card', // 결제 방식
                merchant_uid: "IMP" + makeMerchantUid, // 결제 고유 번호
                name: '상품명', // 제품명
                amount: 100, // 가격
                //구매자 정보 ↓
                buyer_email: "fefefef",
                buyer_name: "edefefef",
                // buyer_tel : '010-1234-5678',
                // buyer_addr : '서울특별시 강남구 삼성동',
                // buyer_postcode : '123-456'
            }, rsp =>{ //callback
              if( rsp.success) {
               alert("성공");
               } else{
               alert("실패");
               }
            });
    }
    }
index.init();