package com.looser.userservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.looser.userservice.Vo.Department;
import com.looser.userservice.Vo.ResponseTemplateVo;
import com.looser.userservice.entity.User;
import com.looser.userservice.repository.UserRepository;



@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public ResponseTemplateVo getUserWithDepartmentId(Long userId) {
		ResponseTemplateVo vo = new ResponseTemplateVo();
		User user = userRepository.findById(userId).orElse(null);
		
		RestTemplate restTemplate = new RestTemplate();
		Department department = restTemplate.getForObject("http://localhost:8080/departments/" + user.getDepartmentId(), Department.class);
		
		vo.setUser(user);
		vo.setDepartment(department);
		
		return vo;
	}
	
	/*
	 * public String getUserWithDepartment(String user) { RestTemplate restTemplate=
	 * new RestTemplate(); Department department =
	 * restTemplate.getForObject("http://localhost:8080/departments/depart/",
	 * Department.class); return user;
	 * 
	 * }
	 * 
	 */
}

