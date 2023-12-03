<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="layout/header.jsp"%>
<style>
	.card{
		display: inline-block;
	}
</style>


<div class="indexContainer">
<h1>test</h1>
    <c:forEach var="page" items="${page.content}">
        <div>
         1번 :    "${page.prdNum}"
        </div>
  	</c:forEach>
</div>

<%@ include file="layout/footer.jsp"%>
