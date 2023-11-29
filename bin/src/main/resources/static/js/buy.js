let index = {
	init: function() {
		$("#btn-orderPrd").on("click", () => { 
			this.buyPrd();
		});
	},
	
	buyPrd: function() {
		alert('buy의 orderPrd 함수 호출됨');
		let data = {
			prdCtg: $("#prdCtg").val(),
			prdNum: $("#prdNum").val(),
			prdPrice: $("#prdPrice").val(),
			buyCount: $("#buyCount").val()
		};

	
		$.ajax({
			type: "POST",
			url: "/api/board/"+data.prdNum+"/orderPrd",
			data: JSON.stringify(data), //http body 데이터
			contentType: "application/json; charset=utf-8", //body 데이터가 어떤 타입인지(MIME) 
			dataType: "json" //요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열인데 (생긴게 json 이라면 ) => javascript 오브젝트로 변경해주는 역할

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
	}
}

index.init(); 

	