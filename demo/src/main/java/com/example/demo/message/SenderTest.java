package com.example.demo.message;

import com.example.demo.DemoApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import java.util.Date;


@Component
public class SenderTest {
	@Autowired
	private KafkaTemplate kafkaTemplate;


 public  void  sendMessage(){
 	Message m=new Message();
 	m.setId(11);
 	m.setMessage("Hello Kafka");
 	m.setSendTime(new Date());
 	//send是两个 参数，第一个参数是topic,第二个参数是Message数据
    kafkaTemplate.send("demo","hello");
 }

}
