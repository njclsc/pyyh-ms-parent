package com.pyyh.ms.collection.bussiness.renwei.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class RenweiThirtyTagHandler extends ChannelInboundHandlerAdapter{

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		// TODO Auto-generated method stub
		String data = (String)msg;
		System.out.println("" + data);
	}

}
