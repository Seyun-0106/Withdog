<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="url" value="<%=request.getContextPath()%>" />
<script src="${url}/script/login_join.js"></script>
<link rel="stylesheet" href="${url}/css/login_join.css" />

<div class="container">
	<div id="login">
		<div>
			<h5>로그인</h5>
			<form method="post" action="/myapp/member/loginOk" id="loginform" onsubmit="return loginFormCheck()">
				<div class="form-group">
					<img src="${url}/img/icon_id.png"> <input type="text" name="userid" id="userid" placeholder="아이디를 입력하세요."/>
				</div>
				<div class="form-group">
					<img src="${url}/img/icon_pw.png"> <input type="password" name="userpwd" id="userpwd" placeholder="비밀번호를 입력하세요." />
				</div>
				<a href="/"><input type="submit" id="loginBtn" value="로그인" class="form-control btn" /></a>
				<a href="${url}/member/joinForm"><input type="button" id="joinBtn" value="회원가입" class="from-control btn"/></a>
			</form>
		</div>
	</div>
</div>