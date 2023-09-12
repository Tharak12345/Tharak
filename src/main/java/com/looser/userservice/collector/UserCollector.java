package com.looser.userservice.collector;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.looser.userservice.Vo.ResponseTemplateVo;
import com.looser.userservice.entity.User;
import com.looser.userservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserCollector {
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	@GetMapping("/{userId}")
	public ResponseTemplateVo getUserWithDepartmentId(@PathVariable Long userId) {
		return userService.getUserWithDepartmentId(userId);
	}
	/*
	 * @GetMapping("/user") public String getUserWithDepartment() { return
	 * userService.getUserWithDepartment(getUserWithDepartment()); }
	 */

}
