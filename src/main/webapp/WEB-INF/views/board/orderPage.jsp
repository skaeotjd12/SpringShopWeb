<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<body>
	<h1 style="text-align:center">주문 내역</h1>
<div>
<c:forEach var="order" items="${orders.content}">
<table class="table">
<div class="joinContainer">
    <thead>
      <tr>
        <th>주문 날짜</th>
        <th>상품명</th>
        <th>상품 가격</th>
        <th>구매 수량</th>
        <th>총 금액</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>${order.createDate}</td>
		<td>${order.product.prdName}</td>
		<td>${order.product.prdPrice}원</td>
		<td>${order.orderCount}개</td>
		<td>${order.orderPrice}원</td>
    </tr>
  </tbody>
</div>
</table>
</c:forEach>
</div>

</body>
<%@ include file="../layout/footer.jsp"%>
