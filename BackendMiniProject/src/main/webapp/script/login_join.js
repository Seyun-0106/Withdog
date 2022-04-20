//---------- 로그인 --------------
function loginFormCheck() {
	var id = document.getElementById("userid");
	if (id.value == "") {
		alert("아이디를 입력하세요.");
		id.focus();
		return false;
	}
	var pwd = document.getElementById("userpwd");
	if (pwd.value == "") {
		alert("비밀번호를 입력하세요.");
		pwd.focus();
		return false;
	}
	return true;
}

//---------- 회원가입 유효성 검사 --------------
function joinFormCheck() {
	// 아이디 중복확인 + 유효성 검사
	if(document.getElementById("idChk").value!="Y"){
		alert("아이디 중복 확인을 클릭하세요.");
		return false;
	}
	
	var pwd = document.getElementById("userpwd");
	reg = /^\w{8,12}$/;

	if (pwd.value == "") {
		alert("비밀번호를 입력하세요.");
		pwd.focus();
		return false;
	}
	if (!reg.test(pwd.value)) {
		alert("비밀번호를 잘못 입력하였습니다.\n8~12글자(영어, 숫자, _만 입력 가능)");
		pwd.focus();
		return false;
	}

	var pwd2 = document.getElementById("userpwd2");

	if (pwd2.value == "") {
		alert("비밀번호 확인란을 입력하세요.");
		pwd2.focus();
		return false;
	}
	if (pwd.value != pwd2.value) {
		alert("비밀번호가 일치하지 않습니다.");
		pwd2.focus();
		return false;
	}

	var email = document.getElementById("email");
	reg = /\w+@\w+\.\w+(\. \w+)?/;

	if (email.value == "") {
		alert("이메일을 입력하세요.");
		email.focus();
		return false;
	}
	if (!reg.test(email.value)) {
		alert("이메일을 잘못 입력하였습니다.\n 입력 예시) withdog@naver.com");
		email.focus();
		return false;
	}

	// 닉네임 중복 검사 + 유효성 검사
	if(document.getElementById("nameChk").value!="Y"){
		alert("닉네임 중복 확인을 클릭하세요.");
		return false;
	}
	
	return true;
}