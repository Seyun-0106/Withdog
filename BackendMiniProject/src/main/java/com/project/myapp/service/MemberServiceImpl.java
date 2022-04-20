package com.project.myapp.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.project.myapp.dao.MemberDAO;
import com.project.myapp.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	@Inject
	MemberDAO dao;
	
	@Override
	public MemberVO loginCheck(MemberVO vo) {
		return dao.loginCheck(vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		return dao.memberInsert(vo);
	}

	@Override
	public Integer idCheck(String userid) {
		return dao.idCheck(userid);
	}

	@Override
	public Integer nameCheck(String username) {
		return dao.nameCheck(username);
	}

	@Override
	public Integer pwdCheck(String userpwd, String userid) {
		return dao.pwdCheck(userpwd, userid);
	}

	@Override
	public MemberVO memberSelect(String userid) {
		return dao.memberSelect(userid);
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		return dao.memberUpdate(vo);
	}

	@Override
	public int pwdUpdate(MemberVO vo) {
		return dao.pwdUpdate(vo);
	}

}
