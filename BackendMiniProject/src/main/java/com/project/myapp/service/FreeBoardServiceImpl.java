package com.project.myapp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.project.myapp.dao.FreeBoardDAO;
import com.project.myapp.vo.CommentVO;
import com.project.myapp.vo.FreeBoardVO;
import com.project.myapp.vo.FreeCommentVO;
import com.project.myapp.vo.PagingVO;

@Service
public class FreeBoardServiceImpl implements FreeBoardService {

	@Inject
	FreeBoardDAO dao;
	
	@Override
	public int boardInsert(FreeBoardVO vo) {
		return dao.boardInsert(vo);
	}

	@Override
	public List<FreeBoardVO> boardList(PagingVO pVO) {
		return dao.boardList(pVO);
	}

	@Override
	public int totalRecord(PagingVO pVO) {

		return dao.totalRecord(pVO);
	}

	@Override
	public FreeBoardVO boardSelect(int fno) {
		return dao.boardSelect(fno);
	}

	@Override
	public int boardUpdate(FreeBoardVO vo) {
		return dao.boardUpdate(vo);
	}
	
	@Override
	public int boardDelete(int fno, String userid) {
		return dao.boardDelete(fno, userid);
	}
	
	@Override
	public List<FreeCommentVO> commentList(int fno) {
		return dao.commentList(fno);
	}

	@Override
	public int commentInsert(FreeCommentVO fVO) {
		return dao.commentInsert(fVO);
	}

	@Override
	public int commentUpdate(FreeCommentVO fVO) {
		return dao.commentUpdate(fVO);
	}

	@Override
	public int commentDelete(int fcomno, String userid) {
		return dao.commentDelete(fcomno, userid);
	}


}
