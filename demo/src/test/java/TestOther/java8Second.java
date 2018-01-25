package TestOther;

import com.example.demo.entity.UserEntity;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.sun.deploy.util.SessionState.save;

public class java8Second {

	@Test
	public void test1(){
		List<UserEntity> result =new ArrayList<>();
		UserEntity user=new UserEntity();
		user.setuserId("11");
		user.setAge(22);
		result.add(user);
		List<UserEntity> result2=new ArrayList<>();
		for (UserEntity u:result){
			if (u.getuserId()=="11"){
				result2.add(u);
			}
		}
         System.out.print(result2.get(0).getuserId()+"=================");

	}


	@Test
	public  void  test2(){

	}


}
