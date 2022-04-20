package com.project.myapp.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.project.myapp.service.MemberService;
import com.project.myapp.vo.MemberVO;

@Controller
@RequestMapping("/member/")
public class MemberController {
	@Inject
	MemberService service;

	// �α��� �� �̵�
	@GetMapping("loginForm")
	public String loginForm() {
		return "member/loginForm";
	}
	// �α���
	// ���� �Էµ� id, pwd�� vo�� ���
	@PostMapping("loginOk")
	public ModelAndView loginOk(MemberVO vo, HttpSession session) {
		// request userid, userpwd�� ��ġ�ϴ� ���ڵ��� userid, username ����
		MemberVO vo2 = service.loginCheck(vo);
		
		ModelAndView mav = new ModelAndView();
		if (vo2 != null) {
			// �α��� ���� : session�� id, name ���� �� Ȩ���� �̵�
			session.setAttribute("logid", vo2.getUserid());
			session.setAttribute("logname", vo2.getUsername());
			session.setAttribute("logStatus", "Y");
			System.out.println(vo2.getUsername());
			// ��Ʈ�ѷ����� �ٸ� ��Ʈ�ѷ��� �����ּҸ� �ٷ� ȣ��(HomeController)
			mav.setViewName("redirect:/");

		} else { // �α��� ���� : �α��� ������ �̵�
			mav.setViewName("redirect:loginFail");
		}
		return mav;
	}
	@GetMapping("loginFail")
	public ModelAndView loginFail() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/loginFail");
		return mav;
	}
	
	// �α׾ƿ�
	@GetMapping("logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		return mav;
	}
	
	//ȸ������ �� �̵�
	@GetMapping("joinForm")
	public String joinForm() {
		return "member/joinForm";
	}
	
	//ȸ������
	@PostMapping("joinOk")
	public ModelAndView memberInsert(MemberVO vo) {
		ModelAndView mav = new ModelAndView();
		int cnt = service.memberInsert(vo);
		if(cnt>0) {// ȸ������ ����
			mav.setViewName("redirect:loginForm");
		}else {
			mav.setViewName("redirect:joinForm");
		}
		return mav;
	}
	
	//���̵� �ߺ��˻�
	@PostMapping("memberIdCheck")
	@ResponseBody
	public Integer idCheck(String userid) {
		return service.idCheck(userid);
	}
	
	//�г��� �ߺ��˻�
	@PostMapping("memberNameCheck")
	@ResponseBody
	public Integer nameCheck(String username) {
		return service.nameCheck(username);
	}
	
	//���������� �̵�
	@GetMapping("myPage")
	public String myPage() {
		return "member/myPage";
	}
	
	//��й�ȣ Ȯ��
	@PostMapping("userpwdOk")
	@ResponseBody
	public Integer userpwdOk(String userpwd, HttpSession session) {
		String userid = (String) session.getAttribute("logid");
		return service.pwdCheck(userpwd,userid);
	}
	
	//ȸ������ ����(��)
	@GetMapping("memberEdit")
	public ModelAndView memberEdit(HttpSession session) {
		String userid = (String)session.getAttribute("logid");
			
		MemberVO vo = service.memberSelect(userid) ;
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo", vo);	
		mav.setViewName("member/memberEdit");
		return mav;
	}
	
	//ȸ������ ����(DB)
	@PostMapping("memberEditOk")
	public ModelAndView memberEditOk(MemberVO vo, HttpSession session) {
		vo.setUserid((String)session.getAttribute("logid"));
		service.memberUpdate(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:memberEdit");
		return mav;
	}
	
	//��й�ȣ ���� �� �̵�
	@GetMapping("changePwd")
	public String changePwd() {
		return "member/changePwd";
	}
	
	//��й�ȣ ����(DB)
	@PostMapping("pwdChangeOk")
	public ModelAndView pwdUpdate(MemberVO vo, HttpSession session) {
		vo.setUserid((String)session.getAttribute("logid"));
		vo.setUserpwd(vo.getUserpwd2());
		service.pwdUpdate(vo);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/changePwd");
		return mav;
	}
}
