package com.oseco.ns.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class AioClient {
    private final Selector selector;

    private final SocketChannel socketChannel;

    public AioClient(String ip, int port) {
        try {
            // 获得一个Socket通道
            socketChannel = SocketChannel.open();
            // 设置通道为非阻塞
            socketChannel.configureBlocking(false);
            // 获得一个通道管理器
            selector = Selector.open();
            // 客户端连接服务器,其实方法执行并没有实现连接，需要在listen（）方法中调
            socketChannel.connect(new InetSocketAddress(ip, port));
            //将通道管理器和该通道绑定，并为该通道注册SelectionKey.OP_CONNECT事件。
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void start() throws IOException {
        // 轮询访问selector
        while (true) {
            selector.select();
            //获得selector中的选中的迭代器
            Iterator ite = this.selector
                    .selectedKeys().iterator();
            while (ite.hasNext()) {
                SelectionKey key = (SelectionKey) ite.next();
                //删除已选的key，以防止重复处理
                ite.remove();
                if (key.isConnectable()) {
                    SocketChannel channel = (SocketChannel) key
                            .channel();
                    if (channel.isConnectionPending()) {
                        channel.finishConnect();
                    }
                    channel.configureBlocking(false);
                    //在这里可以给服务端发送信息哦
                    channel.write(ByteBuffer.wrap(new String("hello,server").getBytes()));
                    //在和服务端连接成功之后，为了可以接收到服务端的信息，需要给通道设置读的权限。  
                    channel.register(selector, SelectionKey.OP_READ);
                } else if (key.isReadable()) {
                    read(key);
                }
            }
        }
    }

    /**
     * 处理读取服务端发来的信息 的事件
     *
     * @param key
     * @throws IOException
     */
    private void read(SelectionKey key) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(2048);
        //和服务端的read方法一样
        SocketChannel channel = (SocketChannel) key.channel();
        channel.read(byteBuffer);
        byte[] data = byteBuffer.array();
        String msg = new String(data);
        System.out.println("客户端收到的消息：" + msg);
    }
}
