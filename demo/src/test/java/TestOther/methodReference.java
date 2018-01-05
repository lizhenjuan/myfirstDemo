package TestOther;

import com.example.demo.entity.UserEntity;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * 测试方法引用
 */
public class methodReference {

	@Test
	public  void  testMethodReference() {
		//混合测试
		List<UserEntity> people = new ArrayList<>();
		people.add(new UserEntity("11", "lizhenjuan"));
		people.add(new UserEntity("12", "pingguoyuan"));
		people.add(new UserEntity("13", "pingguoyuan"));

		//取出实体的Id
		//以前写法
		//System.out.println(people.stream().forEach(s->s.getuserId()));
		//::之后的写法
		List<String> ids = people.stream().map(UserEntity::getuserId).collect(toList());
		System.out.println("===========" + ids);

		//Second传入实体写法
		List<UserEntity> userList = Arrays.asList(new UserEntity("22", "hehongxia"),
				new UserEntity("23", "hexiaxia"),
				new UserEntity("24", "ouxiujuan"));

		//测试输出
		userList.stream()
				.filter(d -> d.getuserId().equals("ouxiujuan"))
				.map(UserEntity::getuserId)
				.collect(Collectors.toList());



	}

	@Test
	public  void testStream(){
		// stream 只能够遍历一次，遍历第二次会报错
		List<String> title=Arrays.asList("java8","In","Action");
		Stream<String> s=title.stream();
		s.forEach(System.out::println);
		//s.forEach(System.out::println);
	}

	@Test
	public  void testStream2(){

		//Second传入实体写法
		 List<UserEntity> userList = Arrays.asList(new UserEntity("22", "hehongxia"),
				new UserEntity("23", "hexiaxia"),
				new UserEntity("24", "ouxiujuan"));

		List<String> ids = userList.stream().map(UserEntity::getuserId).collect(toList());

		//测试得到
		List<Integer> numbers=Arrays.asList(1,2,3,4,5,6,2,4);
		numbers.stream().filter(i->i%2==0)
				.distinct()//返回不重复的元素
				.limit(2) //返回不超过给定长度的流（所需要的长度作为参数传递给limit）
				.forEach(System.out::println);

		//

	}

	@Test
	public  void  testForEach(){
		List<Integer> ids= Arrays.asList(2,1,3,4,5);
		// old以前的写法
		int sum=0;
		for (int x:ids){
			sum+=x;
		}
		System.out.println("===old====="+sum);




	}


}




