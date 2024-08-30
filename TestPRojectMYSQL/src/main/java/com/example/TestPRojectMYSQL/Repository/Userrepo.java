package com.example.TestPRojectMYSQL.Repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.TestPRojectMYSQL.Model.UsernamePwd;

import jakarta.transaction.Transactional;


@Repository
public interface Userrepo extends JpaRepository<UsernamePwd, Integer> {

	@Query(value="select * from pwduser", nativeQuery=true)
	public List<Map<String,Object>> test();
	
	
	UsernamePwd findByUsername(String username);
	
	@Modifying
    @Transactional
    @Query(value="UPDATE pwduser SET pwd = ?1, oldpwd = ?2 WHERE username = ?3", nativeQuery=true)
    void updatePassword(String pwd, String oldpwd, String username);

}
