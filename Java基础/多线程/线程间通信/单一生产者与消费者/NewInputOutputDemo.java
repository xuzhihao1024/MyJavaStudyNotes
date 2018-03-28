package java基础.多线程.线程间通信.单一生产者与消费者;

/**
 * 线程间通讯：
 * 其实就是多个线程在操作同一个资源，
 * 但是操作的动作不同。
 */
class NewRes {
    private String name;
    private String sex;
    private boolean flag = false;

    public synchronized void set(String name, String sex) {
        if (flag) {
            try {
                this.wait();
            } catch (Exception e) {
            }
        }
        this.name = name;
        this.sex = sex;
        flag = true;
        this.notify();
    }

    public synchronized void out() {
        if (!flag) {
            try {
                this.wait();
            } catch (Exception e) {
            }
        }
        System.out.println(name + "........" + sex);
        flag = false;
        this.notify();
    }
}

class NewInput implements Runnable {
    private NewRes r;

    NewInput(NewRes r) {
        this.r = r;
    }

    @Override
    public void run() {
        int x = 0;
        while (true) {
            if (x == 0) {
                r.set("mike", "man");
            } else {
                r.set("丽丽", "女女女女女");
            }
            x = (x + 1) % 2;
        }
    }
}

class NewOutput implements Runnable {
    private NewRes r;

    NewOutput(NewRes r) {
        this.r = r;
    }

    @Override
    public void run() {
        while (true) {
            r.out();
        }
    }
}

class NewInputOutputDemo {
    public static void main(String[] args) {
        NewRes r = new NewRes();

        new Thread(new NewInput(r)).start();
        new Thread(new NewOutput(r)).start();
        /*
        Input in = new Input(r);
		Output out = new Output(r);

		Thread t1 = new Thread(in);
		Thread t2 = new Thread(out);

		t1.start();
		t2.start();
		*/
    }
}





