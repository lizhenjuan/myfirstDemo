package com.example.demo.message;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class receiverTest {


	//@KafkaListener(topics = "demo")
	public  void test(String content){
		System.out.println("接收到的是："+content);

	}





}
