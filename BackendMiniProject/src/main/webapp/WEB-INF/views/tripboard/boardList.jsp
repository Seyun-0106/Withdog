<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="${url}/script/category1.js"></script>
<script src="${url}/script/trip.js"></script>
<script src="${url}/script/boardView.js"></script>
<link rel="stylesheet" href="${url}/css/category.css" type="text/css"/>
<link rel="stylesheet" href="${url}/css/trip.css" type="text/css"/>
<div class="container">
	<!-- 카테고리 메뉴 -->
	<div id="category">
		<nav>
			<ul>
				<li>카테고리</li>
			</ul>
			<ul>
				<li><a href="${url}/tripboard/boardList"><b>동반여행</b></a></li>
			</ul>
			<ul>
				<li><a href="${url}/calendar/calendarView">펫캘린더</a></li>
			</ul>
			<ul>
				<li id="community">커뮤니티
					<div id="hidden_category">
						<ul>
							<li><a href="${url}/freeboard/boardList">자유게시판</a></li>
						</ul>
					</div>
				</li>
			</ul>
		</nav>
		<div id="category_bar">
			<a href="javascript:void(0);"><img src="${url}/img/icon_arrowleft.png"></a>
			<a href="javascript:void(0);"><img src="${url}/img/icon_arrowright.png"></a>
		</div>
	</div>
	<!-- content -->
	<div id="content2">
		<form method="get" action="/myapp/tripboard/boardList" id="searchFrm2">
			<div id="checkList"><!-- 체크 -->
				<input type="checkbox" name="category" value="cafe" id="cafe">
				<input type="button" value="카페" id="cafeBtn">
				<input type="checkbox" name="category" value="eatery" id="eatery">
				<input type="button" value="음식점" id="eateryBtn">
				<input type="checkbox" name="category" value="stay" id="stay">
				<input type="button" value="숙박" id="stayBtn">
				<input type="checkbox" name="category" value="pool" id="pool">
				<input type="button" value="수영장" id="poolBtn">
			</div>
			
			<div id="selection">
				<!-- 지역 선택 -->
				<select id="selectArea" name="area">
					<option value="total">전체 지역</option>
					<option value="서울">서울</option>
					<option value="인천">인천</option>
					<option value="경기">경기</option>
					<option value="강원">강원</option>
					<option value="대전">대전</option>
					<option value="충남">충남</option>
					<option value="충북">충북</option>
					<option value="광주">광주</option>
					<option value="전남">전남</option>
					<option value="전북">전북</option>
					<option value="부산">부산</option>
					<option value="경남">경남</option>
					<option value="대구">대구</option>
					<option value="경북">경북</option>
					<option value="제주">제주</option>
				</select>
				<input type="submit" value="검색"/>
			</div>
		</form>
	</div>
	<!-- 게시판 -->
	<div id="list_board">
		<!-- 검색filter -->
		<form method="get" action="/myapp/tripboard/boardList" id="searchFrm">
			<select name="searchKey" id="searchKey">
				<option value="subject">제목</option>
				<option value="username">작성자</option>
				<option value="content">내용</option>
			</select>
			<input class="form-control" type="text" name="searchWord" id="searchWord" placeholder="검색어를 입력하세요">
			<input type="submit" id="searchBtn" value="검색">
		</form>
		<table class="table">
			<thead>
				<tr>
					<th style="width: 10%">번호</th>
					<th style="width: 65%">제목</th>
					<th style="width: 10%">작성자</th>
					<th style="width: 15%">작성일</th>
				</tr>
			</thead>
			<tbody id="boardList">
				<c:forEach var="vo" items="${list}">
					<tr>
						<td>${vo.no}</td>
						<td class="titlecut"><a href="${url}/tripboard/boardView?no=${vo.no}">${vo.subject}</a></td>
						<td>${vo.username}</td>
						<td>${vo.writedate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:if test="${logStatus=='Y'}">	
			<a href="${url}/tripboard/boardWrite"><button id="writeBtn">글쓰기</button></a><br />
		</c:if>
		<!-- 페이징 -->
	    <ul class="pagination pagination-sm justify-content-center">
	    	<!-- prev -->
	    	<c:if test="${pVO.pageNum==1}">
	    		<li class="page-item disabled"><a href="" class="page-link">prev</a></li>
	    	</c:if>
	    	<c:if test="${pVO.pageNum>1}">
	    		<li class="page-item"><a href="/myapp/tripboard/boardList?pageNum=${pVO.pageNum-1}
	    		<c:if test='${pVO.searchWord!=null}'>
	    			&searchKey=${pVO.searchKey}
	    			&searchWord=${pVO.searchWord}
	    		</c:if>
	    		" class="page-link">prev</a></li>
	    	</c:if>
	    	
	    	<!-- pageNum -->
	    	<c:forEach var="p" begin="${pVO.startPage}" end="${pVO.startPage+pVO.onePageCount-1}">
	    		<c:if test="${p<=pVO.totalPage}">
	    			<c:if test="${p==pVO.pageNum}">
	    				<li class="page-item active">
	    			</c:if>
	    			<c:if test="${p!=pVO.pageNum}">
	    				<li class="page-item">
	    			</c:if>
	    			<a href="/myapp/tripboard/boardList?pageNum=${p}
		    			<c:if test="${pVO.searchWord!=null}">
		    				&searchKey=${pVO.searchKey}&searchWord=${pVO.searchWord}
		    			</c:if>
	    			"  class="page-link">${p}</a></li>
	    		</c:if>
	    	</c:forEach>
			
			<c:if test="${pVO.pageNum==pVO.totalPage}">
				<li class="page-item disabled"><a href="" class="page-link">next</a></li>
			</c:if>
			<c:if test="${pVO.pageNum<pVO.totalPage}">
				<li class="page-item"><a href="/myapp/tripboard/boardList?pageNum=${pVO.pageNum+1}" class="page-link">next</a></li>
			</c:if>
		</ul>
	</div>
</div>