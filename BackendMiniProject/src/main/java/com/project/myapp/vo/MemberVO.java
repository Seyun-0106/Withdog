package com.project.myapp.vo;

public class MemberVO {
	private String userid;
	private String userpwd;
	private String username;
	private String email;
	
	private String userpwd2;	//수정될 비밀번호
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserpwd2() {
		return userpwd2;
	}
	public void setUserpwd2(String userpwd2) {
		this.userpwd2 = userpwd2;
	}
	
}
