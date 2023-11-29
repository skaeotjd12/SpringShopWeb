<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<form action="/auth/loginProc" method="post">

		<div class="form-group">
			<label for="아이디">아이디</label> <input type="text" class="form-control" placeholder="Enter username" name="userId" id="userId">
		</div>

		<div class="form-group">
			<label for="비밀번호">비밀번호</label> <input type="password" class="form-control" placeholder="Enter password" name="userPwd" id="userPwd">
		</div>
		
		

		<button id="btn-login" class="btn btn-primary">로그인</button>
		<a href="https://kauth.kakao.com/oauth/authorize
?client_id=355fab28ca82d6c11b5440ecb9b6d9d1
&redirect_uri=http://localhost:8000/auth/kakao/callback
&response_type=code"><img height="38px" src="/image/kakao_login_button.png" /></a>
	</form>

</div>

<%@ include file="../layout/footer.jsp"%>