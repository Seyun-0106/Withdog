$(function(){
	$("#commentBtn").on('click', function() {
		$("#comment").toggle();
	});

	//댓글 등록
	$("#commentFrm").submit(function() {
		event.preventDefault();
		if ($("#commentContent").val() == '') {
			alert("댓글 내용을 입력하세요.");
			return false;
		} else {
			var params = $("#commentFrm").serialize(); //폼에 있는 데이터가 담김
			$.ajax({
				url: '/myapp/freecomment/insert',
				data: params,
				type: 'POST',
				success: function(result) {
					if (result > 0) {
						location.reload();
					}
				},
				error: function(e) {
					console.log(e.responseText);
				}
			});
		}
	});
	//댓글수정-----------------------------------------------
	$(".cmodify").click(function() {
		var parent = $(this).parent();
		$(parent).next().css("display","block");
		$(parent).css("display", "none");

	});

	//취소버튼 클릭
	$(".commentEditFrm>input[type=button]").click(function() {
		$(".commentList").css("display", "block");
		$(".commentEdit").css("display", "none");
	});

	//수정버튼 클릭
	$(".commentEditFrm").submit(function() {
		event.preventDefault();//form 기본 이벤트 제거

		var params = $(this).serialize();
		let url = '/myapp/freecomment/update';
		$.ajax({
			url: url,
			data: params,
			type: 'POST',
			success: function(result) {
				if (result > 0) {
					location.reload();

				}
			},
			error: function(e) {
				console.log(e.responseText);
			}
		});
	});
	
	//댓글 삭제
	$(".cdelete").click(function() {
		if (confirm("댓글을 삭제하시겠습니까?")) {
			var fcomno = $(".commentList>input[name=fcomno]").val();
			var params = "fcomno=" + fcomno;
			console.log(params);
			$.ajax({
				url: '/myapp/freecomment/delete',
				data: params,
				success: function(result) {
					if (result > 0) {
						location.reload();
					}
				},
				error: function(e) {
					console.log(e.responseText);
				}
			});
		}
	});
});