package com.oseco.ns.aio;

import com.oseco.ns.IServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author panguanghua
 */
public class AioServer implements IServer {

    private final ServerSocketChannel serverSocketChannel;

    private int port = 8099;

    private final Selector selector;

    public AioServer(int port) {
        this.port = port;
        try {
            // 获得一个ServerSocket通道
            serverSocketChannel = ServerSocketChannel.open();
            // 设置通道为非阻塞
            serverSocketChannel.configureBlocking(false);
            // 将该通道对应的ServerSocket绑定到port端口
            serverSocketChannel.bind(new InetSocketAddress(this.port));
            System.out.println("服务器已启动并监听" + this.port + "端口");
            // 获得一个通道管理器
            selector = Selector.open();
            //当该事件到达时，selector.select()会返回，如果该事件没到达selector.select()会一直阻塞。
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getMode() {
        return "AIO";
    }

    @Override
    public void start() throws IOException {
        while (true) {
            //当注册的事件到达时，方法返回；否则,该方法会一直阻塞
            selector.select();
            Iterator ite = selector.selectedKeys().iterator();
            while (ite.hasNext()) {
                SelectionKey key = (SelectionKey) ite.next();
                // 删除已选的key,以防重复处理
                ite.remove();
                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key
                            .channel();
                    // 获得和客户端连接的通道
                    SocketChannel channel = server.accept();
                    // 设置成非阻塞
                    channel.configureBlocking(false);
                    //在这里可以给客户端发送信息哦
                    channel.write(ByteBuffer.wrap(new String("hello,client.").getBytes()));
                    channel.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    read(key);
                }
            }
        }
    }

    private void read(SelectionKey key) throws IOException {
        // 服务器可读取消息:得到事件发生的Socket通道
        SocketChannel channel = (SocketChannel) key.channel();
        // 创建读取的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(10);
        channel.read(buffer);
        byte[] data = buffer.array();
        String msg = new String(data).trim();
        System.out.println("服务端收到信息：" + msg);
        ByteBuffer outBuffer = ByteBuffer.wrap(msg.getBytes());
        channel.write(outBuffer);// 将消息回送给客户端
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
