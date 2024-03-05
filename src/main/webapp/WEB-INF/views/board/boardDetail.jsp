<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

	<div>
		${prd.prdDetail}
	</div>
	<br><br><br><br><br><br>
		
	<c:choose>
			<c:when test="${prd.likeState}">
	<!-- 좋아요 버튼 -->
	<div>
	<button id="btn-unlike" onclick="unlike(${prd.prdNum})" >
			<img  src="../image/unlike.png" width="50px"  />
	</button>
	</div>
	</c:when>
	<c:otherwise>
	<div>
	<button id="btn-like" onclick="like(${prd.prdNum})" >
		<img  src="../image/like.png" width="50px"  />
	</button>
	</div>
	</c:otherwise>
		</c:choose>
	${prd.likeCount}개
	
	<!-- 상품 구매 버튼 orderform으로 이동 -->
	<div>
		<a href="/board/${prd.prdNum}/${principal.user.userId}/orderForm" class="btn btn-primary">구매</a>
	</div>
	</br>



     <c:choose>
        <c:when test="${keyword eq null}">
            <a href="/?page=${page}" class="btn btn-primary">목록</a>
        </c:when>
        <c:otherwise>
            <a href="/board/search?page=${page}&keyword=${keyword}" class="btn btn-primary">목록</a>
        </c:otherwise>
     </c:choose>


	<hr>
	<!-- 댓글 입력 영역 -->
<div class="card-body">
  <form class="form-horizontal">
	<input type="hidden" id="userId" value="${principal.user.userId}">  
	<input type="hidden" id="prdNum" value="${prd.prdNum}">  
    <div class="row">
      <div class="form-group col-sm-8">
        <input class="form-control input-sm" id="replyText" type="text" placeholder="댓글 입력...">
      </div>
      <div class="form-group col-sm-2">
        <button type="button" class="btn btn-primary btn-sm btn-block" id="btn-addReply" >
        <i class="fa fa-save"></i> 저장
      </button>
      </div>
    </div>	
  </form>	
</div>

  <%--댓글 유무 / 댓글 갯수 / 댓글 펼치기, 접기--%>
  
<div class="card card-primary card-outline">
  <div class="card-header">
  <a href="" class="link-black text-lg"><i class="fas fa-comments margin-r-5 replyCount"></i></a>
    <div class="card-tools">
      <button type="button" class="btn primary"  data-widget="collapse">
          <i class="fa fa-plus"></i>
      </button>
    </div>
  </div>
  
  <%--댓글 목록--%>
  	
	<c:forEach var="replys" items="${pages.content}">
	<div>
		<h2>${replys.user.userName} : ${replys.replyText}</h2>

	<%-- 본인 댓글 삭제, 유저 타입 'ADMIN'만 삭제 가능토록 버튼 구현 --%>
			<c:if test="${principal.user.userId eq replys.user.userId or principal.user.role eq 'ADMIN'}">
				<button class="btn btn-primary" onclick="deleteReply(${replys.replyId})"">댓글 삭제</button>
			</c:if>
	<hr>
	</div>
	</c:forEach>


<%--댓글 페이징--%>
    <ul class="pagination justifu-content-center">

<%--이전, 처음 버튼 분기 --%>
	<c:choose>
		<c:when test="${pages.first}">
		     <li class="page-item disabled"><a class="page-link">처음</a></li>
			<li class="page-item disabled"><a class="page-link">이전</a></li>
		</c:when>

		<c:when test="${startPage eq '1'}">
		                 <li class="page-item disabled"><a class="page-link" href="?page=1&keyword=${keyword}">처음</a></li>
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
	<li class="page-item disabled"><a class="page-link" >끝</a></li>
	</c:when>
	<c:when test="${endPage eq pages.totalPages}">
        <li class="page-item" ><a class="page-link" href="?page=${pages.number+2}&keyword=${keyword}">다음</a></li>
        <li class="page-item disabled"><a class="page-link" href="?page=${pages.totalPages}&keyword=${keyword}">끝</a></li>
    </c:when>
	    <c:otherwise>
			<li class="page-item "><a class="page-link" href="?page=${endPage + 1}&keyword=${keyword}">다음</a></li>
            <li class="page-item"><a class="page-link" href="?page=${pages.totalPages}&keyword=${keyword}">끝</a></li>
        </c:otherwise>
		</c:choose>
    </ul>
</div>
<script src="/js/reply.js"></script>
<script src="/js/like.js"></script>
	  <%@ include file="../layout/footer.jsp"%>
