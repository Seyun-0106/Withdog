<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="url" value="<%=request.getContextPath()%>" />

<div class="container" id="menu">
	<nav>
		<ul>
			<li><a href="${url}/tripboard/boardList">동반여행</a></li>
		</ul>
		<ul>
			<li><a href="${url}/calendar/calendarView">펫캘린더</a></li>
		</ul>
		<ul>
			<li><a href="${url}/freeboard/boardList">커뮤니티</a></li>
		</ul>
		<ul>
			<li><a href="${url}/member/myPage">마이페이지</a></li>
		</ul>
	</nav>
</div>
<!-- content -->
<div id="content">
	<div id="slideImg" class="carousel slide" data-ride="carousel" data-interval="2700">
		<!-- carousel 전체 start -->
		<!-- icon : controller -->
		<ul class="carousel-indicators">
			<li data-target="#slideImg" data-slide-to="0" class="active"></li>
			<li data-target="#slideImg" data-slide-to="1"></li>
			<li data-target="#slideImg" data-slide-to="2"></li>
			<li data-target="#slideImg" data-slide-to="3"></li>
		</ul>
		<!-- content -->
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="${url}/img/coco.jpg" class="rounded-circle" />
			</div>
			<div class="carousel-item">
				<img src="${url}/img/coco2.jpg" class="rounded-circle" />
			</div>
			<div class="carousel-item">
				<img src="${url}/img/coco3.jpg" class="rounded-circle" />
			</div>
			<div class="carousel-item">
				<img src="${url}/img/coco4.jpg" class="rounded-circle" />
			</div>
		</div>
		<div id="intro">
			<h5>
				반려동물과 함께 만들어갈 추억을 <b>함께할</b><span>개</span> 가 응원합니다.
			</h5><br />
			<b>함께할개</b>는 반려동물과 함께 특별한 추억을 만들기 위해 반려동물 동반 가능 음식점, 카페, 숙소 등을<br />
			반려인들과 함께 공유하고, 반려동물 관련 행사 소식을 접할 수 있는 커뮤니티 공간입니다.<br />
		</div>
	</div>
</div>
<div id="imgdiv">
	<div>
		<img src="${url}/img/icon_dog2.png"/>
		<img src="${url}/img/icon_dog3.png"/>
		<img src="${url}/img/icon_dog5.png"/>
		<img src="${url}/img/icon_dog6.png"/>
		<img src="${url}/img/icon_dog7.png"/>
		<img src="${url}/img/icon_dog8.png"/>
	</div>
</div>