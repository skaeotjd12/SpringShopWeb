let index = {
	init: function() {
		$("#btn-save").on("click", () => { 
			this.save();
		});
	},
	
	save: function() {
		alert('user의 save 함수 호출됨');
		let data = {
			userId: $("#userId").val(),
			userName: $("#userName").val(),
			userPwd: $("#userPwd").val(),
			userEmail: $("#userEmail").val(),
			userZipcode:$("#userZipcode").val(),
			userAddr: $("#userAddr").val()+" "+$("#userDetailAddr").val(),
			userBirth:$("#userBirth").val()
			
		};

		//console.log(data);
		//회원가입 수행 요청
		//ajax 호출시 default가 비동기 호출
		//ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청
		$.ajax({
			type: "POST",
			url: "/auth/joinProc",
			data: JSON.stringify(data), //http body 데이터
			contentType: "application/json; charset=utf-8", //body 데이터가 어떤 타입인지(MIME) 
			dataType: "json" //요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열인데 (생긴게 json 이라면 ) => javascript 오브젝트로 변경해주는 역할

		}).done(function(resp) {
			if(resp.statuts == 500){
				alert("회원가입에 실패하였습니다.")
			}else{
			alert("회원가입이 완료되었습니다.")
			}
			location.href = "/";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	}
}

index.init(); 

	