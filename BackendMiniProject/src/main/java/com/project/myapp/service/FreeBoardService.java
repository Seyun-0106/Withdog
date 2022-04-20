package com.project.myapp.service;

import java.util.List;

import com.project.myapp.vo.FreeBoardVO;
import com.project.myapp.vo.FreeCommentVO;
import com.project.myapp.vo.PagingVO;

public interface FreeBoardService {
	// �� ���
	public int boardInsert(FreeBoardVO vo);
	// �۸��
	public List<FreeBoardVO> boardList(PagingVO pVO);
	// �� ���ڵ� �� ���ϱ�
	public int totalRecord(PagingVO pVO);
	// �� ����
	public FreeBoardVO boardSelect(int fno);
	// �� ����
	public int boardUpdate(FreeBoardVO vo);
	//�� ����
	public int boardDelete(int fno, String userid);

	
	// ��� ���
	public List<FreeCommentVO> commentList(int fno);
	// ��� ���
	public int commentInsert(FreeCommentVO fVO);
	// ��� ����
	public int commentUpdate(FreeCommentVO fVO);
	// ��� ����
	public int commentDelete(int fcomno, String userid);

}
