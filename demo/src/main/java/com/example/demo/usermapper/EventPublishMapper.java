package com.example.demo.usermapper;


import com.example.demo.entity.EventPublish;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EventPublishMapper {

	/**
	 * 插入用户记录
	 * @param conent
	 * @param eventType
	 * @return
	 */
	Integer insertUserCountRecord(@Param("conent") String conent, @Param("eventType") String eventType);


	//查找所有状态为“未消费”并且“用户更新数量”
	List<EventPublish>  queryEventPublishu(@Param("enventType") String enventType);

	//更新记录状态为“已发送”
	Integer updateEventPublish(@Param("recordId") Integer recordId,@Param("status") Integer status);

	//更新消费状态为“已消费”
   Integer updateEventPublishStatus(@Param("recordId") Integer recordId,@Param("status") Integer status);

   //根据记录ID查询未其被消费的记录状态
	Integer  selectConsumeStateByRecordId(@Param("recordId")Integer recordId);

	/**
	 * 查询状态为未发送的消息记录
	 */
	List<EventPublish> publishList(@Param("state")Integer state);

}
