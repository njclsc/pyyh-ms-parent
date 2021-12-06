package com.pyyh.ms.collection.bussiness.renwei.initializer;

import com.pyyh.ms.collection.bussiness.renwei.decoder.RenweiThirtyTagDecoder;
import com.pyyh.ms.collection.bussiness.renwei.handler.RenweiThirtyTagHandler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.DatagramChannel;

public class RenweiUDPChannelInitializer extends ChannelInitializer<DatagramChannel>{

	@Override
	protected void initChannel(DatagramChannel arg0) throws Exception {
		// TODO Auto-generated method stub
		arg0.pipeline().addLast(new RenweiThirtyTagDecoder());
		arg0.pipeline().addLast(new RenweiThirtyTagHandler());
		
	}

}
