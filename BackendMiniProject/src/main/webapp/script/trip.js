$(function() {

	//---------- 카테고리, 지역선택 ---------------
	$("#cafeBtn").click(function() {
		if ($("#cafe").prop("checked") == false) {
			$("#cafe").prop("checked", true);
			$("#cafeBtn").css("background-color", "#fce478").css("font-weight", "bold");
		} else {
			$("#cafe").prop("checked", false);
			$("#cafeBtn").css("background-color", "white").css("font-weight", "normal");
		}
	});
	$("#eateryBtn").click(function() {
		if ($("#eatery").prop("checked") == false) {
			$("#eatery").prop("checked", true);
			$("#eateryBtn").css("background-color", "#fce478").css("font-weight", "bold");
		} else {
			$("#eatery").prop("checked", false);
			$("#eateryBtn").css("background-color", "white").css("font-weight", "normal");
		}
	});
	$("#stayBtn").click(function() {
		if ($("#stay").prop("checked") == false) {
			$("#stay").prop("checked", true);
			$("#stayBtn").css("background-color", "#fce478").css("font-weight", "bold");
		} else {
			$("#stay").prop("checked", false);
			$("#stayBtn").css("background-color", "white").css("font-weight", "normal");
		}
	});
	$("#poolBtn").click(function() {
		if ($("#pool").prop("checked") == false) {
			$("#pool").prop("checked", true);
			$("#poolBtn").css("background-color", "#fce478").css("font-weight", "bold");
		} else {
			$("#pool").prop("checked", false);
			$("#poolBtn").css("background-color", "white").css("font-weight", "normal");
		}
	});

});