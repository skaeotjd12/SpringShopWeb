let index = {
	init: function() {
		$("#btn-update").on("click", () => { 
			this.update();
		});
	},
	
	update: function() {
		alert('user의 update 함수 호출됨');
		let data = {
			userId: $("#userId").val(),
			userName: $("#userName").val(),
			userPwd: $("#userPwd").val(),
			userEmail: $("#userEmail").val(),
			userZipcode:$("#userZipcode").val(),
			userAddr: $("#userAddr").val()+" "+$("#userDetailAddr").val(),
			
		};

		$.ajax({
			type: "put",
			url:"/api/"+data.userId+"/update",
			data: JSON.stringify(data), 
			contentType: "application/json; charset=utf-8", 
			dataType: "json" 

		}).done(function(resp) {
			if(resp.statuts == 500){
				alert("회원수정에 실패하였습니다.")
			}else{
			alert("회원수정이 완료되었습니다.")
			}
			location.href = "/";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	}
}

index.init(); 

	