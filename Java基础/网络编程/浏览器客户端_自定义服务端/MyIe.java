package Java基础.网络编程.浏览器客户端_自定义服务端;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 客户端:自定义
 * 服务端:Tomcat服务器
 * <p>
 * http://127.0.0.1:11000/myweb/demo.html
 * <p>
 * GET /myweb/demo.html HTTP/1.1
 * Accept: application/x-shockwave-flash, image/gif, image/x-xbitmap, image/jpeg, i
 * mage/pjpeg, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword, application/QVOD, application/QVOD,
 * Accept-Language: zh-cn
 * Accept-Encoding: gzip, deflate
 * User-Agent: Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 2.0.50727)
 * Host: 127.0.0.1:11000
 * Connection: Keep-Alive
 */
class MyIe {

    public static void main(String[] args) throws Exception {

        //访问本地tomcat服务器
        Socket s = new Socket("127.0.0.1", 8080);

        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        /**
         *模仿浏览器发送的请求
         */
        //资源路径/资源
        out.println("GET /myDemo/MyIe.html HTTP/1.1");

        out.println("Accept: */*");
        out.println("Accept-Language: zh-cn");
        out.println("Host: 127.0.0.1:11000");
        out.println("Connection: Keep-Alive");

        //写空行(一定要与请求体分开)
        out.println();
        out.println();
        //从本地tomcat服务器读数据
        BufferedReader bufr = new BufferedReader(new InputStreamReader(s.getInputStream()));

        String line;
        while ((line = bufr.readLine()) != null) {
            //直接将内容打印在控制台上
            System.out.println(line);
        }
        //关闭资源
        s.close();
    }
}
