<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="${url}/script/category1.js"></script>
<script src="${url}/script/calendar.js"></script>
<link rel="stylesheet" href="${url}/css/category.css" type="text/css"/>
<link rel="stylesheet" href="${url}/css/calendar.css" type="text/css"/>
<div class="container">
	<!-- 카테고리 메뉴 -->
	<div id="category">
		<nav>
			<ul>
				<li>카테고리</li>
			</ul>
			<ul>
				<li><a href="${url}/tripboard/boardList">동반여행</a></li>
			</ul>
			<ul>
				<li><a href="${url}/calendar/calendarView"><b>펫캘린더</b></a></li>
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
	<div id="calcontent">
		<div id="content3">
			<a href="javascript:setDate_prev();"><img src="${url}/img/icon_cal_arrowleft.png"/></a>
			<span id="dateTitle"></span>
			<a href="javascript:setDate_next();"><img src="${url}/img/icon_cal_arrowright.png"/></a>
		</div>
		<div id="calendar">
				<ul id="dateView"></ul>
		</div>
		
		<div id="modaldiv" class="modal"><!-- modal -->
			<div class="modal-dialog">
				<div class="modal-content">
					<!-- Header -->
					<div class="modal-header" id="d1">
						<span>일정 등록</span>
						<button class="close" data-dismiss="modal">&times;</button>
					</div>
					<!-- Body -->
					<form method="post" action="${url}/calendar/insert" class="modal-body" id="d2">
						<label for="#addDate">날짜 선택</label><br/>
						<input type="date" name="cdate" id="addDate"/><br/>
						<label for="#addContent">일정명</label><br/>
						<input type="text" name="cname" id="addName"/><br/>
						<label for="#addContent">일정 링크</label><br/>
						<input type="text" name="ccontent" id="addContent" placeholder="url 주소를 입력하세요."/><br/>
						<button data-dismiss="modal" id="addBtn">등록</button>
					</form>
				</div>
			</div>
		</div>
		<div id="schedule_list" class="list-group">
			<div>
				<button id="viewcal"><img src="${url}/img/icon_cal.png" title="일정 확인"/></button>
				<c:if test="${logname=='관리자'}">
					<button id="addcal"><img src="${url}/img/icon_cal_plus.png" data-target="#modaldiv" data-toggle='modal' title="일정 추가"/></button>
					<button><img src="${url}/img/icon_caldelete.png" title="일정 삭제" id="delcal"/></button>
				</c:if>
			</div>
			<div id="schedule_view">
			<!-- 일정 목록 -->
			</div>
			<c:if test="${logname=='관리자'}">
				<div id="schedule_del">
				<!-- 일정 삭제 목록 -->
				</div>
			</c:if>
		</div>
	</div>
</div>