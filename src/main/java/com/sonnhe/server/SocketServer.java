package com.sonnhe.server;

import com.sonnhe.InterviewFrame2;
import org.slf4j.Logger;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * @author joqk
 * @Date 2017/12/4 15:38
 * @{description} socketServer服务器
 **/
public class SocketServer {
    private volatile boolean  flag = false;
    protected static Logger logger = (Logger) org.slf4j.LoggerFactory.getLogger(SocketServer.class);


    private ServerSocket serverSocket;
    /**
     * 启动socket服务
     */
    public  void startServer () {
        this.flag = true;
        try {

            serverSocket = new ServerSocket(2000);
            logger.info("socket服务器即将启动。。。。。"+"监听的端口为:"+serverSocket.getLocalPort());
            Socket socket =null;
            int count = 0;
            //循环监听等待客户端连接
            while (flag){
                logger.info("循环中....."+flag);
                //调用accept
                socket  =serverSocket.accept();
                //创建一个新线程
//                ServerThread serverThread = new ServerThread(socket);
                ProtocalThread protocalThread = new ProtocalThread(socket);
                //设置优先级，范围为【1-10】，默认为5，未设置优先级会导致线程运行时速度慢
                protocalThread.setPriority(4);
                protocalThread.start();
                count ++;
                logger.info("客户端的数量为:"+count);
                InetAddress address = socket.getInetAddress();
                logger.info("当前客户端的IP:"+address.getHostAddress());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            logger.info("已经关闭socket连接");
            serverSocket.close();
        }catch (SocketException e){
            e.printStackTrace();
            try {

                serverSocket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {

                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 停止服务
     */
    public  void stopServer () {
        logger.info("socket服务器即将关闭。。。。。");
        this.flag = false;
//        try {
//            serverSocket.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        logger.info("关闭后的标记为:"+flag);

    }
}
