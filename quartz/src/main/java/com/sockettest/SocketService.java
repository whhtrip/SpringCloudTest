package com.sockettest;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author:WangHongHao
 * @date:19-11-18创建
 * @date：修改
 * @description：
 */
public class SocketService {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        int i = 0;
        while (true) {
            try {
                if (serverSocket == null) {
                    System.out.println("开始创建ServerSocket");
                    serverSocket = new ServerSocket(9999);
                }
                Socket accept = serverSocket.accept();
                InputStream inputStream = accept.getInputStream();
                byte[] b20 = new byte[20];
                int read = inputStream.read(b20);
                StringBuffer stringBuffer = new StringBuffer();
                while (read != -1) {
                    stringBuffer.append(new String(b20, "utf-8"));
                    read = inputStream.read(b20);
                }
                System.out.println(stringBuffer.toString() +"  "+ i++);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
