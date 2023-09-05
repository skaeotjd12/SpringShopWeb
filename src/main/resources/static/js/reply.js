let index = {
	init: function() {
		$("#btn-addReply").on("click", () => { 
			this.addReply();
		});
	},
	 
	addReply: function() {
		let data = {
			userId: $("#userId").val(),
			replyText: $("#replyText").val(),
			prdNum: $("#prdNum").val()
		};

		//console.log(data);
		//회원가입 수행 요청
		//ajax 호출시 default가 비동기 호출
		//ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청
		$.ajax({
			type: "POST",
			url: "/api/board/"+data.prdNum+"/addReply",
			data: JSON.stringify(data), //http body 데이터
			contentType: "application/json; charset=utf-8", //body 데이터가 어떤 타입인지(MIME) 
			dataType: "json" //요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열인데 (생긴게 json 이라면 ) => javascript 오브젝트로 변경해주는 역할

		}).done(function(resp) {
			if(resp.statuts == 500){
				alert("댓글 작성 실패.")
				location.href = "/";
			}else{
			alert("댓글 작성 성공.")
			location.reload();
			}
			
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	}
}

index.init(); 

function deleteReply(replyId) {
	$.ajax({
			type: "delete",
			url: "/api/"+replyId+"/deleteReply",
			//url: "/api/"+$("#btn-deleteReply").val()+"/deleteReply",
			contentType: "application/json; charset=utf-8", //body 데이터가 어떤 타입인지(MIME) 
			dataType: "json" //요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열인데 (생긴게 json 이라면 ) => javascript 오브젝트로 변경해주는 역할

		}).done(function(resp) {
			if(resp.statuts == 500){
				alert("댓글 삭제 실패.")
				location.href = "/";
			}else{
			alert("댓글 삭제.")
			location.reload();
			}
			
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});	
	};
