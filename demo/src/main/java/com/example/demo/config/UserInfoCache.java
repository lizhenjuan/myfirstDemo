/*
package com.example.demo.config;


import com.example.demo.entity.UserEntity;
import com.example.demo.usermapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserInfoCache {

	@Autowired
	private UserMapper userMapper;

	@Cacheable(value = "userInfoCache",key = "#userId+'_'+  #gender +'_' +#appid+'_CircleCountry'",sync =true )
	public List<UserEntity> userInfoCache(String userId){
		 return  userMapper.queryUserInfoById(userId);
	}


}
*/
