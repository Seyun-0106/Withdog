package com.project.myapp.vo;

public class CommentVO {
	private int comno;
	private String userid;
	private String username;
	private int no;
	private String content;
	private String writedate;
	private String ismodified;// 수정 여부
	
	public int getComno() {
		return comno;
	}
	public void setComno(int comno) {
		this.comno = comno;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	public String getIsmodified() {
		return ismodified;
	}
	public void setIsmodified(String ismodified) {
		this.ismodified = ismodified;
	}
	
	
}
