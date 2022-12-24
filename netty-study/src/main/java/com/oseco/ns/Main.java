package com.oseco.ns;

import com.oseco.ns.aio.AioServer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        IServer bioServer = new BioServer(8999);
//        bioServer.start();
//        IServer nioServer = new NioServer(8990);
//        nioServer.start();

        IServer aioServer = new AioServer(8990);
        aioServer.start();
    }
}
