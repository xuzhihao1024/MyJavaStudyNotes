package Java基础.多线程.线程间通信.单一生产者与消费者;

/**
 * 线程间通讯：
 * 其实就是多个线程在操作同一个资源，但是操作的动作不同。
 * <p>
 * wait:
 * notify();
 * notifyAll();
 * <p>
 * 都使用在同步中，因为要对持有监视器(锁)的线程操作。
 * 所以要使用在同步中，因为只有同步才具有锁。
 * <p>
 * 为什么这些操作线程的方法要定义Object类中呢？
 * 因为这些方法在操作同步中线程时，都必须要标识它们所操作线程只有的锁，
 * 只有同一个锁上的被等待线程，可以被同一个锁上notify唤醒。
 * 不可以对不同锁中的线程进行唤醒。
 * <p>
 * 也就是说，等待和唤醒必须是同一个锁。
 * <p>
 * 而锁可以是任意对象，所以可以被任意对象调用的方法定义Object类中。
 * <p>
 * wait:
 * notify();
 * notifyAll();
 * <p>
 * 都使用在同步中，因为要对持有监视器(锁)的线程操作。
 * 所以要使用在同步中，因为只有同步才具有锁。
 * <p>
 * 为什么这些操作线程的方法要定义Object类中呢？
 * 因为这些方法在操作同步中线程时，都必须要标识它们所操作线程只有的锁，
 * 只有同一个锁上的被等待线程，可以被同一个锁上notify唤醒。
 * 不可以对不同锁中的线程进行唤醒。
 * <p>
 * 也就是说，等待和唤醒必须是同一个锁。
 * <p>
 * 而锁可以是任意对象，所以可以被任意对象调用的方法定义Object类中。
 * <p>
 * wait:
 * notify();
 * notifyAll();
 * <p>
 * 都使用在同步中，因为要对持有监视器(锁)的线程操作。
 * 所以要使用在同步中，因为只有同步才具有锁。
 * <p>
 * 为什么这些操作线程的方法要定义Object类中呢？
 * 因为这些方法在操作同步中线程时，都必须要标识它们所操作线程只有的锁，
 * 只有同一个锁上的被等待线程，可以被同一个锁上notify唤醒。
 * 不可以对不同锁中的线程进行唤醒。
 * <p>
 * 也就是说，等待和唤醒必须是同一个锁。
 * <p>
 * 而锁可以是任意对象，所以可以被任意对象调用的方法定义Object类中。
 */
/**
 wait:
 notify();
 notifyAll();

 都使用在同步中，因为要对持有监视器(锁)的线程操作。
 所以要使用在同步中，因为只有同步才具有锁。

 为什么这些操作线程的方法要定义Object类中呢？
 因为这些方法在操作同步中线程时，都必须要标识它们所操作线程只有的锁，
 只有同一个锁上的被等待线程，可以被同一个锁上notify唤醒。
 不可以对不同锁中的线程进行唤醒。

 也就是说，等待和唤醒必须是同一个锁。

 而锁可以是任意对象，所以可以被任意对象调用的方法定义Object类中。

 */

/**
 * 自定义资源
 */
class Res {
    String name;
    String sex;
    boolean flag = false;
}

/**
 * 自定义输入
 */
class Input implements Runnable {
    private Res r;

    Input(Res r) {
        this.r = r;
    }

    @Override
    public void run() {
        int x = 0;
        while (true) {
            synchronized (r) {
                if (r.flag) {
                    try {
                        r.wait();
                    } catch (Exception e) {
                    }
                }
                if (x == 0) {
                    r.name = "mike";
                    r.sex = "man";
                } else {
                    r.name = "丽丽";
                    r.sex = "女女女女女";
                }
                x = (x + 1) % 2;
                r.flag = true;
                r.notify();
            }
        }
    }
}

/**
 * 自定义输出
 */
class Output implements Runnable {
    private Res r;

    Output(Res r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (r) {
                if (!r.flag) {
                    try {
                        r.wait();
                    } catch (Exception e) {
                    }
                }
                System.out.println(r.name + "...." + r.sex);
                r.flag = false;
                r.notify();
            }
        }
    }
}


class InputOutputDemo {
    public static void main(String[] args) {
        Res r = new Res();

        Input in = new Input(r);
        Output out = new Output(r);
        //两个线程操作的锁是同一个Res
        Thread t1 = new Thread(in);
        Thread t2 = new Thread(out);

        t1.start();
        t2.start();
    }
}