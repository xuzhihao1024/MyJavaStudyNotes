package Java基础.多线程.deadlockdemo;

class DeadLockDemo {
    public static void main(String[] args) {
        Ticket t = new Ticket();
        Thread t0 = new Thread(t);
        Thread t1 = new Thread(t);

        t0.start();
        try {
            System.out.println("main方法:"+Thread.currentThread().getName());
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.flag = false;
        t1.start();
    }
}