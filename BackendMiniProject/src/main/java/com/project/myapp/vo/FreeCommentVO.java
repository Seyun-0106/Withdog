package com.project.myapp.vo;

public class FreeCommentVO {
	private int fcomno;	//댓글 번호
	private int fno;	//글 번호
	private String userid;
	private String username;	
	private String content;
	private String writedate;
	private String ismodified;
	
	public int getFcomno() {
		return fcomno;
	}
	public void setFcomno(int fcomno) {
		this.fcomno = fcomno;
	}
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
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
