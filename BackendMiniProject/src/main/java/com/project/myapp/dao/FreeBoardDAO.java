package com.project.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.myapp.vo.FreeBoardVO;
import com.project.myapp.vo.FreeCommentVO;
import com.project.myapp.vo.PagingVO;

@Mapper
@Repository
public interface FreeBoardDAO {
	// �� ���
	public int boardInsert(FreeBoardVO vo);
	// �۸��
	public List<FreeBoardVO> boardList(PagingVO pVO);
	// �� ���ڵ� �� ���ϱ�
	public int totalRecord(PagingVO pVO);
	// �� ����
	public FreeBoardVO boardSelect(int no);
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
