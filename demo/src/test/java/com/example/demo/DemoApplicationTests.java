package com.example.demo;

import com.example.demo.message.SenderTest;
import org.springframework.beans.factory.annotation.Autowired;


/*@RunWith(SpringRunner.class)
@SpringBootTest*/
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = DemoApplication.class)
public class DemoApplicationTests {

	@Autowired
	SenderTest sender;


	public void contextLoads() {
		sender.sendMessage();
	}

}
