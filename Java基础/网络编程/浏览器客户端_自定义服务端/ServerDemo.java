package Java基础.网络编程.浏览器客户端_自定义服务端;

/**
 * 服务端/客户端是基于网络应用的程序
 * 演示客户端和服务端。
 * <p>
 * 客户端：浏览器 (telnet)补充:Window里面一个dos远程登录命令：telnet是一个客户端软件
 * 服务端：自定义。
 * <p>
 * Http的请求消息头:
 * <p>
 * 127.0.0.1
 * GET / HTTP/1.1                                              //http目前两个版本:1.0   1.1
 * Accept: text/html, application/xhtml+xml, image/jxr,        //浏览器支持的类型
 * Accept-Language: zh-CN                                      //浏览器支持的语言是简体中文版
 * User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36 Edge/15.15063      //用户的一些信息
 * Accept-Encoding: gzip, deflate                              //支持的封装形式(比如支持压缩包gzip)
 * Host: 127.0.0.1:11000
 * Connection: Keep-Alive                                      //保持存活
 */

import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class ServerDemo {
    public static void main(String[] args) throws Exception {

        //建立服务
        ServerSocket ss = new ServerSocket(11000);

        Socket s = ss.accept();
        System.out.println(s.getInetAddress().getHostAddress());

        //获取请求信息
        InputStream in = s.getInputStream();

        byte[] buf = new byte[1024];

        int len = in.read(buf);

        System.out.println(new String(buf, 0, len));

        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        out.println("<font color='red' size='7'>客户端你好abc</font>");

        s.close();

        ss.close();
    }
}
