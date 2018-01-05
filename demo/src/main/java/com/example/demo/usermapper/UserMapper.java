package com.example.demo.usermapper;

import com.example.demo.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface UserMapper {

	//UserEntity queryUserInfoById(@Param("userId") String userId);
	List<UserEntity> queryUserInfoById(@Param("userId")  String userId);

	/**
	 * 更新用户数量
	 * @param userId
	 * @param count
	 * @return  Integer
	 */
	 Integer  updateUserCount(@Param("userId") Integer userId,@Param("count") Integer count);

}
