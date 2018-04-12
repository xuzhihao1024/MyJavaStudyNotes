## URLConnection  
public abstract class URLConnection extends Object  
抽象类 URLConnection 是所有类的超类，它代表应用程序和URL之间的通信链接。  
此类的实例可用于读取和写入此 URL 引用的资源。  

通常，创建一个到 URL 的连接需要几个步骤：

openConnection() | connect()
--- | ---
对影响到远程资源连接的参数进行操作。 | 与资源交互；查询头字段和内容。
---------------------------->  
                        时间
                        

1. 通过在URL上调用openConnection()方法创建连接对象(连接那台主机)。(此时不用再写socket了,它已经帮我们做了连接)
2. 处理设置参数和一般请求属性。
3. 使用connect()方法建立到远程对象的实际连接。
4. 远程对象变为可用。远程对象的头字段和内容变为可访问。
 
 
 
