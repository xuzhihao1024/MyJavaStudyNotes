# Calendar类
1> java.util.Calendar 	public abstract class Calendar extends Object implements Serializable, Cloneable, Comparable<Calendar>

> Calendar 类是一个抽象类，它为特定瞬间与一组诸如 YEAR、MONTH、DAY_OF_MONTH、HOUR 等 日历字段之间的转换提供了一些方法，并为操作日历字段（例如获得下星期的日期）提供了一些方法
> 1. Calendar.YEAR
> 2. Calendar.MONTH
> 3. Calendar.DAY_OF_MONTH
> 4. Calendar.DAY_OF_WEEK

- 设置日历字段 YEAR、MONTH 和 DAY_OF_MONTH 的值
    - void set(int year, int month, int date)
- 返回给定日历字段的值
    - int get(int field)
- 根据日历的规则，为给定的日历字段添加或减去指定的时间量
    - void add(int field, int amount)


```
import java.util.*;
import java.text.*;

class  CalendarDemo
{
	public static void main(String[] args) 
	{

		Calendar c = Calendar.getInstance();


		String[] mons = {"一月","二月","三月","四月"
					,"五月","六月","七月","八月"
					,"九月","十月","十一月","十二月"};


		String[] weeks = {
						"","星期日","星期一","星期二","星期三","星期四","星期五","星期六",
							};		
		int index = c.get(Calendar.MONTH);

		int index1 = c.get(Calendar.DAY_OF_WEEK);

		sop(c.get(Calendar.YEAR)+"年");
		//sop((c.get(Calendar.MONTH)+1)+"月");
		sop(mons[index]);
		sop(c.get(Calendar.DAY_OF_MONTH)+"日");
		//sop("星期"+c.get(Calendar.DAY_OF_WEEK));
		sop(weeks[index1]);

		/*
		Date d = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

		String year = sdf.format(d);

		System.out.println(year);

		*/
	}

	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}

```

2> public class GregorianCalendar extends Calendar
GregorianCalendar   
GregorianCalendar是Calendar 的一个具体子类，提供了世界上大多数国家/地区使用的标准日历系统。

3 > 两个练习：

```
import java.util.*;

/*
两个练习：
1，获取任意年的二月有多少天。
	思路：根据指定年设置一个时间就是 
	c.set(year,2,1)//某一年的3月1日。
	c.add(Calenar.DAY_OF_MONTH,-1);//3月1日，往前推一天，就是2月最后一天。


2，获取昨天的现在这个时刻。
	c.add(Calenar.DAY_OF_MONTH,-1);
*/


class  CalendarDemo2
{
	public static void main(String[] args) 
	{

		Calendar c = Calendar.getInstance();

		//c.set(2012,2,23);

		c.add(Calendar.DAY_OF_MONTH,-18);
		
		printCalendar(c);
	}

	public static void printCalendar(Calendar c)
	{
		String[] mons = {"一月","二月","三月","四月"
					,"五月","六月","七月","八月"
					,"九月","十月","十一月","十二月"};


		String[] weeks = {
						"","星期日","星期一","星期二","星期三","星期四","星期五","星期六",
							};		
		int index = c.get(Calendar.MONTH);

		int index1 = c.get(Calendar.DAY_OF_WEEK);

		sop(c.get(Calendar.YEAR)+"年");
		//sop((c.get(Calendar.MONTH)+1)+"月");
		sop(mons[index]);
		sop(c.get(Calendar.DAY_OF_MONTH)+"日");
		//sop("星期"+c.get(Calendar.DAY_OF_WEEK));
		sop(weeks[index1]);
	}
	public static void sop(Object obj)
	{
		System.out.println(obj);
	}
}

```

