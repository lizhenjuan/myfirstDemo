package com.example.demo.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("UserController")
public class UserController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value="/queryUserInfoById/{userId}",method =RequestMethod.GET)
	public List<UserEntity> queryUserInfoById(@PathVariable(value = "userId") String userId){
		return  userService.queryUserInfoById(userId);
	}

	/**
	 * 根據用戶ID更新數量
	 * @param userId
	 * @param count
	 */
	@RequestMapping(value = "/updateUserCount/{userId}/{count}",method = RequestMethod.PUT)
	public  void  updateUserCount(@PathVariable(value = "userId")Integer userId,
	                              @PathVariable(value = "count")Integer count) throws Exception {
		 userService.updateUserCount(userId,count);

	}

	/**
	 * 无关测试
	 * @param args
	 */
	public  static void  main(String[] args){
		Integer a =128;
		Integer b=128;
		if(a==b){
			System.out.println("=============");
		}else {
			System.out.println("------------");
		}

	}


}
