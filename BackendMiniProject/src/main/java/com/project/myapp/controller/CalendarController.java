package com.project.myapp.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.myapp.service.CalendarService;
import com.project.myapp.vo.CalendarVO;

@RestController
public class CalendarController {
	@Inject
	CalendarService service;
	
	//Ķ���� ������
	@GetMapping("/calendar/calendarView")
	public ModelAndView calendarView(CalendarVO vo) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("calendar/calendarView");
		return mav;
	}
	//���� ��� ���
	@GetMapping("/calendar/allSelect")
	public List<CalendarVO> calendarAllSelect(CalendarVO vo){
		return service.calendarAllSelect();
	}
	
	//���� ���
	@GetMapping("/calendar/select")
	public List<CalendarVO> calendarSelect(CalendarVO vo){
		return service.calendarSelect();
	}
	//���� �߰�
	@PostMapping("/calendar/insert")
	public int calendarInsert(CalendarVO vo, HttpSession session) {
		vo.setUserid((String)session.getAttribute("logid"));
		return service.calendarInsert(vo);
	}
	
	//���� ����
	@GetMapping("/calendar/delete")
	public int calendarDelete(int cno) {
		return service.calendarDelete(cno);
	}
	
}
