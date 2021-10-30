package com.pyyh.ms.collection.bussiness.test.initializer;

import com.pyyh.ms.collection.bussiness.test.handler.UDPHandler1;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.nio.NioDatagramChannel;

public class UDPInitializer1 extends ChannelInitializer<NioDatagramChannel>{

	@Override
	protected void initChannel(NioDatagramChannel arg0) throws Exception {
		// TODO Auto-generated method stub
		arg0.pipeline().addLast(new UDPHandler1());
	}
}
