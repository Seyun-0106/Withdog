<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="${url}/script/category2.js"></script>
<script src="${url}/script/mypage.js"></script>
<link rel="stylesheet" href="${url}/css/category.css" type="text/css"/>
<link rel="stylesheet" href="${url}/css/mypage.css" type="text/css" />

<div class="container">
	<!-- 카테고리 메뉴 -->
	<div id="category">
		<nav>
			<ul>
				<li>마이 페이지</li>
			</ul>
			<ul>
				<li><a href="${url}/member/myPage"><b>나의 정보</b></a></li>
			</ul>		
			<ul>
				<li><a href="${url}/member/changePwd">비밀번호 변경</a></li>
			</ul>
		</nav>
		<div id="category_bar">
			<a href=""><img src="${url}/img/icon_arrowleft.png"></a>
			<a href=""><img src="${url}/img/icon_arrowright.png"></a>
		</div>
	</div>
	
	<div id="mycontent">
		<form method="post" action="/myapp/member/userpwdOk" id="pwdCheck">
			<div>
				<label for="#userpwd">비밀번호</label><br/>
				<input type="password" id="userpwd" name="userpwd" placeholder="현재 비밀번호를 입력하세요"/>
				<input type="submit" id="checkBtn" value="확인"/>
			</div>
		</form>
	</div>
</div>
