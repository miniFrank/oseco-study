package com.oseco.ns.nio;

import com.oseco.ns.IServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @author panguanghua
 */
public class NioServer implements IServer {

    private final ServerSocketChannel serverSocketChannel;

    private int port = 8099;

    private Thread thread;

    public NioServer(int port) {
        this.port = port;
        try {
            //Java为非阻塞设置的类
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(this.port));
            //设置为非阻塞
            serverSocketChannel.configureBlocking(false);
            System.out.println("服务器已启动并监听" + this.port + "端口");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getMode() {
        return "NIO";
    }

    @Override
    public void start() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        try {
            while (true) {
                SocketChannel socketChannel = serverSocketChannel.accept();
                if (socketChannel == null) {
                    //表示没人连接
                    System.out.println("正在等待客户端请求连接...");
                    Thread.sleep(5000);
                } else {
                    System.out.println("当前接收到客户端请求连接...");
                }
                if (socketChannel != null) {
                    //设置为非阻塞
                    socketChannel.configureBlocking(false);
                    byteBuffer.flip();//切换模式  写-->读
                    int effective = socketChannel.read(byteBuffer);
                    if (effective != 0) {
                        String content = Charset.forName("utf-8").decode(byteBuffer).toString();
                        System.out.println(content);
                    } else {
                        System.out.println("当前未收到客户端消息");
                    }
                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void shutdown() {
        try {
            serverSocketChannel.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
