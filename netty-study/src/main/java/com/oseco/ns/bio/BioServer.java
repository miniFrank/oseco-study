package com.oseco.ns.bio;

import com.oseco.ns.IServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author panguanghua
 */
public class BioServer implements IServer {

    private final ServerSocket serverSocket;

    private int port = 8099;

    public BioServer(int port) {
        this.port = port;
        try {
            this.serverSocket = new ServerSocket(this.port);
            System.out.println("服务器已启动并监听" + this.port + "端口");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getMode() {
        return "BIO";
    }

    @Override
    public void start() {
        byte[] buffer = new byte[1024];
        try {
            while (true) {
                System.out.println();
                System.out.println("服务器正在等待连接...");
                Socket socket = serverSocket.accept();
                new Thread(() -> {
                    System.out.println("服务器已接收到连接请求...");
                    System.out.println();
                    System.out.println("服务器正在等待数据...");
                    try {
                        socket.getInputStream().read(buffer);
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println("服务器已经接收到数据");
                    System.out.println();
                    String content = new String(buffer);
                    System.out.println("接收到的数据:" + content);
                }).start();

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void shutdown() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
