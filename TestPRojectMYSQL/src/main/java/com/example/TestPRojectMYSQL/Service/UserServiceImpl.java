package com.example.TestPRojectMYSQL.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TestPRojectMYSQL.Model.UsernamePwd;
import com.example.TestPRojectMYSQL.Repository.Userrepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private Userrepo userrepo;

	
	@Override
	public Map<String, String> readuserpwd() {
	    List<UsernamePwd> all = userrepo.findAll();
	    Map<String, String> resultMap = new HashMap();
	    for (UsernamePwd userPwd : all) {
	        resultMap.put(userPwd.getUsername(), userPwd.getPwd());
	    }
	    return resultMap;
	    
	}


	@Override
	public UsernamePwd saveuser(String username, String pwd,String oldpwd) {
		 UsernamePwd user = new UsernamePwd();
		    user.setUsername(username);
		    user.setPwd(pwd);
		    user.setOldpwd(oldpwd);
		    return userrepo.save(user);
	}


	@Override
	public Map<String, String> readuserodpwd() {
		  List<UsernamePwd> all = userrepo.findAll();
		    Map<String, String> resultMap = new HashMap();
		    for (UsernamePwd userPwd : all) {
		        resultMap.put(userPwd.getUsername(), userPwd.getOldpwd());
		    }
		    return resultMap;
	}


	@Override
	public List<UsernamePwd> findAll() {
	    List<UsernamePwd> all = userrepo.findAll();
		return all;
	}


	@Override
	public  List<Map<String, Object>> savepwd() {
            List<Map<String, Object>> test = userrepo.test();  
            
            return test;
		
	}


	@Override
	public void savepwd(String username, String pwd, String oldpwd) {
userrepo.updatePassword(pwd, oldpwd, username);	
	}


	@Override
	public UsernamePwd findByUsername(String username) {
        return userrepo.findByUsername(username);
    }

	


	


	

}
