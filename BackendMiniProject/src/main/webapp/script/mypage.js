$(function() {
	//비밀번호 체크
	$("#pwdCheck").submit(function() {
		
		if($("#userpwd").val()==''){
			alert("비밀번호를 입력하세요.");
			$("#userpwd").focus();
			return false;
		}
		event.preventDefault();
		
		var url = "/myapp/member/userpwdOk";
		$.ajax({
			url:url,
			data:"userpwd="+$("#userpwd").val(),
			type:"POST",
			success : function(result){
				if(result>0){// 비밀번호 일치
					location.href="/myapp/member/memberEdit";
				}else{
					alert("비밀번호가 일치하지 않습니다.");
					$("#userpwd").focus();
					return false;
				}
			},
			error : function(e){
				console.log("에러메시지 "+e.responseText);
			}
		});
		return true;
	});
	
	// 비밀번호 수정
	$("#changepwd").submit(function() {
		var reg = /^\w{8,12}$/;
		
		if ($("#userpwd").val() == "") {
			alert("비밀번호를 입력하세요.");
			$("#userpwd").focus();
			return false;
		}
		
		/*변경할 비밀번호*/
		if ($("#userpwd2").val() == "") {
			alert("비밀번호를 입력하세요.");
			$("#userpwd2").focus();
			return false;
		}
		
		if (!reg.test($("#userpwd2").val())) {
			alert("비밀번호를 잘못 입력하였습니다.\n8~12글자(영어, 숫자, _만 입력 가능)");
			$("#userpwd2").focus();
			return false;
		}

		if ($("#userpwd3").val()== "") {
			alert("비밀번호 확인란을 입력하세요.");
			$("#userpwd3").focus();
			return false;
		}
		if ($("#userpwd2").val() != $("#userpwd3").val()) {
			alert("비밀번호 확인란을 다시 입력하세요.");
			$("#userpwd3").focus();
			return false;
		}
		//event.preventDefault();
		var url = "/myapp/member/userpwdOk";
		$.ajax({
			url:url,
			data:"userpwd="+$("#userpwd").val(),
			type:"POST",
			success : function(result){
				if(result>0 && result!=null){
					if(!confirm("비밀번호를 수정하시겠습니까?")){
						return false;
					}
					alert("비밀번호가 수정되었습니다.");
				}else{
					alert("비밀번호가 일치하지 않습니다.");
					$("#userpwd").focus();
					return false;
				}
			},
			error : function(e){
				console.log(e.responseText);
			}
		});
		return true;	//pwdChangeOk 매핑
	});
});

//회원정보 수정
$(function(){
	//닉네임 중복 확인
	$("#checkName").click(function(){
		var username = $("#username").val();
		console.log(username);
			
		$("#username").keyup(function(){
			$("#nameChk").prop("value","N");
		});
			
		if (username== "") {
			alert("닉네임을 입력하세요.");
			$("#username").focus();
			return false;
		}
			
		if (username.length < 2 || username.length > 8) {
			alert("닉네임을 잘못 입력하였습니다.\n 닉네임은 2~8글자");
			$("#username").focus();
			return false;
		}
			
		var url = "/myapp/member/memberNameCheck";
		$.ajax({
			url : url,
			data : "username="+username,
			type : "POST",
			success : function(result){
				if(result>0){	//사용불가
					alert('닉네임 중복 \n다른 닉네임을 입력하세요.');
					$("#nameChk").prop("value","N");
				}else{	//사용가능
					if(confirm('사용할 수 있는 닉네임입니다. \n해당 닉네임을 사용하시겠습니까?')){
						$("#nameChk").prop("value","Y");
					}
				}
			},
			error : function(e){
				console.log(e.responseText);
			}
		});
	});
	
	// 폼 submit
	$("#infoFrm").submit(function(){
		
		//이메일----------------------------
		var reg = /\w+@\w+\.\w+(\. \w+)?/;
	
		if ($("#email").val() == "") {
			alert("이메일을 입력하세요.");
			$("#email").focus();
			return false;
		}
		if (!reg.test($("#email").val())) {
			alert("이메일을 잘못 입력하였습니다.\n 입력 예시) withdog@naver.com");
			$("#email").focus();
			return false;
		}
		//닉네임----------------------------
		if($("#nameChk").val()!="Y"){
			alert("닉네임 중복확인을 클릭하세요.");
			return false;
		}
		
		if(!confirm("회원 정보를 수정하시겠습니까?")){
			return false;
		}
		alert("회원 정보가 수정되었습니다.");
		return true;
	});
});

