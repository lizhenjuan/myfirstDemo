package com.example.demo.service;


import com.example.demo.entity.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IUserService {
	List<UserEntity> queryUserInfoById( String userId);

	void   updateUserCount( Integer userId,Integer count) throws Exception;

	/**
	 * 更新用户B的数量
	 * @param userId
	 * @param count
	 * @return
	 */
	Integer updateCount(Integer userId,Integer count);

	//根据记录ID查询其消费状态
	Integer   selectConsumeStateByRecordId(Integer recordId);

	/**
	 * 插入消费失败记录
	 * @param content
	 * @return
	 */
	  Integer insertFailureRecord(String content);
}
