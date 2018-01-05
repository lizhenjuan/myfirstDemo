package TestOther;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class params {

  public  static  String packageKey(Object...objects){
  	StringBuffer stringBuffer= new StringBuffer();
  	stringBuffer.append(objects[0]);

  	if (stringBuffer.length()>0){
  		for (int i=1;i<objects.length;i++){
  			if (objects[i]!=null && !objects[i].toString().equals("") ){
  				stringBuffer.append(":").append(objects[i]);
		    }
	    }
    }

	System.out.println("========="+stringBuffer);
    return  stringBuffer.toString();


  }


  //将字符串拼接
	@Test
	public  void testPackageKey(){
  	    //
		//packageKey("userId","gendId","countryId");
		packageKey("11","23","45");
	}

	@Test
	public  void  testList(){
		String []str={"a","b","c"};
		 List list=Arrays.asList(str);
		System.out.println("========"+list);
		for (int i=0;i<str.length;i++){
			System.out.println(list.get(i));
		}

	}


}
