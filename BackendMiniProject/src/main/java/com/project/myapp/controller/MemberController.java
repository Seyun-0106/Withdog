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

	// 로그인 폼 이동
	@GetMapping("loginForm")
	public String loginForm() {
		return "member/loginForm";
	}
	// 로그인
	// 폼에 입력된 id, pwd가 vo에 담김
	@PostMapping("loginOk")
	public ModelAndView loginOk(MemberVO vo, HttpSession session) {
		// request userid, userpwd와 일치하는 레코드의 userid, username 선택
		MemberVO vo2 = service.loginCheck(vo);
		
		ModelAndView mav = new ModelAndView();
		if (vo2 != null) {
			// 로그인 성공 : session에 id, name 저장 후 홈으로 이동
			session.setAttribute("logid", vo2.getUserid());
			session.setAttribute("logname", vo2.getUsername());
			session.setAttribute("logStatus", "Y");
			System.out.println(vo2.getUsername());
			// 컨트롤러에서 다른 컨트롤러의 매핑주소를 바로 호출(HomeController)
			mav.setViewName("redirect:/");

		} else { // 로그인 실패 : 로그인 폼으로 이동
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
	
	// 로그아웃
	@GetMapping("logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/");
		return mav;
	}
	
	//회원가입 폼 이동
	@GetMapping("joinForm")
	public String joinForm() {
		return "member/joinForm";
	}
	
	//회원가입
	@PostMapping("joinOk")
	public ModelAndView memberInsert(MemberVO vo) {
		ModelAndView mav = new ModelAndView();
		int cnt = service.memberInsert(vo);
		if(cnt>0) {// 회원가입 성공
			mav.setViewName("redirect:loginForm");
		}else {
			mav.setViewName("redirect:joinForm");
		}
		return mav;
	}
	
	//아이디 중복검사
	@PostMapping("memberIdCheck")
	@ResponseBody
	public Integer idCheck(String userid) {
		return service.idCheck(userid);
	}
	
	//닉네임 중복검사
	@PostMapping("memberNameCheck")
	@ResponseBody
	public Integer nameCheck(String username) {
		return service.nameCheck(username);
	}
	
	//마이페이지 이동
	@GetMapping("myPage")
	public String myPage() {
		return "member/myPage";
	}
	
	//비밀번호 확인
	@PostMapping("userpwdOk")
	@ResponseBody
	public Integer userpwdOk(String userpwd, HttpSession session) {
		String userid = (String) session.getAttribute("logid");
		return service.pwdCheck(userpwd,userid);
	}
	
	//회원정보 수정(폼)
	@GetMapping("memberEdit")
	public ModelAndView memberEdit(HttpSession session) {
		String userid = (String)session.getAttribute("logid");
			
		MemberVO vo = service.memberSelect(userid) ;
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo", vo);	
		mav.setViewName("member/memberEdit");
		return mav;
	}
	
	//회원정보 수정(DB)
	@PostMapping("memberEditOk")
	public ModelAndView memberEditOk(MemberVO vo, HttpSession session) {
		vo.setUserid((String)session.getAttribute("logid"));
		service.memberUpdate(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:memberEdit");
		return mav;
	}
	
	//비밀번호 변경 폼 이동
	@GetMapping("changePwd")
	public String changePwd() {
		return "member/changePwd";
	}
	
	//비밀번호 수정(DB)
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
