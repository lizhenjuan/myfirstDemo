package TestOther;

import com.example.demo.entity.UserEntity;
import com.example.demo.service.ServiceImpl.InvitationCodeEnum;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class java8 {

  @Test
	 public  void  streamTest(){

  	//过滤条件
	/*  Arrays.asList(1,4,2,3,5,6,7,8)
			  .stream()
			  .sorted()
			  .filter(x->x>3)//过滤
	          .forEach(System.out::println);*/

    //打印出开头是大写的字母
	/*  Arrays.asList("Abc","Bc","ac","op","IQ")
			  .stream()
			  .filter(s -> Character.isUpperCase(s.charAt(0)))
			  .forEach(System.out::println);*/

	   }

	   @Test
	   public  void  testStream(){
		   //混合测试
		   List<UserEntity> people= new ArrayList<>();
		   people.add( new  UserEntity("11","lizhenjuan"));
		   people.add(new UserEntity("12","pingguoyuan"));
		   people.add(new UserEntity("13","pingguoyuan"));

		   List<UserEntity> newPeople= new ArrayList<>();
		   // 以前写法
		   for (UserEntity userEntity:people){
                if (userEntity.getUserName().equals("pingguoyuan")){
                	newPeople.add(userEntity);
                }
		   }
		   System.out.println("=============="+newPeople.get(0).getuserId());
		   System.out.println("=============="+newPeople.get(1).getuserId());
		   //stram的用法
		  List<UserEntity>  list= people.stream().filter(s->s.getUserName().equals("pingguoyuan")).collect(Collectors.toList());
            System.out.println("===========secondTime"+list.get(0).getuserId());
		     System.out.println("==========secondTime"+newPeople.get(1).getuserId());
		     //数组foreach的用法
		   UserEntity userEntity=new UserEntity("14","hexiaoxia");
		   Arrays.stream(InvitationCodeEnum.values()).forEach(invitationCodeEnum ->
				   userEntity.setEnumCount(invitationCodeEnum.toString()) );
		   System.out.println("---------------"+userEntity.getEnumCount());

		   //-----测试比较的方法--------------------------------
          /* Comparable<UserEntity> userId=new Comparable<UserEntity>() {
	           @Override
	           public int compareTo(UserEntity s1,UserEntity s2) {
		           return s1.getuserId().compareTo(s2.getuserId()) ;
	           }
           }*/




	   }


}
