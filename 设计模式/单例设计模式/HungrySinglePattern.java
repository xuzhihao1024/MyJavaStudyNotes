package 单例设计模式;

/**
 * 饿汉式
 * 饿汉式不存在安全问题，因为不存在多个线程共同操作数据的情况
 *
 * @author xuzhihao
 */
public class HungrySinglePattern {

    /**
     * 加上final更加严谨,s就终身指向了new HungrySinglePattern()
     * 将s锁住了
     */
    private static final HungrySinglePattern hungrySinglePattern = new HungrySinglePattern();

    /**
     * 私有化构造函数
     */
    private HungrySinglePattern() {
    }

    public static HungrySinglePattern getHungrySinglePattern() {
        return hungrySinglePattern;
    }
}
