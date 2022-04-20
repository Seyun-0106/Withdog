package com.project.myapp.service;

import java.util.List;

import com.project.myapp.vo.CalendarVO;

public interface CalendarService {
	//일정 추가
	public int calendarInsert(CalendarVO vo);
	
	//일정 전체 목록
	public List<CalendarVO> calendarAllSelect();
	
	//일정 목록
	public List<CalendarVO> calendarSelect();
	
	//일정 삭제
	public int calendarDelete(int cno);
}
