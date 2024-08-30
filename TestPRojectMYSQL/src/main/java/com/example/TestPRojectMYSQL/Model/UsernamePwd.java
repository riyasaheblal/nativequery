package com.example.TestPRojectMYSQL.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="pwduser")
public class UsernamePwd {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String username;
	private String pwd;
	private String oldpwd;
	private String newpwd;
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
	public String getOldpwd() {
		return oldpwd;
	}
	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}
	public String getNewpwd() {
		return newpwd;
	}
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
	public UsernamePwd(String username, String pwd, String oldpwd, String newpwd) {
		super();
		this.username = username;
		this.pwd = pwd;
		this.oldpwd = oldpwd;
		this.newpwd = newpwd;
	}
	@Override
	public String toString() {
		return "UsernamePwd [username=" + username + ", pwd=" + pwd + ", oldpwd=" + oldpwd + ", newpwd=" + newpwd + "]";
	}
	public UsernamePwd() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
