# Calendar

## java.util.Calendar 	
public abstract class Calendar extends Object implements Serializable, Cloneable, Comparable<Calendar>

    Calendar 类是一个抽象类，它为特定瞬间与一组诸如: 
    YEAR、MONTH、DAY_OF_MONTH、HOUR等日历字段之间的转换提供了一些方法，并为操作日历字段（例如获得下星期的日期）提供了一些方法
        1. Calendar.YEAR
        2. Calendar.MONTH
        3. Calendar.DAY_OF_MONTH
        4. Calendar.DAY_OF_WEEK
        
设置日历字段 YEAR、MONTH 和 DAY_OF_MONTH 的值
 1. void set(int year, int month, int date)
返回给定日历字段的值
 2. int get(int field)
根据日历的规则，为给定的日历字段添加或减去指定的时间量
 3. void add(int field, int amount)

- public class GregorianCalendar extends Calendar
GregorianCalendar是Calendar的一个具体子类，提供了世界上大多数国家/地区使用的标准日历系统。
-  两个练习题：
[计算在校上课时间]
