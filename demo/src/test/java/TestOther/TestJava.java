package TestOther;

import java.util.ArrayList;
import java.util.List;

public class TestJava {
	public static void main(String[] args) {
		// java8 的新特性，lambda表达式，类似于匿名内部类

			List<String> list = new ArrayList<String>();
			list.add("a");
			list.add("b");
			list.add("c");
			list.add("aa");
			list.add("bb");
			list.add("cc");

			list.stream().filter(ss ->ss.length()==2 ).forEach(ss->{
				System.out.println(ss);
				System.out.println(ss.getClass());
				System.out.println(list.getClass());
			});

		}


}
