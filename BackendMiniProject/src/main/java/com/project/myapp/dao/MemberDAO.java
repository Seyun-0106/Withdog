package com.project.myapp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.myapp.vo.MemberVO;
@Mapper
@Repository
public interface MemberDAO {
	//로그인 체크
	public MemberVO loginCheck(MemberVO vo);
	
	//회원가입  체크
	public int memberInsert(MemberVO vo);
	
	//아이디 중복 체크
	public Integer idCheck(String userid);
	
	//닉네임 중복 체크
	public Integer nameCheck(String username);
	
	// 비밀번호 확인
	public Integer pwdCheck(String userpwd,String userid);
	
	// 회원 정보 폼
	public MemberVO memberSelect(String userid);
	
	//회원정보 DB
	public int memberUpdate(MemberVO vo);
	
	// 비밀번호 수정
	public int pwdUpdate(MemberVO vo);
}
