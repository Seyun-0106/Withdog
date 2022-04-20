package com.project.myapp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.project.myapp.dao.TripBoardDAO;
import com.project.myapp.vo.CommentVO;
import com.project.myapp.vo.PagingVO;
import com.project.myapp.vo.TripBoardVO;

@Service
public class TripBoardServiceImpl implements TripBoardService {
	@Inject
	TripBoardDAO dao;

	@Override
	public int boardInsert(TripBoardVO vo) {
		return dao.boardInsert(vo);
	}

	@Override
	public List<TripBoardVO> boardList(PagingVO pVO) {
		return dao.boardList(pVO);
	}

	@Override
	public int totalRecord(PagingVO pVO) {
		return dao.totalRecord(pVO);
	}

	@Override
	public TripBoardVO boardSelect(int no) {
		return dao.boardSelect(no);
	}
	
	@Override
	public int boardUpdate(TripBoardVO vo) {
		return dao.boardUpdate(vo);
	}
	
	@Override
	public int boardDelete(int no, String userid) {
		return dao.boardDelete(no, userid);
	}
	
//--------------------------- ´ñ±Û
	@Override
	public List<CommentVO> commentList(int no) {
		return dao.commentList(no);
	}

	@Override
	public int commentInsert(CommentVO cVO) {
		return dao.commentInsert(cVO);
	}
	
	@Override
	public int commentUpdate(CommentVO cVO) {
		return dao.commentUpdate(cVO);
	}

	@Override
	public int commentDelete(int comno, String userid) {
		return dao.commentDelete(comno, userid);
	}
	
	
}
