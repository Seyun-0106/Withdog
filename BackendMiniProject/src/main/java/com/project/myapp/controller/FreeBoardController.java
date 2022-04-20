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

import com.project.myapp.service.FreeBoardService;
import com.project.myapp.vo.FreeBoardVO;
import com.project.myapp.vo.FreeCommentVO;
import com.project.myapp.vo.PagingVO;

@RestController
public class FreeBoardController {
	@Inject
	FreeBoardService service;

	// �� ���, ���ݿ��� ������ �̵�
	@GetMapping("/freeboard/boardList")
	public ModelAndView boardList(PagingVO pVO) {
		ModelAndView mav = new ModelAndView();
		pVO.setTotalRecord(service.totalRecord(pVO));
		mav.addObject("list", service.boardList(pVO));
		mav.addObject("pVO", pVO);

		mav.setViewName("freeboard/boardList");
		return mav;
	}

	// �Խ��� �� ���� �̵�
	@GetMapping("/freeboard/boardWrite")
	public ModelAndView boardWrite() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("freeboard/boardWrite");
		return mav;
	}

	// �� ���
	@PostMapping("/freeboard/boardWriteOk")
	public ResponseEntity<String> boardWriteOk(FreeBoardVO vo, HttpServletRequest request) {
		vo.setUserid((String) request.getSession().getAttribute("logid"));
		vo.setUsername((String) request.getSession().getAttribute("logname"));

		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html;  charset=utf-8");

		try {
			service.boardInsert(vo);

			String msg = "<script>";
			msg += "alert('���� ��ϵǾ����ϴ�.');";
			msg += "location.href='/myapp/freeboard/boardList';";
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
	@GetMapping("/freeboard/boardView")
	public ModelAndView boardView(int fno) {
		FreeBoardVO vo = service.boardSelect(fno);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("freeboard/boardView");
		mav.addObject("vo", vo);
		mav.addObject("fList", service.commentList(fno));

		return mav;
	}
	//�� ���� �̵�
	@GetMapping("/freeboard/boardEdit")
	public ModelAndView boardEdit(int fno) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo", service.boardSelect(fno));
		mav.setViewName("freeboard/boardEdit");
		return mav;
	}
	
	// �� ���� db
	@PostMapping("/freeboard/boardUpdate")
	public ResponseEntity<String> boardUpdate(FreeBoardVO vo, HttpSession session) {
		vo.setUserid((String) session.getAttribute("logid"));
		vo.setUsername((String) session.getAttribute("logname"));

		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html;  charset=utf-8");
		try {
			int result = service.boardUpdate(vo);
			if (result > 0) {
				String msg = "<script>";
				msg += "alert('���� �����Ǿ����ϴ�.');";
				msg += "location.href='/myapp/freeboard/boardView?fno=" + vo.getFno() + "';";
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
	@GetMapping("/freeboard/boardDelete")
	public ModelAndView boardDel(int fno, HttpSession session) {
		String userid = (String) session.getAttribute("logid");
		int result = service.boardDelete(fno, userid);

		ModelAndView mav = new ModelAndView();

		if (result > 0) {// ���� ����
			mav.setViewName("redirect:boardList");
		} else {// ���� ����
			mav.addObject("fno", fno);
			mav.setViewName("redirect:boardView");
		}
		return mav;
	}

	// ��� ���
	@PostMapping("/freecomment/insert")
	public int commentInsert(FreeCommentVO fVO) {
		return service.commentInsert(fVO);
	}

	// ��� ����
	@PostMapping("/freecomment/update")
	public int commentUpdate(FreeCommentVO fVO, HttpSession session) {
		fVO.setUserid((String) session.getAttribute("logid"));
		return service.commentUpdate(fVO);
	}

	// ��� ����
	@GetMapping("/freecomment/delete")
	public int commentDelete(int fcomno, HttpSession session) {
		String userid = (String) session.getAttribute("logid");
		return service.commentDelete(fcomno, userid);
	}
}
