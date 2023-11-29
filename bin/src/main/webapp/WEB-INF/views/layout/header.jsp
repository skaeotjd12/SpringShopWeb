<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<sec:authorize access="isAuthenticated()">
	<sec:authentication property="principal" var="principal" />
</sec:authorize>
<!DOCTYPE html>
<html lang="en">
<head>
<title>niceShop</title>
<meta charset="utf-8">
<!-- bootstrap -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
 <!-- 서머노트를 위해 추가해야할 부분 -->
 <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.js"></script>
  <!--  -->
<style type="text/css">
.header{
	max-width: none;
}
.menu_wrap {
	height: 3px;
	margin-top: 3px;
	font-size: 12px;
}
.menu_wrap2 {
	height: 3px;
	margin-top: 3px;
	font-size: 15px;
}
.menu_wrap2  li {
	margin-right:200px;
}

hr {
	margin: 4px;
}
</style>
</head>
<body>
		<!-- principalId 담아두는 곳 -->
	<input type="hidden" id="principalId" value="${principal.user.userId}"/>
	
<div class="container header">
	<nav class="navbar navbar-expand bg-white navbar-light fiexed-top">
	
		<div class="menu_wrap collapse navbar-collapse justify-content-end">
		<c:choose>
			<c:when test="${empty principal}">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link" href="/auth/loginForm">LOGIN&nbsp;&nbsp; |</a></li>
					<li class="nav-item"><a class="nav-link" href="/auth/joinForm">JOIN&nbsp;&nbsp; |</a></li>
					<li class="nav-item"><a class="nav-link" href="/${principal.user.userId}/update">MYPAGE&nbsp;&nbsp; |</a></li>
					<li class="nav-item"><a class="nav-link" href="/auth/loginForm">ORDER&nbsp;&nbsp; |</a></li>
				</ul> 
			</c:when>
			<c:otherwise>
				<ul class="navbar-nav">
				<!--관리자만 MANAGERPAGE 사용  -->
					<li>${principal.user.userId }님 환영합니다.</li>
					<c:if test="${principal.user.role eq 'ADMIN'}">
						<li class="nav-item"><a class="nav-link" href="/admin/managerPage">MANAGERPAGE&nbsp;&nbsp; |</a></li>
					</c:if>
					<li class="nav-item"><a class="nav-link" href="/logout">LOGOUT&nbsp;&nbsp; |</a></li>
					<li class="nav-item"><a class="nav-link" href="/${principal.user.userId}/update">MYPAGE&nbsp;&nbsp; |</a></li>
					<li class="nav-item"><a class="nav-link" href="/board/${principal.user.userId}/orderPage">ORDER&nbsp;&nbsp; |</a></li>
				</ul>
			</c:otherwise>
	</c:choose>
		</div>
	</nav>
	<hr>
	<nav class="navbar navbar-expand bg-white navbar-light">
			<a class="navbar-brand font-weight-bold" href="/">NiceShop</a>
		<div class="menu_wrap2 collapse navbar-collapse justify-content-center" id="collapsibleNavbar">
			<ul class="navbar-nav justify-content-center">
				<li class="nav-item"><a class="nav-link" href="/board/best">NEW ARRIVAL</a></li>
			</ul>
		</div>
	</nav>
</div>
	<br>