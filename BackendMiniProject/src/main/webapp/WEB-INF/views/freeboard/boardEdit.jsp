<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="${url}/ckeditor/ckeditor.js"></script>
<link rel="stylesheet" href="${url}/css/freewrite.css" type="text/css" />

<script>
	$(function() {
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
		// submit 유효성 검사
		$("#writeform").submit(function() {
			if ($("#title").val() == "") {
				alert("제목을 입력하세요.");
				return false;
			}

			var txt = CKEDITOR.instances.writecontent.getData();
			if (txt == "") {
				alert("글 내용을 입력하세요.");
				return false;
			}
			return true;
		});

		$("#writeform>input[type=button]").click(function() {
			if (!confirm("글 수정을 중단하시겠습니까?")) {
				history.back();
			} else {
				return false;
			}
		});
	});
</script>

<div class="container">
	<form method="post" action="${url}/freeboard/boardUpdate" id="writeform">
		<input type="hidden" name="fno" value="${vo.fno}"/>
		<div>
			<label for="#title">제목</label>
			<input type="text" name="subject" id="title" value="${vo.subject}"/><br />
			<textarea name="content" name="writecontent" id="writecontent">${vo.content}</textarea>
			<script type="text/javascript">
				CKEDITOR.replace('writecontent', {
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