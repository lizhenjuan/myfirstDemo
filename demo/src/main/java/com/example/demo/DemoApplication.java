package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableScheduling
public class DemoApplication {

	public static void main(String[] args) throws InterruptedException {
		/*org.springframework.context.ApplicationContext app= SpringApplication.run(DemoApplication.class, args);
		//启动时，即开始kafka监听
		while (true){
			Sender sender=app.getBean(Sender.class);
			sender.sendMessage();
			Thread.sleep(5000);
		}*/
		SpringApplication.run(DemoApplication.class, args);
	}

}
