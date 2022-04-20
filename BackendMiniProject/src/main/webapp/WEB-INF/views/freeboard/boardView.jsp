<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script src="${url}/script/category1.js"></script>
<script src="${url}/script/freeboardView.js"></script>
<link rel="stylesheet" href="${url}/css/category.css" type="text/css"/>
<link rel="stylesheet" href="${url}/css/boardView.css" type="text/css"/>
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon">
<link rel="icon" href="/favicon.ico" type="image/x-icon">

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
	
	<!-- 게시글 보기 -->
	<div id="contentView">
		<a href="javascript:location.href='${url}/freeboard/boardList'" title="글목록"><img src="${url}/img/icon_arrow.png" id="arrow"/></a>
		<!-- 제목 -->
		<div class="content_title">
			 ${vo.subject}
		</div>
		
		<!-- 작성자 -->
		<div class="content_info">
			<span>${vo.username}</span>
			<span>${vo.writedate}&nbsp;&nbsp;${vo.ismodified}</span>
			<c:if test="${logid==vo.userid}">
				<a href="${url}/freeboard/boardEdit?fno=${vo.fno}">수정</a> /
				<a href="${url}/freeboard/boardDelete?fno=${vo.fno}">삭제</a>
			</c:if>
		</div>

		<!-- 본문 -->
		<div class="content_body">
			${vo.content}
		</div>

		<!-- 댓글 -->
		<button id="commentBtn"><img src="${url}/img/icon_comment.png">댓글</button>
		<div id="comment">
			<ul class="list-group list-group-flush">
			<c:forEach var="fVO" items="${fList}">
				  <li class="list-group-item">
					  <span class="commentname">${fVO.username}</span><br/>
					  <div>
					 	 <div class="commentList">
					 	 	<label>${fVO.content}</label>
							  <c:if test="${logid==fVO.userid}">
							  <a href="#none" class="cdelete">삭제</a>
								<a href="#none" class="cmodify">수정/</a>
								<input type="hidden" name="fcomno" value="${fVO.fcomno}"/>
							  </c:if>
						  </div>
						<c:if test="${logid==fVO.userid}">
						  	<div class="commentEdit">
								  <form	method="post" class="commentEditFrm">
								  	<input type="hidden" name="fcomno" value="${fVO.fcomno}"/>
								  	<textarea name="content">${fVO.content}</textarea>
								  	<input type="button" value="취소"/>
								  	<input type="submit" value="수정"/> 	
								  </form>
							 </div>
					  </c:if>
					  </div>
				  	<span class="commentdate">${fVO.writedate}&nbsp;&nbsp;${fVO.ismodified}</span><br/>	
				  </li>
			  </c:forEach>
			</ul>
			<c:if test="${logStatus=='Y'}">
				<form method="post" action=" ${url}/freecomment/insert" id="commentFrm">
					<input type="hidden" name="fno" value="${vo.fno}"/>
					<input type="hidden" name="userid" value="${logid}"/>
					<input type="hidden" name="username" value="${logname}"/>
					<textarea name="content" id="commentContent"></textarea>
					<input type="submit" value="등록"/>
				</form>
			</c:if>
		</div>
	</div>
</div>