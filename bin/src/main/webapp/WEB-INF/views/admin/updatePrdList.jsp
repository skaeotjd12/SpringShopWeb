<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../layout/header.jsp"%>
<style>
	.card{
		display: inline-block;
	}
</style>
<h2>상품 수정 리스트</h2>
<div class="indexContainer">

<c:forEach var="prd" items="${prds}">
 
<div class="card" style="width:400px">
  <img class="card-img-top" src="../productImg/${prd.prdFilename}" alt="Card image"/>
  <div class="card-body">
    <h4 class="card-title">${prd.prdName }</h4>
    <p class="card-text"><b>${prd.prdPrice }원</b></p>
    <a href="/admin/${prd.prdNum}/updateProductForm" class="btn btn-primary">상품 수정</a>
	<button type="button"  class="btn btn-primary" onclick="deletePrd(${prd.prdNum})"">상품 삭제</button>
  </div>
  </div>
  	</c:forEach>
</div>
<script src="/js/admin.js"></script>
<%@ include file="../layout/footer.jsp"%>
