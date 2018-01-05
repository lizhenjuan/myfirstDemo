package com.example.demo.coutmapper;


import com.example.demo.entity.EventPublish;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface CountMapper {

	/**
	 * 插入数量
	 * @param  userId
	 * @param  count
	 * @return
	 */
	Integer updateCount(@Param("userId")Integer userId,@Param("count")Integer count);

	/**
	 * 插入失败记录
	 */
	Integer  insertFailureRecord(@Param("content")String content);
}
