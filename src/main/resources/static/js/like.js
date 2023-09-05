function like(prdNum) {
		$.ajax({
			type:"post",
			url:`/api/board/${prdNum}/likes`,
			dataType:"json"
		}).done(res => {
			alert('좋아요함수 실행됨')
			console.log("좋아요 함수 실행됨", res);	
			 location.reload();
		}).fail(error =>{
			alert('좋아요를 한 게시물입니다.')
			console.log("오류", error);
		});
	}

	function unlike(prdNum) {
		$.ajax({
			type:"delete",
			url:`/api/board/${prdNum}/likes`,
			dataType:"json"
		}).done(res => {
			alert('좋아요 취소 함수 실행됨')
			console.log("좋아요 취소 실행됨", res);	
			 location.reload();
		}).fail(error =>{
			alert('좋아요를 한 게시물입니다.')
			console.log("오류", error);
		});
	}