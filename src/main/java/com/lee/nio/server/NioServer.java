package com.lee.nio.server;

import io.netty.channel.ServerChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * Author :Lee
 * Since :2018/8/22下午1:44
 * Desc :NioServer Do What ?
 */
public class NioServer  {



    public static void main(String [] args) throws IOException {

        ServerSocket serverSocket;
        ServerSocketChannel serverChannel = ServerSocketChannel.open(); //
        serverSocket = serverChannel.socket();
        serverChannel.configureBlocking(false);
        serverSocket.setSoTimeout(5000);
        serverSocket.bind(new InetSocketAddress(10092));

        Selector selector = Selector.open();

        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        for(;;)
        {

            try {selector.select();
            } catch (IOException ex) {
                ex.printStackTrace();

            }

        }

    }
}