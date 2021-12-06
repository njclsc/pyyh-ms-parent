package com.pyyh.ms.collection.bussiness.renwei.decoder;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageDecoder;

public class RenweiThirtyTagDecoder extends MessageToMessageDecoder<Object>{
	@Override
	protected void decode(ChannelHandlerContext arg0, Object arg1, List<Object> arg2) throws Exception {
		// TODO Auto-generated method stub
		DatagramPacket dp = (DatagramPacket)arg1;
		ByteBuf buf = dp.content();
		int len = buf.readableBytes();
		if(len >= 11){
			byte[] bit = new byte[len];
			buf.readBytes(bit);
			if(verfiy(bit)){
				String data = byte2HexString(bit);
				arg2.add(data);
			}
		}
	}
	private String byte2HexString(byte[] bits){
		StringBuffer sb = new StringBuffer();
		for(byte bit : bits){
			sb.append(Integer.toHexString((bit & 0xF0) >> 4));
			sb.append(Integer.toHexString(bit & 0xF));
		}
		return sb.toString().toUpperCase();
	}
	private boolean verfiy(byte[] bits){
		int len = bits.length;
		int reciveVerify = ((bits[len - 1]) & 0xFF);
		int sumVerify = 0;
		for(int i = 0; i < len - 1; i++){
			sumVerify += (bits[i] & 0xFF);
		}
		sumVerify &= 0xFF;
		if(reciveVerify == sumVerify){
			return true;
		}else{
			return false;
		}
	}

	
}
