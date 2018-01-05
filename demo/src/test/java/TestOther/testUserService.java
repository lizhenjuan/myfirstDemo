package TestOther;

import com.example.demo.DemoApplication;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.alibaba.druid.sql.ast.SQLPartitionValue.Operator.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@WebAppConfiguration

public class testUserService {

	@Autowired
	private IUserService userService;

	@Test
	public   void  testForEach(){

		/*Arrays.asList("1","2").stream().forEach(id->{
		  java.util.List<UserEntity> userEntity = userService.queryUserInfoById(id);
		  System.out.println(userEntity.get(0).getuserId());
		});*/

		List<String> list=Arrays.asList("1","2");
		for (String id:list){
			List<UserEntity> userEntities=userService.queryUserInfoById(id);
			System.out.println(userEntities.get(0).getuserId());
		}


	}

}
