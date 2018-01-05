package TestOther;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class CalendarTest {

	@Test
	public  void test(){
		Date dateTime;
	    java.util.Calendar calendar = java.util.Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
		Date now=new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//可以方便地修改日期格式

		String hehe = dateFormat.format( now );
		System.out.println("当前时间年月日是："+hehe);

		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
		System.out.println("当前年份是："+c.get(Calendar.YEAR));
		System.out.println("当前月份是："+c.get(Calendar.MONTH));
		System.out.println("当前月份的第几天："+c.get(Calendar.DAY_OF_MONTH));
		System.out.println("当前星期的第几天："+c.get(Calendar.DAY_OF_WEEK));
		// 按这个月1号算，1号起就是第1周，8号起就是第2周。以月份天数为标准
		System.out.println("某月中的第几周: "+c.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		// （例如今天是8-21，是八月的第四周）
		System.out.println("日历式的第几周: "+c.get(Calendar.WEEK_OF_MONTH));
	}




}
