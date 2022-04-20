<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="${url}/script/category2.js"></script>
<script src="${url}/script/mypage.js"></script>
<link rel="stylesheet" href="${url}/css/category.css" type="text/css"/>
<link rel="stylesheet" href="${url}/css/mypage.css" type="text/css"/>
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
		<form method="post" action="/myapp/member/memberEditOk" id="infoFrm">
				<div class="form-group join-group">
					<label>아이디</label><br/>
					<input type="text" id="userid" name="userid" disabled value="${vo.userid}"/>
				</div>
				<div class="form-group join-group">
					<label>이메일</label><br/>
					<input type="text" id="email" name="email" value="${vo.email}"/>
				</div>
				<div class="form-group join-group">
					<label for="username">닉네임</label><br/>
					<input type="text" id="username" name="username" value="${vo.username}"/>
					<input type="button" id="checkName" value="중복확인">
					<input type="hidden" id="nameChk" value="N"/>
				</div>
				<input type="submit" id="modifyBtn" value="수정"/>
		 		<a href="${url}/member/myPage"><input type="button" id="cancelBtn" value="취소"/></a>
	 	</form>
	</div>
</div>