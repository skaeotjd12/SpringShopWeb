<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="layout/header.jsp"%>
<style>
	.card{
		display: inline-block;
	}
</style>

<%-- 검색 --%>
<form action="/board/search" method="GET">
    <div class="btn-group" role="group" aria-label="Basic example">
        <input name="keyword" type="text" placeholder="검색어를 입력해주세요">
        <button class="btn btn-primary">검색</button>
    </div>
</form>

<div class="indexContainer">


<c:forEach var="prd" items="${pages.content}">
<div class="card" style="width:400px">
  <img class="card-img-top" src="/upload/${prd.prdFilename}" alt="Card image"/>


  <div class="card-body">
    <h4 class="card-title">${prd.prdName}</h4>
    <p class="card-text"><b>${prd.prdPrice }원</b></p>

    <%--상세보기 검색, 메인화면 분기 --%>
    <c:choose>
            <c:when test="${keyword eq null}">
                <a href="/board/${prd.prdNum}?page=1&keyword=""" class="btn btn-primary">상세보기</a>
            </c:when>
            <c:otherwise>
                <a href="/board/${prd.prdNum}?page=1&keyword=${keyword}" class="btn btn-primary">상세보기</a>
            </c:otherwise>
         </c:choose>

  </div>
  </div>
</c:forEach>
</div>
<c:choose>
<c:when test="${keyword eq null}">


<%--댓글 페이징--%>
    <ul class="pagination justifu-content-center">

<%--이전, 처음 버튼 분기 --%>
	<c:choose>
		<c:when test="${pages.first}">
		     <li class="page-item disabled"><a class="page-link" href="?page=1">처음</a></li>
			<li class="page-item disabled"><a class="page-link">이전</a></li>
		</c:when>

		<c:when test="${startPage eq '1'}">
		                 <li class="page-item disabled"><a class="page-link" href="?page=1">처음</a></li>
        		        <li class="page-item"><a class="page-link" href="?page=${startPage}">이전</a></li>

        </c:when>
		<c:otherwise>
		     <li class="page-item"><a class="page-link" href="?page=1">처음</a></li>
            <li class="page-item"><a class="page-link" href="?page=${startPage-1}">이전</a></li>
		</c:otherwise>
	</c:choose>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <%--페이지 번호 --%>
<c:forEach var = "num" begin = "${startPage}" end = "${endPage}"  step="1">
		<c:choose>
			<c:when test="${pages.number+1 eq num}">
				 <span> ${num} </span>
			</c:when>
			<c:otherwise>
				<span><a href="?page=${num}">	 ${num}</a></span>
			</c:otherwise>
		</c:choose>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</c:forEach>


<%--다음 , 끝 버튼 분기--%>
	<c:choose>
	<c:when test="${pages.last}">
	<li class="page-item disabled" ><a class="page-link">다음</a></li>
	<li class="page-item disabled"><a class="page-link" href="?page=${pages.totalPages}">끝</a></li>
	</c:when>
	<c:when test="${endPage eq pages.totalPages}">
        <li class="page-item" ><a class="page-link" href="?page=${pages.number+2}">다음</a></li>
        <li class="page-item disabled"><a class="page-link" href="?page=${pages.totalPages}">끝</a></li>
    </c:when>
	    <c:otherwise>
			<li class="page-item "><a class="page-link" href="?page=${endPage + 1}">다음</a></li>
            <li class="page-item"><a class="page-link" href="?page=${pages.totalPages}">끝</a></li>
        </c:otherwise>
		</c:choose>
</ul>

</c:when>
<c:otherwise>
        <%--search 페이징--%>
            <ul class="pagination justifu-content-center">

        <%--이전, 처음 버튼 분기 --%>
        	<c:choose>
        		<c:when test="${pages.first}">
        		     <li class="page-item disabled"><a class="page-link">처음</a></li>
        			<li class="page-item disabled"><a class="page-link">이전</a></li>
        		</c:when>

        		<c:when test="${startPage eq '1'}">
        		                 <li class="page-item disabled"><a class="page-link" >처음</a></li>
                		        <li class="page-item"><a class="page-link" href="?page=${startPage}&keyword=${keyword}">이전</a></li>

                </c:when>
        		<c:otherwise>
        		     <li class="page-item"><a class="page-link" href="?page=1&keyword=${keyword}">처음</a></li>
                    <li class="page-item"><a class="page-link" href="?page=${startPage-1}&keyword=${keyword}">이전</a></li>
        		</c:otherwise>
        	</c:choose>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
              <%--페이지 번호 --%>
        <c:forEach var = "num" begin = "${startPage}" end = "${endPage}"  step="1">
        		<c:choose>
        			<c:when test="${pages.number+1 eq num}">
        				 <span> ${num} </span>
        			</c:when>
        			<c:otherwise>
        				<span><a href="?page=${num}&keyword=${keyword}">	 ${num}</a></span>
        			</c:otherwise>
        		</c:choose>
        		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        	</c:forEach>


        <%--다음 , 끝 버튼 분기--%>
        	<c:choose>
        	<c:when test="${pages.last}">
        	<li class="page-item disabled" ><a class="page-link">다음</a></li>
        	<li class="page-item disabled"><a class="page-link">끝</a></li>
        	</c:when>
        	<c:when test="${endPage eq pages.totalPages}">
                <li class="page-item" ><a class="page-link" href="?page=${pages.number+2}">다음</a></li>
                <li class="page-item disabled"><a class="page-link" href="?page=${pages.totalPages}">끝</a></li>
            </c:when>
        	    <c:otherwise>
        			<li class="page-item "><a class="page-link" href="?page=${endPage + 1}&keyword=${keyword}">다음</a></li>
                    <li class="page-item"><a class="page-link" href="?page=${pages.totalPages}&keyword=${keyword}">끝</a></li>
                </c:otherwise>
        		</c:choose>
        </ul>
</c:otherwise>
</c:choose>


<%@ include file="layout/footer.jsp"%>
ls