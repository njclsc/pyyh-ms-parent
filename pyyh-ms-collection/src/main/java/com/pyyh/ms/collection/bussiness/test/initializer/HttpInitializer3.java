package com.pyyh.ms.collection.bussiness.test.initializer;

import com.pyyh.ms.collection.bussiness.test.handler.HttpHandler3;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;

public class HttpInitializer3 extends ChannelInitializer<SocketChannel>{

	@Override
	protected void initChannel(SocketChannel arg0) throws Exception {
		// TODO Auto-generated method stub
		arg0.pipeline().addLast(new HttpHandler3());
	}
}
