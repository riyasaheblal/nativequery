package com.example.TestPRojectMYSQL.Service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.TestPRojectMYSQL.Controller.UserController;
import com.example.TestPRojectMYSQL.Model.UsernamePwd;

public interface UserService {

	Map<String, String> readuserpwd();

	UsernamePwd saveuser(String username, String pwd, String oldpwd);

	Map<String, String> readuserodpwd();

	List<UsernamePwd> findAll();

	List<Map<String, Object>> savepwd();

	void savepwd(String username, String pwd, String oldpwd);

	UsernamePwd findByUsername(String username);

	
	
}
