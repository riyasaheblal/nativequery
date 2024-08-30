package com.example.TestPRojectMYSQL.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.TestPRojectMYSQL.Model.UserPwdReq;
import com.example.TestPRojectMYSQL.Model.UsernamePwd;
import com.example.TestPRojectMYSQL.Service.UserService;


@RestController
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String test(@RequestBody UserPwdReq user) {
		String username = user.getUsername();
		String oldpwd = user.getOldpwd();
		String newpwd = user.getNewpwd();
		String pwd = user.getPwd();
		UsernamePwd byUsername = userService.findByUsername(username);
		if(byUsername!=null) {
		String username2 = byUsername.getUsername();
		if(byUsername.getUsername().equals(username)) {
			return "username already present";
		}}
		 oldpwd=pwd;
		 UsernamePwd saveuser = userService.saveuser(username,pwd,oldpwd);
		return "create new user";
	}
	

	
	
	@PostMapping("/resetpwd")
	public String resetpwd(@RequestBody UserPwdReq user) {
	    String username = user.getUsername();
	    String newPwd = user.getPwd();
	    
	    UsernamePwd existingUser = userService.findByUsername(username);
	    System.out.println(existingUser);
	    if (existingUser != null) {
	        String oldpwd = existingUser.getOldpwd();
	        List<String> oldPwdList = new ArrayList<>();
	        
	        if (oldpwd != null && !oldpwd.isEmpty()) {
	            oldPwdList.addAll(Arrays.asList(oldpwd.split(",")));
	        }

	        if (oldPwdList.contains(newPwd)) {
	            return "Error: New password cannot be one of the last three passwords.";
	        }
	        
	        if (oldPwdList.size() >= 3) {
	            oldPwdList.remove(0);  
	        }
	        oldPwdList.add(newPwd);  // Add the new password
	        
	        // Convert list back to a comma-separated string
	        String updatedOldPwd = String.join(",", oldPwdList);
	        
	        // Save the updated password and history
	        userService.savepwd(username, newPwd, updatedOldPwd);
	        
	        return "Password reset successfully.";
	    } else {
	        return "User not found.";
	    }
	}


	
	@GetMapping("/test")
	public List<Map<String, Object>> test1() {
		return this.userService.savepwd();
	}
	
}
