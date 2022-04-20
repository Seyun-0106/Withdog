package com.project.myapp.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.myapp.vo.MemberVO;
@Mapper
@Repository
public interface MemberDAO {
	//�α��� üũ
	public MemberVO loginCheck(MemberVO vo);
	
	//ȸ������  üũ
	public int memberInsert(MemberVO vo);
	
	//���̵� �ߺ� üũ
	public Integer idCheck(String userid);
	
	//�г��� �ߺ� üũ
	public Integer nameCheck(String username);
	
	// ��й�ȣ Ȯ��
	public Integer pwdCheck(String userpwd,String userid);
	
	// ȸ�� ���� ��
	public MemberVO memberSelect(String userid);
	
	//ȸ������ DB
	public int memberUpdate(MemberVO vo);
	
	// ��й�ȣ ����
	public int pwdUpdate(MemberVO vo);
}
