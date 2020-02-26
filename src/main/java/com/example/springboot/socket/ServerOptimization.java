package com.example.springboot.socket;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description : desc
 * @Author masz
 * @Date 2019/9/26 19:54
 */
public class ServerOptimization {
    public static void main(String[] args) throws Exception{
        //1.监听的端口
        int port = 8001;
        //2.创建ServerSocket绑定端口
        ServerSocket server = new ServerSocket(port);
        //3.服务器等待
        System.out.println("服务器等待中...");

        //创建线程池，多线程处理请求
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        while (true){
            Socket socket = server.accept();
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try{
                        System.out.println("服务器处理中...");
                        //4.得到客户端输入流
                        InputStream is = socket.getInputStream();
                        //5.读取流,输出信息
                        byte[] b = new byte[1024];
                        StringBuilder sb = new StringBuilder();
                        int len;
                        while ((len = is.read(b))!= -1){
                            sb.append(new String(b,0,len,"UTF-8"));
                        }
                        System.out.println("server get message from clent is : " + sb);

                        //6.响应消息给客户端
                        OutputStream os = socket.getOutputStream();
                        String respMessage = "Hello Client,I get your message.Good Luck!";
                        os.write(respMessage.getBytes("UTF-8"));
                        //7.关闭
                        os.close();
                        is.close();
                        socket.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            };

            executorService.submit(run);
        }

//        server.close();
//        System.out.println("服务器已关闭");
    }

}
