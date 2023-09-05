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
<h1 style="text-align:center">상품 수정</h1>

<div class="joinContainer">
    <form enctype="multipart/form-data" id="form">
    <input type="hidden" id="prdNum"  value="${prdNum}">
    	<div class="ctg">
    	상품 카테고리&nbsp;&nbsp;|
  			<label class="form-check-label">
    			상의&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="form-check-input"  type="radio" name="selectOption1"  onchange="get_option2(selectOption1.value, selectOption2)" value="TOP">
  			</label>
		
	
		 	<label class="form-check-label">
		    	하의&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input class="form-check-input"  type="radio" name="selectOption1" onchange="get_option2(selectOption1.value, selectOption2)" value="BOTTOM">
  			</label>
	
		
        <select id="prdCtg" size="1" class="selectpicker" name="selectOption2">
            <option value="option2">중분류</option>
        </select>
        </div>
        <br>
        
        <div class="form-group">
			<label for="prdName">상품 이름</label>
			<input type="text"  class="form-control" placeholder="Enter username" id="prdName" >
		</div>
		
		
		<div class="form-group">
			<label for="prdPrice">상품 가격</label>
			<input type="text" class="form-control" placeholder="Enter userid" id="prdPrice">
		</div>
		
		
		<div class="form-group">
			<label for="prdFile">메인 이미지</label>
			<input name="prdFile" type="file" class="form-control" id="prdFile">
		</div>
		
		<div>
		  <select  id="prdStatuts" class="selectpicker">
            <option>상품 상태</option>
            <option value="new">신상품</option>
            <option value="best">베스트</option>
        </select>
        </div>
        <br>
		</form>
<textarea class="summernote " id="prdDetail"></textarea>
		<button type="button" id="btn-updatePrd" class="btn btn-primary">상품 수정</button>
</div>

<script>
	$('.summernote').summernote({
		tabsize : 2,
		height : 300
	});
</script>
<script src="/js/admin.js"></script>