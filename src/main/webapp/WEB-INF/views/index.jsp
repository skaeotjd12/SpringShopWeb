<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="layout/header.jsp"%>
<style>
	.card{
		display: inline-block;
	}
</style>

<!-- 검색 -->
<form action="/board/search" method="GET">
    <div class="btn-group" role="group" aria-label="Basic example">
        <input name="keyword" type="text" placeholder="검색어를 입력해주세요">
        <button class="btn btn-primary">검색</button>
    </div>
</form>

<div class="indexContainer">


<c:forEach var="prd" items="${prds.content}">
<div class="card" style="width:400px">
  <img class="card-img-top" src="/upload/${prd.prdFilename}" alt="Card image"/>


  <div class="card-body">
    <h4 class="card-title">${prd.prdName}</h4>
    <p class="card-text"><b>${prd.prdPrice }원</b></p>
    <a href="/board/${prd.prdNum}" class="btn btn-primary">상세보기</a>
  </div>
  </div>
</c:forEach>
</div>

<%@ include file="layout/footer.jsp"%>
