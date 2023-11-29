function get_option2(option1, selectOption) {
	if (option1 == "TOP") {
		options = new Array("셔츠", "맨투맨");
		values = new Array("shirt", "T-shirt");
	} else if (option1 == "BOTTOM") {
		options = new Array("면바지","청바지");
		values = new Array("pants", "jeans");
    	}
  //셀렉트 박스의 기본 옵션들을 초기화시킨다.
	for (i = 0; i < option1.length; i++) {
		selectOption.options[i] = null;
	}
  // 두번째 셀렉트 박스에 값을 뿌려준다.
	for (i = 0; i < options.length; i++) {
	selectOption.options[i] = new Option(options[i], values[i]);
	}
}

let index = {
	init: function() {
		$("#btn-addPrd").on("click", () => { 
			this.addPrd();
		});
		$("#btn-updatePrd").on("click", () => { 
			this.updatePrd();
		});
	},
	
	addPrd: function() {
		let data = {
			prdCtg: $("#prdCtg option:selected").val(),
			prdName: $("#prdName").val(),
			prdPrice: $("#prdPrice").val(),
			prdStatuts:$("#prdStatuts").val(),
			prdDetail: $("#prdDetail").val()
			
		};
		let form = $("#form")[0];
		let formData = new FormData(form);
		formData.append("prdFile", $("#prdFile"));
		formData.append("key", new Blob([JSON.stringify(data)], {type:"application/json"}));
		
		$.ajax({
			type: "POST",
			url: "/admin/addPrd",
			data: formData,
			contentType: false,
			processData: false, 
			enctype : 'multipart/form-data'
		}).done(function(resp) {
			alert('상품 등록 성공')
			location.href = "/admin/managerPage";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	},
	
	updatePrd: function() {
		let data = {
			prdNum :$("#prdNum").val(),
			prdCtg: $("#prdCtg option:selected").val(),
			prdName: $("#prdName").val(),
			prdPrice: $("#prdPrice").val(),
			prdStatuts:$("#prdStatuts").val(),
			prdDetail: $("#prdDetail").val()
			
		};
		let form = $("#form")[0];
		let formData = new FormData(form);
		formData.append("prdFile", $("#prdFile"));
		formData.append("key", new Blob([JSON.stringify(data)], {type:"application/json"}));
		
		$.ajax({
			type: "put",
			url: "/api/updatePrd",
			data: formData,
			contentType: false,
			processData: false, 
			enctype : 'multipart/form-data'
		}).done(function(resp) {
			alert('상품 수정 성공')
			location.href = "/admin/managerPage";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});
	}
}

index.init(); 

function deletePrd(prdNum) {
	$.ajax({
			type: "delete",
			url: "/api/"+prdNum+"/deletePrd",
			//url: "/api/"+$("#btn-deleteReply").val()+"/deleteReply",
			contentType: "application/json; charset=utf-8", //body 데이터가 어떤 타입인지(MIME) 
			dataType: "json" //요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열인데 (생긴게 json 이라면 ) => javascript 오브젝트로 변경해주는 역할

		}).done(function(resp) {
			if(resp.statuts == 500){
				alert("상품 삭제 실패.")
				location.href = "/";
			}else{
			alert("상품 삭제.")
			location.reload();
			}
			
		}).fail(function(error) {
			alert(JSON.stringify(error));
		});	
	};


