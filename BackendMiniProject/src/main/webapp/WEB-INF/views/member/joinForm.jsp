<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="url" value="<%=request.getContextPath()%>" />
<script src="${url}/script/login_join.js"></script>
<link rel="stylesheet" href="${url}/css/login_join.css" />
<script>

	$(function(){
		$("#userid").keyup(function(){//아이디 수정될 때마다 idChk value=N으로 변경
			$("#idChk").prop("value","N");
		});
		
		$("#checkId").click(function(){
			var userid = $("#userid").val();
			
			//유효성 검사
			var reg = /^[a-zA-Z]{1}\w{7,11}$/;
			if (userid== "") {
				alert("아이디를 입력하세요.");
				$("#userid").focus();
				return false;
			}
			if (!reg.test(userid)) {
				alert("아이디를 잘못 입력하였습니다.\n첫 문자는 영어로 입력, 8~12글자(영어, 숫자, _만 입력 가능)");
				$("#userid").focus();
				return false;
			}
			
			var url = "/myapp/member/memberIdCheck";
			$.ajax({
				url : url,
				data : "userid="+userid,
				type : "POST",
				success : function(result){
					if(result>0){	//사용불가
						alert('아이디 중복 \n다른 아이디를 입력하세요.');
						$("#idChk").prop("value","N");
					}else{	//사용가능
						if(confirm('사용할 수 있는 아이디입니다. \n해당 아이디를 사용하시겠습니까?')){
							$("#idChk").prop("value","Y");
						}
					}
				},
				error : function(e){
					console.log(e.responseText);
				}
			});
			
		});
		
		$("#checkName").click(function(){
			
			var username = $("#username").val();
			console.log(username);
			
			$("#username").keyup(function(){
				$("#nameChk").prop("value","N");
			});
			
			if (username== "") {
				alert("닉네임을 입력하세요.");
				$("#username").focus();
				return false;
			}
			
			if (username.length < 2 || username.length > 8) {
				alert("닉네임을 잘못 입력하였습니다.\n 닉네임은 2~8글자");
				$("#username").focus();
				return false;
			}
			
			var url = "/myapp/member/memberNameCheck";
			$.ajax({
				url : url,
				data : "username="+username,
				type : "POST",
				success : function(result){
					if(result>0){	//사용불가
						alert('닉네임 중복 \n다른 닉네임을 입력하세요.');
						$("#nameChk").prop("value","N");
					}else{	//사용가능
						if(confirm('사용할 수 있는 닉네임입니다. \n해당 닉네임을 사용하시겠습니까?')){
							$("#nameChk").prop("value","Y");
						}
					}
				},
				error : function(e){
					console.log(e.responseText);
				}
			});
		});
	});

</script>
<div class="container">
	<div id="join">
		<div>
			<h5>회원가입</h5>
			<form method="post" action="/myapp/member/joinOk" id="joinform" onsubmit="return joinFormCheck()">
				<input type="hidden" id="idChk" value="N"/>
				<input type="hidden" id="nameChk" value="N"/>
				<div class="form-group join-group">
					<label for="#userid">아이디</label><br/>
					<input type="text" name="userid" id="userid" placeholder="아이디를 입력하세요." title="첫 문자는 영어, 8~12글자(영어, 숫자, _만 입력 가능)" />
					<input type="button" id="checkId" value="중복확인">
				</div>
				<div class="form-group join-group">
					<label for="#userpwd">비밀번호</label><br/>
					<input type="password" name="userpwd" id="userpwd" placeholder="비밀번호를 입력하세요" title="8~12글자(영어, 숫자, _만 입력 가능)" />
				</div>
				<div class="form-group join-group">
					<label for="#userpwd2">비밀번호 확인</label><br/>
					<input type="password" name="userpwd2" id="userpwd2" placeholder="비밀번호 확인" />
				</div>
				<div class="form-group join-group">
					<label for="#email">이메일</label><br/>
					<input type="text" name="email" id="email" placeholder="이메일을 입력하세요" title="예시) withdog@naver.com" />
				</div>
				<div class="form-group join-group">
					<label for="#username">닉네임</label><br/>
					<input type="text" name="username" id="username" placeholder="닉네임을 입력하세요" title="2~8글자" />
					<input type="button" id="checkName" value="중복확인">
				</div>
				<input type="submit" value="가입" />
				<a href="${url}/"><input type="button" value="취소"/></a>
			</form>
		</div>
	</div>
</div>
