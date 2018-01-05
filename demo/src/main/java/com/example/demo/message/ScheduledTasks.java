package com.example.demo.message;

import com.example.demo.service.ServiceImpl.UserServiceImpl;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;


@Component
public class ScheduledTasks {

     @Autowired
	UserServiceImpl userService;


	//@Scheduled(fixedRate = 5000)//每五分钟执行一次定时任务
	public  void  reportCurrent(){
           System.out.println("==========开始执行定时任务===========");
		Integer status=1;
		// userService.publishList(status);
		 //定时消费（消费失败）的记录
		userService.consumeFailRecord(status);

	 }

}
