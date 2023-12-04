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
    <c:forEach var="pag" items="${page.content}">
        <div>
         totalPages : "${page.totalPages}" // 총 페이지 수
         pageNumber : "${page.number}" //현재 페이지 넘버
         pageSize : "${page.size}" //페이지당 게시글 수
         first : "${page.first}"
         last : "${page.last}"
         numberOfElemments : "${page.numberOfElements}" //페이지의 게시글
         totalElements : "${page.totalElements}" //게시글 총 개수

        </div>
  	</c:forEach>
</div>

<%@ include file="layout/footer.jsp"%>
