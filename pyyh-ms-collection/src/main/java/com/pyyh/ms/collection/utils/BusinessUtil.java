package com.pyyh.ms.collection.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pyyh.ms.collection.configer.BusinssConfigure;
import com.pyyh.ms.collection.configer.SocketConfigure;

@Configuration
public class BusinessUtil {

	//按照业务初始化数据
	@Bean
	public Object businessInitForTest(){
		while(true){
			try {
				Thread.sleep(50);
				if((BusinssConfigure.get_allKey() != null && SocketConfigure.is_tcpServer()) || 
				   (BusinssConfigure.get_udpAllKey() != null && SocketConfigure.is_udp())|| 
				   (BusinssConfigure.get_httpAllKey() != null && SocketConfigure.is_http())){
					break;
				}else{
					continue;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//tcp业务
		if(SocketConfigure.is_tcpServer()){
			for(String businessKey : BusinssConfigure.get_allKey()){
				if(BusinssConfigure.get_allKey().equals(businessKey)){
					System.out.println(BusinssConfigure.get_usedKey());
				}
			}
		}
		//udp业务
		if(SocketConfigure.is_udp()){
			for(String businessKey : BusinssConfigure.get_udpAllKey()){
				if(BusinssConfigure.get_UdpUsedKey().equals(businessKey)){
					System.out.println(BusinssConfigure.get_UdpUsedKey());
				}
			}
		}
		//http业务
		if(SocketConfigure.is_http()){
			for(String businessKey : BusinssConfigure.get_httpAllKey()){
				if(BusinssConfigure.get_httpUsedKey().equals(businessKey)){
					System.out.println(BusinssConfigure.get_httpUsedKey());
				}
			}
		}
		
		return null;
	}
}
