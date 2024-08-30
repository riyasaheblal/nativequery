package com.example.TestPRojectMYSQL.Model;

public class UserPwdReq {

	
	private String username;
	private String pwd;
	private String newpwd;
	private String oldpwd;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNewpwd() {
		return newpwd;
	}
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
	public String getOldpwd() {
		return oldpwd;
	}
	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}
	@Override
	public String toString() {
		return "UserPwdReq [username=" + username + ", pwd=" + pwd + ", newpwd=" + newpwd + ", oldpwd=" + oldpwd + "]";
	}
	public UserPwdReq(String username, String pwd, String newpwd, String oldpwd) {
		super();
		this.username = username;
		this.pwd = pwd;
		this.newpwd = newpwd;
		this.oldpwd = oldpwd;
	}
	public UserPwdReq() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
