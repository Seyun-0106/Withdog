package com.project.myapp.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.myapp.service.TripBoardService;
import com.project.myapp.vo.CommentVO;
import com.project.myapp.vo.PagingVO;
import com.project.myapp.vo.TripBoardVO;

@RestController
public class TripBoardController {
	@Inject
	TripBoardService service;

	// �� ���, ���ݿ��� ������ �̵�
	@GetMapping("/tripboard/boardList")
	public ModelAndView boardList(PagingVO pVO) {
		ModelAndView mav = new ModelAndView();
		pVO.setTotalRecord(service.totalRecord(pVO));
		mav.addObject("list", service.boardList(pVO));
		mav.addObject("pVO", pVO);

		mav.setViewName("tripboard/boardList");
		return mav;
	}

	// �Խ��� �� ���� �̵�
	@GetMapping("/tripboard/boardWrite")
	public ModelAndView boardWrite() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("tripboard/boardWrite");
		return mav;
	}

	// �� ���
	@PostMapping("/tripboard/boardWriteOk")
	public ResponseEntity<String> boardWriteOk(TripBoardVO vo, HttpServletRequest request) {
		vo.setUserid((String) request.getSession().getAttribute("logid"));
		vo.setUsername((String) request.getSession().getAttribute("logname"));

		System.out.println(vo.getUsername() + "->" + vo.getUserid());
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html;  charset=utf-8");

		try {
			service.boardInsert(vo);

			String msg = "<script>";
			msg += "alert('���� ��ϵǾ����ϴ�.');";
			msg += "location.href='/myapp/tripboard/boardList';";
			msg += "</script>";

			entity = new ResponseEntity<String>(msg, headers, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			String msg = "<script>";
			msg += "alert('�� ��� �����Ͽ����ϴ�.');";
			msg += "history.back();";
			msg += "</script>";
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	// �� ���� + ��� ����
	@GetMapping("/tripboard/boardView")
	public ModelAndView boardView(int no) {
		TripBoardVO vo = service.boardSelect(no);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("tripboard/boardView");
		mav.addObject("vo", vo);
		mav.addObject("cList", service.commentList(no));

		return mav;
	}

	// �� ���� ������
	@GetMapping("/tripboard/boardEdit")
	public ModelAndView boardEdit(int no) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo", service.boardSelect(no));
		mav.setViewName("tripboard/boardEdit");
		return mav;
	}

	// �� ���� db
	@PostMapping("/tripboard/boardUpdate")
	public ResponseEntity<String> boardUpdate(TripBoardVO vo, HttpSession session) {
		vo.setUserid((String) session.getAttribute("logid"));
		vo.setUsername((String) session.getAttribute("logname"));

		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html;  charset=utf-8");
		System.out.println(vo.getNo());
		try {
			int result = service.boardUpdate(vo);
			if (result > 0) {
				String msg = "<script>";
				msg += "alert('���� �����Ǿ����ϴ�.');";
				msg += "location.href='/myapp/tripboard/boardView?no=" + vo.getNo() + "';";
				msg += "</script>";

				entity = new ResponseEntity<String>(msg, headers, HttpStatus.OK);
			} else {
				String msg = "<script>";
				msg += "alert('�� ���� �����Ͽ����ϴ�.');";
				msg += "history.back();";
				msg += "</script>";
				entity = new ResponseEntity<String>(msg, headers, HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			e.printStackTrace();
			String msg = "<script>";
			msg += "alert('�� ���� �����Ͽ����ϴ�.');";
			msg += "history.back();";
			msg += "</script>";
			entity = new ResponseEntity<String>(msg, headers, HttpStatus.BAD_REQUEST);
		}
		return entity;
	}

	// �� ����
	@GetMapping("/tripboard/boardDelete")
	public ModelAndView boardDel(int no, HttpSession session) {
		String userid = (String) session.getAttribute("logid");
		int result = service.boardDelete(no, userid);

		ModelAndView mav = new ModelAndView();

		if (result > 0) {// ���� ����
			mav.setViewName("redirect:boardList");
		} else {// ���� ����
			mav.addObject("no", no);
			mav.setViewName("redirect:boardView");
		}
		return mav;
	}

	// ��� ���
	@PostMapping("/comment/insert")
	public int commentInsert(CommentVO cVO) {
		return service.commentInsert(cVO);
	}

	// ��� ����
	@PostMapping("/comment/update")
	public int commentUpdate(CommentVO cVO, HttpSession session) {
		cVO.setUserid((String) session.getAttribute("logid"));
		return service.commentUpdate(cVO);
	}

	// ��� ����
	@GetMapping("/comment/delete")
	public int commentDelete(int comno, HttpSession session) {
		String userid = (String) session.getAttribute("logid");
		return service.commentDelete(comno, userid);
	}

}
