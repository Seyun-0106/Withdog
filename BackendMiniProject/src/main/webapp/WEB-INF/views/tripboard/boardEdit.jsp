<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<script src="${url}/ckeditor/ckeditor.js"></script>
<link rel="stylesheet" href="${url}/css/write.css" type="text/css" />

<script>
	$(function() {
		// 글쓰기 폼 이외에 클릭 이벤트가 발생한 경우
		$("#header").click(function() {
			if (!confirm("글 수정을 중단하시겠습니까?")) {
				return false;
			}
		});
		$("#loginImg").click(function() {
			if (!confirm("글 수정을 중단하시겠습니까?")) {
				return false;
			}
		});
		$("#myImg").click(function() {
			if (!confirm("글 수정을 중단하시겠습니까?")) {
				return false;
			}
		});

		// submit 유효성 검사 + 페이지 이동
		$("#writeform").submit(function() {
			
			if ($("#title").val() == "") {
				alert("제목을 입력하세요.");
				return false;
			}

			if ($("#selectArea").val() == null) {
				alert("지역을 선택하세요.");
				return false;
			}

			if ($("input[type=checkbox]").is(":checked")==false) {
				alert("카테고리를 선택하세요.");
				return false;
			}

			var txt = CKEDITOR.instances.tripcontent.getData();
			if (txt == "") {
				alert("글 내용을 입력하세요.");
				return false;
			}
			return true;
		});

		$("#writeform>input[type=button]").click(function() {
			if (confirm("글 수정을 중단하시겠습니까?")) {
				history.back();
			} else {
				return false;
			}
		});
	});
</script>

<div class="container">
	<c:set var = "testStr" value = "${vo.category}"/>

	<form method="post" action="${url}/tripboard/boardUpdate" id="writeform">
		<input type="hidden" name="no" value="${vo.no}"/>
		<div>
			<label for="#title">제목</label>
			<input type="text" name="subject" id="title" value="${vo.subject}"/><br />
			
			<label for="#selctArea">지역선택</label>
			<select id="selectArea" name="area">
			
				<option value="total" 
				<c:if test="${vo.area=='total'}"> selected</c:if>
				>지역선택</option>
				<option value="서울"
				<c:if test="${vo.area=='서울'}"> selected</c:if>
				>서울</option>
				<option value="인천"
				<c:if test="${vo.area=='인천'}"> selected</c:if>
				>인천</option>
				<option value="경기"
				<c:if test="${vo.area=='경기'}"> selected</c:if>
				>경기</option>
				<option value="강원"
				<c:if test="${vo.area=='강원'}"> selected</c:if>
				>강원</option>
				<option value="대전"
				<c:if test="${vo.area=='대전'}"> selected</c:if>
				>대전</option>
				<option value="충남"
				<c:if test="${vo.area=='충남'}"> selected</c:if>
				>충남</option>
				<option value="충북"
				<c:if test="${vo.area=='충북'}"> selected</c:if>
				>충북</option>
				<option value="광주"
				<c:if test="${vo.area=='광주'}"> selected</c:if>
				>광주</option>
				<option value="전남"
				<c:if test="${vo.area=='전남'}"> selected</c:if>
				>전남</option>
				<option value="전북"
				<c:if test="${vo.area=='전북'}"> selected</c:if>
				>전북</option>
				<option value="부산"
				<c:if test="${vo.area=='부산'}"> selected</c:if>
				>부산</option>
				<option value="경남"
				<c:if test="${vo.area=='경남'}"> selected</c:if>
				>경남</option>
				<option value="대구"
				<c:if test="${vo.area=='대구'}"> selected</c:if>
				>대구</option>
				<option value="경북"
				<c:if test="${vo.area=='경북'}"> selected</c:if>
				>경북</option>
				<option value="제주"
				<c:if test="${vo.area=='제주'}"> selected</c:if>
				>제주</option>
				
			</select><br/>
			<label>카테고리</label>
			<c:set var="categoryStr" value="${vo.category}"/>
			<div class="form-check-inline">
				<label class="form-check-label"> <input type="checkbox"
					class="form-check-input" name="category" id="cafe" value="cafe"
					<c:if test = "${fn:contains(testStr, 'cafe')}">checked</c:if>
					>카페
				</label>	
			</div>
			<div class="form-check-inline">
				<label class="form-check-label"> <input type="checkbox"
					class="form-check-input" name="category" id="eatery" value="eatery"
					<c:if test = "${fn:contains(testStr, 'eatery')}">checked</c:if>
					>음식점
				</label>
			</div>
			<div class="form-check-inline">
				<label class="form-check-label"> <input type="checkbox"
					class="form-check-input" name="category" id="stay" value="stay"
					<c:if test = "${fn:contains(testStr, 'stay')}">checked</c:if>
					>숙박
				</label>
			</div>
			<div class="form-check-inline">
				<label class="form-check-label"> <input type="checkbox"
					class="form-check-input" name="category" id="pool" value="pool"
					<c:if test = "${fn:contains(testStr, 'pool')}">checked</c:if>>수영장
				</label>
			</div>
		</div>
		<div>
			<textarea name="content" id="tripcontent">${vo.content}</textarea>
			<script type="text/javascript">
				CKEDITOR.replace('tripcontent', {
					width : 850,
					height : 340,
					filebrowserUploadUrl: '${url}/upload'
				});
			</script>
		</div>
		<input type="button" value="취소" />
		<input type="submit" value="수정" />
	</form>
</div>
