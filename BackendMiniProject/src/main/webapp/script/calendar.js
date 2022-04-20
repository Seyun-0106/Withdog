//------------ 캘린더 -------------
var now = new Date();
function setDate() {
	//현재 날짜 구하기
	var y = now.getFullYear();
	var m = now.getMonth();	//0:1월
	var d = now.getDate();
	var curdate;
	if (m < 10) {
		curdate = y + "-0" + (m + 1);
	} else {
		curdate = y + "-" + (m + 1);
	}

	//1일에 대한 요일 구하기 getDay()
	var w = new Date(y, m, 1).getDay();

	//마지막 구하기 "0일"로 세팅(다음 달 0일 = 이번 달 마지막 일)
	var lastDay = new Date(y, m + 1, 0).getDate();

	//년월 셋팅
	document.querySelector("#dateTitle").innerHTML = y + "년 " + (m + 1) + "월";

	//요일
	var weekName = ['일', '월', '화', '수', '목', '금', '토'];
	var dateTag = "";
	for (var i = 0; i < weekName.length; i++) {
		dateTag += "<li>" + weekName[i] + "</li>";
	}

	// 1일 전은 공백으로 채우기
	for (var i = 0; i < w; i++) {
		dateTag += "<li>&nbsp</li>";
	}

	for (var i = 1; i <= lastDay; i++) {
		if (d == i) {//오늘인 경우 class명 지정해줌
			dateTag += "<li class='today' value='" + i + "'>" + i + "</li>";
		} else {
			dateTag += "<li value='" + i + "'>" + i + "</li>";
		}
	}
	$(".today").css("background-color", "#F5C236").css("font-weight", "bold");

	document.getElementById("dateView").innerHTML = dateTag;
	return curdate;
}
// 이전 달
function setDate_prev() {
	now = new Date(now.getFullYear(), now.getMonth() - 1, now.getDate());
	var curdate = setDate();
	document.getElementById("curdate").value = curdate;
	/*달력에 표시된 날짜*/
	var nowdate = $("#curdate").val();

	/*현재 날짜*/
	var ndate = new Date();
	var y = ndate.getFullYear();
	var m = ndate.getMonth();
	if (m < 10) { m = "0" + (m + 1) };
	ndate = y + "-" + m;

	if (nowdate.search(ndate) <= -1) {
		$(".today").css("background-color", "white").css("font-weight", "normal");
	}

	var nowdate = $("#curdate").val();
	$("#schedule_view").html("");
	var tag = "";
	$.ajax({
		url: '/myapp/calendar/select',
		method: "GET",
		success: function(result) {

			$(result).each(function() {
				tag = "";
				if (this.cdate.search(nowdate) > -1) {
					tag += "<li class='list-group-item list-group-item-action' onclick='calURL(\""+this.ccontent+"\")'>";
					tag += "<a href='javascript:void(0);'>" + this.cname + "<br/>";
					tag += "<span class='cal_span'>" + this.cdate + "</span></a></li>";
					$("#schedule_view").append(tag);
				}
			});
		},
		error: function(e) {
			console.log(e.responseText);
		}
	});
}
// 다음 달
function setDate_next() {
	now = new Date(now.getFullYear(), now.getMonth() + 1, now.getDate());
	var curdate = setDate();
	document.getElementById("curdate").value = curdate;
	var nowdate = $("#curdate").val();

	/*현재 날짜*/
	var ndate = new Date();
	var y = ndate.getFullYear();
	var m = ndate.getMonth();
	if (m < 10) { m = "0" + (m + 1) };
	ndate = y + "-" + m;

	if (nowdate.search(ndate) <= -1) {
		$(".today").css("background-color", "white").css("font-weight", "normal");
	}

	$("#schedule_view").html("");
	var tag = "";
	$.ajax({
		url: '/myapp/calendar/select',
		method: "GET",
		success: function(result) {

			$(result).each(function() {
				tag = "";
				if (this.cdate.search(nowdate) > -1) {
					tag += "<li class='list-group-item list-group-item-action' onclick='calURL(\""+this.ccontent+"\")'>";
					tag += "<a href='javascript:void(0);'>" + this.cname + "<br/>";
					tag += "<span class='cal_span'>" + this.cdate + "</span></a></li>";
					$("#schedule_view").append(tag);
				}
			});
		},
		error: function(e) {
			console.log(e.responseText);
		}
	});
}

$(function() {
	//초기 세팅
	$(document).ready(function() {
		var curdate = setDate();
		//console.log(curdate);
		$("#schedule_view").before("<input type='hidden' id='curdate' value='" + curdate + "'/>");

		//일정 목록
		var nowdate = $("#curdate").val();
		var tag = "";
		$.ajax({
			url: '/myapp/calendar/select',
			method: "GET",
			success: function(result) {
				$(result).each(function() {
					tag = "";
					if (this.cdate.search(nowdate) > -1) {
						tag += "<li class='list-group-item list-group-item-action' onclick='calURL(\""+this.ccontent+"\")'>";
						tag += "<a href='javascript:void(0);'>" + this.cname + "<br/>";
						tag += "<span class='cal_span'>" + this.cdate + "</span></a></li>";
						$("#schedule_view").append(tag);
					}
				});
			},
			error: function(e) {
				console.log(e.responseText);
			}
		});
		
		//삭제 일정 목록(현재 년도 일정만)
		var nowyear = new Date().getFullYear();
		tag = "";
		$.ajax({
			url: '/myapp/calendar/allSelect',
			method: "GET",
			success: function(result) {
				$(result).each(function() {
				if (this.cdate.search(nowyear) > -1) {
						tag = "";
						tag += "<li class='list-group-item list-group-item-action' onclick='delCheck("+this.cno+")'>";
						tag += "<a href='javascript:void(0);'>" + this.cname + "<br/>";
						tag += "<span class='cal_span'>" + this.cdate + "</span></a></li>";
						$("#schedule_del").append(tag);
					}
				});
			},
			error: function(e) {
				console.log(e.responseText);
			}
		});

	});

	//일정 등록 아이콘 클릭
	$("#addBtn").click(function() {
		event.preventDefault();
		if ($("#addDate").val() == "") {
			alert("날짜를 선택하세요.");
			$("#addDate").focus();
			return false;
		}
		if ($("#addName").val() == "") {
			alert("일정명을 입력하세요.");
			$("#addContent").focus();
			return false;
		}
		if (!confirm("일정을 등록하시겠습니까?")) {
			return false;
		}
		var data = $("#d2").serialize();
		console.log(data);
		$.ajax({
			url: '/myapp/calendar/insert',
			data: data,
			type: 'POST',
			success: function(result) {
				if (result > 0) {
					alert("일정이 등록되었습니다.");
					location.reload();
				}
				console.log(result.cdate);
			},
			error: function(e) {
				console.log(e.responseText);
			}
		});
	});

	//일정 보기 아이콘 클릭
	$("#viewcal").click(function() {
		$("#schedule_view").css("display","block");
		$("#schedule_del").css("display","none");
	});

	//일정 삭제 아이콘 클릭
	$("#delcal").click(function() {
		$("#schedule_view").css("display","none");
		$("#schedule_del").css("display","block");
	});
	
	//일정 클릭하면 달력에 표시
	$("#schedule_view>li").click(function() {
		console.log("z");
		var cdateArr = $(this).attr("title").split("-");
		var cyear = cdateArr[0];
		var cmonth = cdateArr[1];
		var cdate = cdateArr[2]

		if ($("#dateView>li[value=" + cdate + "]").css("background-color") == "rgb(232, 244, 234)") {
			$("#dateView>li[value=" + cdate + "]").css("background-color", "white").css("font-weight", "normal");
		} else {
			$("#dateView>li[value=" + cdate + "]").css("background-color", "#e8f4ea").css("font-weight", "bold");
		}
	});
});

function delCheck(cno) {
	if (!confirm("일정을 삭제하시겠습니까?")) {
		return false;
	}
	$.ajax({
			url: '/myapp/calendar/delete',
			data: 'cno='+cno,
			type: 'GET',
			success: function(result) {
				if (result > 0) {
					alert("일정이 삭제되었습니다.");
					location.reload();
				}
			},
			error: function(e) {
				console.log(e.responseText);
			}
		});
}
function calURL(url){
	if(url!=null){
		window.open(url);
	}
}