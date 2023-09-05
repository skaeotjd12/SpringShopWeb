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
  	
	<c:forEach var="replys" items="${replys.content}">
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
	<c:choose>
		<c:when test="${replys.first}">
			<li class="page-item disabled"><a class="page-link" href="?page=${replys.number-1 }">Previous</a></li>
		</c:when>
		<c:otherwise>
			<li class="page-item"><a class="page-link" href="?page=${replys.number-1 }">Previous</a></li>
		</c:otherwise>
	</c:choose>    	
	<c:choose>
	<c:when test="${replys.last}">
	<li class="page-item disabled" ><a class="page-link" href="?page=${replys.number+1 }">Next</a></li>
	</c:when>
	<c:otherwise>
				<li class="page-item"><a class="page-link" href="?page=${replys.number+1}">Next</a></li>
			</c:otherwise>
		</c:choose>    
    </ul>


    
  </div>
<script src="/js/reply.js"></script>
<script src="/js/like.js"></script>
	  <%@ include file="../layout/footer.jsp"%>
