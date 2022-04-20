package com.project.myapp.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.project.myapp.dao.CalendarDAO;
import com.project.myapp.vo.CalendarVO;

@Service
public class CalendarServiceImpl implements CalendarService {
	@Inject
	CalendarDAO dao;

	@Override
	public int calendarInsert(CalendarVO vo) {
		return dao.calendarInsert(vo);
	}
	
	@Override
	public List<CalendarVO> calendarAllSelect() {
		return dao.calendarAllSelect();
	}

	@Override
	public List<CalendarVO> calendarSelect() {
		return dao.calendarSelect();
	}

	@Override
	public int calendarDelete(int cno) {
		return dao.calendarDelete(cno);
	}

	
}
