<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<style>
.joinContainer {
		margin : 100px;
		width : 60%;
	}
	.joinContainer form div{
	margin-left : 150px;
	font-weight: bold;
	display: block;
	}
	.ctg{
		border: 1px;
		border-style: solid;
		display: inline-block;
		position: relative;
	}
</style>
<h1 style="text-align:center">상품 구매</h1>

<div class="joinContainer">
    <form  id="form">
    	<div class="ctg"  >
    	상품 카테고리&nbsp;&nbsp;| ${prd.prdCtg }
    	<input type="hidden" class="form-control" value="${prd.prdCtg }"id="prdCtg" readonly="readonly" >
  		</div>
        <br>
        
        <input type="hidden"  id="prdNum" value="${prd.prdNum}" >
        <div class="form-group">
			<label for="prdName">상품 이름</label>
			<input type="text" class="form-control" value="${prd.prdName }" id="prdName" readonly="readonly">
		</div>
		
		<div class="form-group">
			<label for="prdPrice">상품 가격</label>
			<input type="text" class="form-control" value="${prd.prdPrice }" id="prdPrice" readonly="readonly">
		</div>
		
		<div class="form-group">
			<label for="orderCount">구매 수량</label>
			<input type="text" class="form-control" placeholder="Enter prodCount" id="orderCount">
			<button type="button" id="btn-orderCount" class="btn btn-primary" onclick="orderPriceBtn(${prd.prdPrice},$(`#orderCount`).val())">적용</button>
		</div>
		
		<div class="form-group">
			<label for="orderPrice">구매 총 금액</label>
			<input type="text" class="form-control"  id="orderPrice"  readonly="readonly"/>
		</div>
		
        <br>
		</form>
		<button type="button" id="btn-orderPrd" class="btn btn-primary">상품 구매</button>
</div>

<script src="/js/order.js"></script>
	  <%@ include file="../layout/footer.jsp"%>