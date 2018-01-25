package TestStream;

import org.apache.el.stream.Stream;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.joining;

public class Test {

	@org.junit.Test
	public  void  test(){

	Trader raoul=new  Trader("Raoul","Cambridge");
	Trader mario=new Trader("Mario","Milan");
	Trader alan=new Trader("Alan","Cambridge");
	Trader brian=new Trader("Brian","Cambridge");

     //转换集合
     List<Transaction> transactions= Arrays.asList(
 	      	new Transaction(raoul,2011,300),
		     new Transaction(raoul,2011,1000),
		     new Transaction(alan,2013,900),
		     new Transaction(brian,2017,800)

        );
     //找出2011年的所有交易额，并且按照交易额进行排序，转化为list
    /* List<Transaction> tr2011= transactions.stream()
		     .filter(transaction -> transaction.getYear()==2011)//给filter传递一个谓词来选择2011年的交易
		     .sorted(comparing(Transaction::getValue))//按照交易额进行排序
		     .collect(Collectors.toList());//将生成的stream中的所有元素搜集到一个List中
		System.out.println(tr2011);*/

		//交易员在不同的城市工作过
	/*	List<String> cities=transactions.stream()
				.map(transaction -> transaction.getTrader().getCity())  //提取交易员所在的城市
				.distinct()  //只选择互不相同的城市
				.collect(Collectors.toList());
		//也可以这样写，不写distinct,直接写为toSet(set是不重复的)
		System.out.println(cities);*/

		 //打印生活在剑桥的交易员的所有交易额
		/*transactions.stream()
				//选择住在剑桥的交易员所进行的交易
				.filter(t->t.getTrader().getCity().equals("Cambridge"))
				.map(Transaction::getValue) //提取这些交易的交易额
				.forEach(System.out::println);//打印每个值*/

		//所有的交易中，最高的交易额是多少
		/*Optional<Integer> highestValue=transactions.stream()
				.map(Transaction::getValue)
				.reduce(Integer::max);
		 System.out.println("========="+highestValue);*/

		 //======由值创建流
	  java.util.stream.Stream<String> stream= java.util.stream.Stream.of("java 8","Lamadas","in","Actopm");
	 //转化为大写
	   stream.map(String::toUpperCase).forEach(System.out::println);

	   //=======由数组创建值,总和是41
		int [] numbers={2,3,5,7,11,13};
		int sum=Arrays.stream(numbers).sum();


	}

	//用指令风格对交易按照货币分组
	@org.junit.Test
	public  void  testMoney(){

		//建立累计交易分组的map
		Trader raoul=new  Trader("Raoul","Cambridge");
		Trader mario=new Trader("Mario","Milan");
		Trader alan=new Trader("Alan","Cambridge");
		Trader brian=new Trader("Brian","Cambridge");

		//转换集合
		List<Transaction> transactions= Arrays.asList(
				new Transaction(raoul,2011,300),
				new Transaction(raoul,2011,1000),
				new Transaction(alan,2013,900),
				new Transaction(brian,2017,800)
		);
      //高效的执行效果，得到的Like数据。服务器测试//新的日期和apid的测试
		transactions.stream().forEach(p->System.out.println(p.getValue()));
	}
}
