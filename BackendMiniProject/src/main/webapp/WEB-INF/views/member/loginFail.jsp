<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script>
$(function(){
	$(document).ready(function() {
		alert("로그인 실패하였습니다.");
		location.href="/myapp/member/loginForm";
	});
});
</script>
