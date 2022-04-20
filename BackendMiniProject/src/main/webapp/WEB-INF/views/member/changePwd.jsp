<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="${url}/script/category2.js"></script>
<script src="${url}/script/mypage.js"></script>
<link rel="stylesheet" href="${url}/css/category.css" type="text/css"/>
<link rel="stylesheet" href="${url}/css/changepwd.css" type="text/css" />
<div class="container">
	<!-- 카테고리 메뉴 -->
	<div id="category">
		<nav>
			<ul>
				<li>마이 페이지</li>
			</ul>
			<ul>
				<li><a href="${url}/member/myPage">나의 정보</a></li>
			</ul>		
			<ul>
				<li><a href="${url}/member/changePwd"><b>비밀번호 변경</b></a></li>
			</ul>
		</nav>
		<div id="category_bar">
			<a href=""><img src="${url}/img/icon_arrowleft.png"></a>
			<a href=""><img src="${url}/img/icon_arrowright.png"></a>
		</div>
	</div>
	
	<!-- 콘텐츠 -->
	<div id="mycontent">
		<form method="post" action="/myapp/member/pwdChangeOk" id="changepwd">
			<div class="form-group join-group">
				<label for="userpwd">현재 비밀번호</label><br/>
				<input type="password" name="userpwd" id="userpwd" placeholder="현재 비밀번호를 입력하세요"/>
			</div>
			<div class="form-group join-group">
				<label for="userpwd2">변경할 비밀번호</label><br/>
				<input type="password" name="userpwd2" id="userpwd2" placeholder="변경할 비밀번호를 입력하세요" title="8~12글자(영어, 숫자, _만 입력 가능)"/>
			</div>
			<div class="form-group join-group">
				<label for="userpwd3">비밀번호 확인</label><br/>
				<input type="password" name="userpwd3" id="userpwd3" placeholder="비밀번호 확인"/>
			</div>
			<a href="${url}/member/changePwd"><input type="submit" id="modifyBtn"value="수정"/></a>
		 	<a href="${url}/"><input type="button" id="cancelBtn" value="취소"/></a>
	 	</form>
	</div>
</div>