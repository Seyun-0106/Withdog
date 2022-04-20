package com.project.myapp.service;

import com.project.myapp.vo.MemberVO;

public interface MemberService {
	
	//로그인 체크
	public MemberVO loginCheck(MemberVO vo);
	
	//회원가입
	public int memberInsert(MemberVO vo);
	
	//아이디 중복 체크
	public Integer idCheck(String userid);
	
	//닉네임 중복 체크
	public Integer nameCheck(String username);
	
	//비밀번호 확인
	public Integer pwdCheck(String userpwd,String userid);
	
	//회원 정보 폼
	public MemberVO memberSelect(String userid);
	
	//회원정보 DB
	public int memberUpdate(MemberVO vo);
	
	// 비밀번호 수정
	public int pwdUpdate(MemberVO vo);
}
