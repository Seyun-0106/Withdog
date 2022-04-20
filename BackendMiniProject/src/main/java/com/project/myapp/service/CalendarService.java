package com.project.myapp.service;

import java.util.List;

import com.project.myapp.vo.CalendarVO;

public interface CalendarService {
	//���� �߰�
	public int calendarInsert(CalendarVO vo);
	
	//���� ��ü ���
	public List<CalendarVO> calendarAllSelect();
	
	//���� ���
	public List<CalendarVO> calendarSelect();
	
	//���� ����
	public int calendarDelete(int cno);
}
