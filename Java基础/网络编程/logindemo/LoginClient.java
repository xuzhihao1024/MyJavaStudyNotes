package Java基础.网络编程.logindemo;

/**
 * 需求:模拟客户端并发登录
 * 客户端通过键盘录入用户名。
 * 服务端对这个用户名进行校验。
 * <p>
 * 如果该用户存在，在服务端显示xxx，已登陆。并在客户端显示 xxx，欢迎光临。
 * <p>
 * 如果该用户存在，在服务端显示xxx，尝试登陆。并在客户端显示 xxx，该用户不存在。
 * <p>
 * 最多就登录三次。
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 客户端
 */
class LoginClient {
    public static void main(String[] args) throws Exception {

        Socket s = new Socket("10.111.24.74", 10086);
        //读取键盘录入
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

        //将读到的数据发出去
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        //获取服务端返回的数据
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

        for (int x = 0; x < 3; x++) {
            String line = bufr.readLine();
            if (line == null) {
                break;
            }
            out.println(line);
            //读服务端的返回信息
            String info = bufIn.readLine();
            System.out.println("info:" + info);
            if (info.contains("欢迎")) {
                break;
            }
        }

        bufr.close();
        s.close();
    }
}

/**
 * 客户端封装线程
 */
class UserThread implements Runnable {

    private Socket s;

    UserThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip + "....connected");
        try {
            //服务端只校验三次
            for (int x = 0; x < 3; x++) {

                //获取客户端发过来的用户名
                BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

                String name = bufIn.readLine();
                if (name == null) {
                    break;
                }
                //读数据源文件
                BufferedReader bufr = new BufferedReader(new FileReader("user.txt"));

                PrintWriter out = new PrintWriter(s.getOutputStream(), true);

                String line;

                boolean flag = false;
                while ((line = bufr.readLine()) != null) {
                    if (line.equals(name)) {
                        flag = true;
                        break;
                    }
                }

                if (flag) {
                    System.out.println(name + ",已登录");
                    out.println(name + ",欢迎光临");
                    break;
                } else {
                    System.out.println(name + ",尝试登录");
                    out.println(name + ",用户名不存在");
                }
            }
            s.close();
        } catch (Exception e) {
            throw new RuntimeException(ip + "校验失败");
        }
    }
}

/**
 * 服务端
 */
class LoginServer {
    public static void main(String[] args) throws Exception {

        ServerSocket ss = new ServerSocket(10086);
        //获取多个客户端
        while (true) {
            Socket s = ss.accept();
            //来一个客户就封装一个线程
            new Thread(new UserThread(s)).start();
        }
    }
}
