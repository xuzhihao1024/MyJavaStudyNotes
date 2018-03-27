package Java基础.多线程.deadlockdemo;

/**
 * 死锁示例
 * 场景:同步中嵌套同步,而使用的锁却不同(双方各执着对方的锁)
 */
class Ticket implements Runnable {

    private static int num = 100;
    Object obj = new Object();
    boolean flag = true;

    @Override
    public void run() {
        if (flag) {
            while (true) {
                /**
                 * run方法中的同步代码块需要获取obj对象锁，才能执行代码块中的show方法
                 */
                synchronized (obj) {
                    /**
                     * 执行show方法则必须获取this对象锁，然后才能执行其中的同步代码块
                     * 当线程t1获取到obj对象锁执行同步代码块，线程t2获取到this对象锁执行show方法。 同步代码块中的show
                     方法因无法获取到this对象锁无法执行，show方法中的同步代码块因无法获取到obj对象锁无法执行，就会产生死锁
                     */
                    //同步代码块里有同步函数
                    System.out.println("run方法:"+Thread.currentThread().getName()+"获取了obj锁");
                    show();
                }
            }
        } else {
            while (true) {
                show();
            }
        }
    }

    public synchronized void show() {  //锁是this
        System.out.println("show方法:"+Thread.currentThread().getName()+"获取了this锁");
        //同步函数里有同步代码块
        synchronized (obj) {
            if (num > 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("show方法:"+Thread.currentThread().getName() + "...function获取了obj锁..." + num--);
            }
        }
    }
}
