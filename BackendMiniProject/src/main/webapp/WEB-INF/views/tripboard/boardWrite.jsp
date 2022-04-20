<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="${url}/ckeditor/ckeditor.js"></script>
<link rel="stylesheet" href="${url}/css/write.css" type="text/css" />

<script>
	$(function() {
		// 글쓰기 폼 이외에 클릭 이벤트가 발생한 경우
		$("#header").click(function() {
			if (confirm("글쓰기를 중단하시겠습니까?")) {
				return true;
			} else {
				return false;
			}
		});
		$("#loginImg").click(function() {
			if (confirm("글쓰기를 중단하시겠습니까?")) {
				return true;
			} else {
				return false;
			}
		});
		$("#myImg").click(function() {
			if (confirm("글쓰기를 중단하시겠습니까?")) {
				return true;
			} else {
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
			
			return true;//임시
		});

		$("#writeform>input[type=button]").click(function() {
			if (confirm("글쓰기를 중단하시겠습니까?")) {
				history.back();
			} else {
				return false;
			}
		});
	});
</script>

<div class="container">
	<form method="post" action="${url}/tripboard/boardWriteOk" id="writeform">
		<div>
			<label for="#title">제목</label>
			<input type="text" name="subject" id="title" /><br />
			
			<label for="#selctArea">지역선택</label>
			<select id="selectArea" name="area">
				<option disabled selected>지역선택</option>
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
			</select><br/>
			<label>카테고리</label>
			<div class="form-check-inline">
				<label class="form-check-label"> <input type="checkbox"
					class="form-check-input" name="category" id="cafe" value="cafe">카페
				</label>
			</div>
			<div class="form-check-inline">
				<label class="form-check-label"> <input type="checkbox"
					class="form-check-input" name="category" id="eatery" value="eatery">음식점
				</label>
			</div>
			<div class="form-check-inline">
				<label class="form-check-label"> <input type="checkbox"
					class="form-check-input" name="category" id="stay" value="stay">숙박
				</label>
			</div>
			<div class="form-check-inline">
				<label class="form-check-label"> <input type="checkbox"
					class="form-check-input" name="category" id="pool" value="pool">수영장
				</label>
			</div>
		</div>
		<div>
			<textarea name="content" id="tripcontent"></textarea>
			<script type="text/javascript">
				CKEDITOR.replace('tripcontent', {
					width : 850,
					height : 340,
					filebrowserUploadUrl: '${url}/upload'
				});
			</script>
		</div>
		<input type="button" value="취소" />
		<input type="submit" value="등록" />
	</form>
</div>
</div>