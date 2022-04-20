package com.project.myapp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.project.myapp.vo.CalendarVO;

@Mapper
@Repository
public interface CalendarDAO {
	//���� ���
	public int calendarInsert(CalendarVO vo);
	
	//���� ��ü ���
	public List<CalendarVO> calendarAllSelect();
	//���� ���
	public List<CalendarVO> calendarSelect();
	
	//���� ����
	public int calendarDelete(int cno);
}
