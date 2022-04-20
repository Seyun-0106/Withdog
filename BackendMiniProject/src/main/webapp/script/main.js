$(function() {

	$("#menu>nav>ul>li").hover(function() {
		$(this).css("background-color", "#fdec99").css("transition-duration", "300ms");
	}, function() {
		$(this).css("background-color", "transparent");
	});

});

function logoutCheck(){
	if(!confirm("로그아웃 하시겠습니까?")){
		return false;
	}
	location.href="/myapp/member/logout";
};


