<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ include file="../layout/header.jsp"%>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function addressPopup() {
        new daum.Postcode({
            oncomplete: function(data) {
               
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                if(data.userSelectedType === 'R'){
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("sample6_extraAddress").value = '';
                }

                document.getElementById('userZipcode').value = data.zonecode;
                document.getElementById("userAddr").value = addr;
                document.getElementById("userDetailAddr").focus();
            }
        }).open();
    }
</script>
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
<h1 style="text-align:center">JOIN</h1>

<div class="joinContainer">
<form>
		<div class="form-group">
			<label for="username">이름</label>
			<input type="text" class="form-control" placeholder="Enter username" id="userName">
		</div>
		
		<div class="form-group">
			<label for="userId">아이디</label>
			<input type="text" class="form-control" placeholder="Enter userid" id="userId">
		</div>
		
		<div class="form-group">
			<label for="userPwd">비밀번호</label>
			<input type="password" class="form-control" placeholder="Enter password" id="userPwd">
		</div>

		<div class="form-group">
			<label for="userPwd_Ok">비밀번호 확인</label> 
			<input type="password" class="form-control" placeholder="Enter password" id="userPwd_Ok">
		</div>
		
		<div class="form-group">
			<label for="email">이메일</label> 
			<input type="email" class="form-control" placeholder="Enter email" id="userEmail">
		</div>
		
		<div class="form-group">
			<label for="addr">주소</label> 
				<input  type="text" id="userZipcode" placeholder="우편번호">
				<input  type="button" onclick="addressPopup()" value="우편번호 찾기"><br>
				<input  type="text" id="userAddr" size="50" placeholder="주소" ><br>
				<input  type="text" id="userDetailAddr" size="20" placeholder="상세주소" >
				<input  type="text" id="sample6_extraAddress" size="30" placeholder="참고항목" readonly="readonly">
		</div>
		
		<div class="mb-3">
				<label class="form-label" for="date">생년월일</label>
				<input class="form-control"  id="userBirth" type="date">
				
			</div>
		
	</form>

	<button  id="btn-save" class="btn btn-primary">회원가입완료</button>
	
</div>
<script src="/js/user.js"></script>
  <%@ include file="../layout/footer.jsp"%>