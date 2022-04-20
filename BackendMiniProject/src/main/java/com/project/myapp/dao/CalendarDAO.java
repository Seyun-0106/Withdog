package com.project.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.myapp.vo.CalendarVO;

@Mapper
@Repository
public interface CalendarDAO {
	//일정 등록
	public int calendarInsert(CalendarVO vo);
	
	//일정 전체 목록
	public List<CalendarVO> calendarAllSelect();
	//일정 목록
	public List<CalendarVO> calendarSelect();
	
	//일정 삭제
	public int calendarDelete(int cno);
}
