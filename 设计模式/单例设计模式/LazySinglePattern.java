package 单例设计模式;

/**
 * 懒汉式
 * 特点:实例的延迟加载,多线程访问的时候会有安全问题,可以加同步来解决
 *
 * @author xuzhihao
 */
public class LazySinglePattern {

    private static LazySinglePattern lazySinglePattern = null;

    //私有化构造函数
    private LazySinglePattern() {
    }

    //多线程下存在安全隐患
    /*public static LazySinglePattern getLazySinglePattern() {
        lazySinglePattern = new LazySinglePattern();
        return lazySinglePattern;
    }*/

    //改良后的饿汉式
    public static LazySinglePattern getLazySinglePattern() {

        /**
         原因在于任何一个线程在执行到第一个if判断语句时，如果Single对象已经创建，则直接获取即可，而不用判断是否能够获取锁，
         相对于上面使用同步函数的方法就提升了效率。 如果当前线程发现Single对象尚未创建，则再判断是否能够获取锁
         用双重判断可以解决效率问题
         */
        if (null == lazySinglePattern) {
            //使用的锁是:该类所属的字节码文件对象(静态里面是不可以写this的)
            synchronized (LazySinglePattern.class) {
                /**
                 1.如果能够获取锁，那么就通过第二个if判断语句判断是否需要创建Single对象。
                 因为可能当此线程获取到锁之前，已经有一个线程创建完Single对象，并且放弃了锁。 此时它便没有必要再去创建，可以直接跳出同步代码块，放弃锁，获取Single对象即可。 如果有必要，则再创建。
                 2.如果不能获取到锁，则等待，直至能够获取到锁为止，再按步骤一执行
                 */
                if (null == lazySinglePattern) {
                    lazySinglePattern = new LazySinglePattern();
                }
            }
        }
        return lazySinglePattern;
    }
}
