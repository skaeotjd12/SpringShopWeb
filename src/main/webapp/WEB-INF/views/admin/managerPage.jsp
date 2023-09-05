<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ include file="../layout/header.jsp"%>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<style>
	.joinContainer {
		margin : 100px;
	}
	.joinContainer form div{
	margin-left : 150px;
	font-weight: bold;
	display: block;
	}


</style>
<h1 style="text-align:center">상품 관리</h1>
<div class="joinContainer">
  <table class="table">
    <thead>
      <tr>
        <th>상품 관리</th>
      </tr>
    </thead>
    <tbody>
      <tr>
		<td><a href="/admin/addProductForm">상품 등록</td>
      </tr>
      <tr>
        <td><a href="/admin/updateProductList">상품 수정 및 삭제</td>
      </tr>
    </tbody>
  </table>
</div>
<script src="/js/admin.js"></script>
  <%@ include file="../layout/footer.jsp"%>