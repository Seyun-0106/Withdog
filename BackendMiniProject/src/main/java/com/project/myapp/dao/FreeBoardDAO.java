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
	// 글 등록
	public int boardInsert(FreeBoardVO vo);
	// 글목록
	public List<FreeBoardVO> boardList(PagingVO pVO);
	// 총 레코드 수 구하기
	public int totalRecord(PagingVO pVO);
	// 글 보기
	public FreeBoardVO boardSelect(int no);
	// 글 수정
	public int boardUpdate(FreeBoardVO vo);
	//글 삭제
	public int boardDelete(int fno, String userid);
	
	// 댓글 목록
	public List<FreeCommentVO> commentList(int fno);
	// 댓글 등록
	public int commentInsert(FreeCommentVO fVO);
	// 댓글 수정
	public int commentUpdate(FreeCommentVO fVO);
	// 댓글 삭제
	public int commentDelete(int fcomno, String userid);
}
