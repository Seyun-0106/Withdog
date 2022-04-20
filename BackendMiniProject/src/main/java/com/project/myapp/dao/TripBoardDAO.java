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
	//글 등록
	public int boardInsert(TripBoardVO vo);
	//글목록
	public List<TripBoardVO>boardList(PagingVO pVO);
	//총 레코드 수 구하기
	public int totalRecord(PagingVO pVO);
	//글 보기
	public TripBoardVO boardSelect(int no);
	//글 수정
	public int boardUpdate(TripBoardVO vo);
	//글 삭제
	public int boardDelete(int no, String userid);
	

	//댓글 목록
	public List<CommentVO> commentList(int no);
	//댓글 등록
	public int commentInsert(CommentVO cVO);
	//댓글 수정
	public int commentUpdate(CommentVO cVO);
	//댓글 삭제
	public int commentDelete(int comno, String userid);
}
