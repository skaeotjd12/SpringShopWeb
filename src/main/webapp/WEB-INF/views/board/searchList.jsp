<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<style>
	.card{
		display: inline-block;
	}
</style>
<div class="indexContainer">



<table>
     <thead>
     <tr>
         <th scope="col">#</th>
         <th scope="col">제목</th>
         <th scope="col">작성자</th>
         <th scope="col">작성시간</th>
     </tr>
     </thead>
         <tbody>
         <c:forEach var="search" items="${searchList}">
         <tr>
             <th scope="row">${search.prdNum}</th>
             <td><a href="/board/${search.prdNum}">${search.prdName}</a><td>
             <td>?</td>
             <td>?</td>
         </tr>
          </c:forEach>
         </tbody>
 </table>

</div>

  <%@ include file="../layout/footer.jsp"%>