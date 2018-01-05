package com.example.demo.message;

import com.example.demo.entity.EventPublish;
import com.example.demo.usermapper.EventPublishMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 任务调度器
 */
public class EventScheduler {

	@Autowired
	private EventPublishMapper eventPublishMapper;

	//查询所有状态为“未提交”并且类型是“用户更新数量”的事件
	List<EventPublish> publishes=eventPublishMapper.queryEventPublishu("用户更新数量");
	// kafkaTemplate.send("test1",userId+count);







}
