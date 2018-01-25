package TestOther;

import com.example.demo.DemoApplication;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@WebAppConfiguration

public class testCacheable {

	 @Autowired
	 private IUserService userService;

	@Test
	public  void test(){
		System.out.println("=========first");//从db
		List<UserEntity> list=userService.queryUserInfoById("2");
		System.out.println(list);

		System.out.println("=========second");//从缓存
		List<UserEntity> listSecond=userService.queryUserInfoById("2");
		System.out.println(listSecond);




	}

}
