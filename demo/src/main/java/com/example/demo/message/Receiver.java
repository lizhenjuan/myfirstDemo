package com.example.demo.message;

import com.alibaba.fastjson.JSON;
import com.example.demo.coutmapper.CountMapper;
import com.example.demo.service.IUserService;
import com.example.demo.service.ServiceImpl.RedisService;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.alibaba.fastjson.JSONObject;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {


     @Autowired
    private IUserService userService;
     @Autowired
	RedisService redisService;


@KafkaListener(topics = "demo")
  public  void processMessage(String record){
        //解析接收到的数据
	  MessageVo messageVo=JSON.parseObject(record,MessageVo.class);
         if (record!=null) {
	        Integer recordId = messageVo.getRecordId();
	         System.out.println("========consumer开始消费");
	         //从redis中查询消费状态
	         Integer consumeStatus=  (Integer) redisService.get("consumeStatus"+recordId);
	         if (consumeStatus!=null && consumeStatus.equals(1)) {
		         // 1:未消费，执行消费操作
		         Integer num = userService.updateCount(messageVo.getUserId(), messageVo.getCount());
		         System.out.println("==========consumer消费数量：" + num);
		         if (num>0){
			         //将消费状态更新在redis中
			         redisService.set("consumeStatus",2);
		         }else {
		         	//执行失败，将消息写入DB
			         userService.insertFailureRecord(record);
		         }
	         }
         }
	}
}
