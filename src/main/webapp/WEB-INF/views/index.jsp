<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="layout/header.jsp"%>
<style>
	.card{
		display: inline-block;
	}
</style>
<div class="indexContainer">

<c:forEach var="prd" items="${prds}">
 
<div class="card" style="width:400px">
  <img class="card-img-top" src="../productImg/${prd.prdFilename}" alt="Card image"/>
  <div class="card-body">
    <h4 class="card-title">${prd.prdName}</h4>
    <p class="card-text"><b>${prd.prdPrice }원</b></p>
    <a href="/board/${prd.prdNum}" class="btn btn-primary">상세보기</a>
  </div>
  </div>
  	</c:forEach>
</div>

<%@ include file="layout/footer.jsp"%>
