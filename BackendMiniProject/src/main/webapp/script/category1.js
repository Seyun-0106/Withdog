$(function(){
	//------ 카테고리-----------
	//카테고리 hover
	$("#category>nav>ul").hover(function() {
		$(this).css("background-color", "#e8f4ea").css("transition-duration", "300ms");
	}, function() {
		$(this).css("background-color", "white");
	});
	//커뮤니티 하위메뉴 나타내기
	$("#community").hover(function() {
		$("#hidden_category").fadeIn();
	}, function() {
		$("#hidden_category").css("display", "none");
	});
	//커뮤니티 하위메뉴 hover
	$("#hidden_category>ul").hover(function() {
		$(this).css("background-color", "#e8f4ea").css("transition-duration", "300ms");
	}, function() {
		$(this).css("background-color", "white");
	});
	
	//카테고리바 click
	$("#category_bar>a:first").click(function() {
		$("#category>nav").toggle();
		$(this).css("display", "none");
		$("#category_bar>a:last").css("display", "block");
		$("#category_bar").css("margin-left", "30px");

	});
	$("#category_bar>a:last").click(function() {
		$("#category>nav").fadeIn();
		$(this).css("display", "none");
		$("#category_bar>a:first").css("display", "block");
		$("#category_bar").css("margin-left", "10px");
	});
});