package com.example.springboot.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Description : desc
 * @Author masz
 * @Date 2019/9/26 18:21
 */
public class Client {

    public static void main(String[] args) throws Exception{
        //1.要连接的服务器ip + port
        String ip = "127.0.0.1";
        int port = 8001;
        //2.建立连接
        Socket socket = new Socket(ip,port);
        //3.得到输出流
        OutputStream os = socket.getOutputStream();
        //4.发送消息给服务器
        String message = "hello world2，你好世界。。";
        os.write(message.getBytes("UTF-8"));
        //5.告诉服务器已经发送了
        socket.shutdownOutput();
        //6.得到服务器响应
        InputStream is = socket.getInputStream();
        byte[] b = new byte[1024];
        int len;
        StringBuilder sb = new StringBuilder();
        while((len = is.read(b)) != -1){
            sb.append(new String(b,0,len,"UTF-8"));
        }
        System.out.println("Client get the respMessage from Server : " + sb);

        //7.关闭
        is.close();
        os.close();
        socket.close();
    }
}
