package com.project.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.myapp.vo.CommentVO;
import com.project.myapp.vo.PagingVO;
import com.project.myapp.vo.TripBoardVO;

@Mapper
@Repository
public interface TripBoardDAO {
	//�� ���
	public int boardInsert(TripBoardVO vo);
	//�۸��
	public List<TripBoardVO>boardList(PagingVO pVO);
	//�� ���ڵ� �� ���ϱ�
	public int totalRecord(PagingVO pVO);
	//�� ����
	public TripBoardVO boardSelect(int no);
	//�� ����
	public int boardUpdate(TripBoardVO vo);
	//�� ����
	public int boardDelete(int no, String userid);
	

	//��� ���
	public List<CommentVO> commentList(int no);
	//��� ���
	public int commentInsert(CommentVO cVO);
	//��� ����
	public int commentUpdate(CommentVO cVO);
	//��� ����
	public int commentDelete(int comno, String userid);
}
