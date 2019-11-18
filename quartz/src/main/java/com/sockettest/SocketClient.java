package com.sockettest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author:WangHongHao
 * @date:19-11-18创建
 * @date：修改
 * @description：
 */
public class SocketClient {
    public static void main(String[] args) {
        int num = 0;
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            System.out.println("开始创建Socket");
                            Socket socket = new Socket("127.0.0.1", 9999);
                            OutputStream outputStream = socket.getOutputStream();
                            String writes = "hello";
                            outputStream.write(writes.getBytes());
                            outputStream.close();
                            socket.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).run();
        }
    }
}
