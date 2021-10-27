package com.pyyh.ms.collection.configer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pyyh.ms.collection.pojos.SocketCommunicationPojo;

@Configuration
public class SocketConfigure {
	//---------------tcpserver---------------
		@Value("${communication.tcp.server.used}")
		private boolean tcpServer;
		@Value("${communication.tcp.server.tcpServerBacklog}")
		private int tcpServerBacklog;
		@Value("${communication.tcp.server.tcpBufMin}")
		private int tcpBufMin;
		@Value("${communication.tcp.server.tcpBufInit}")
		private int tcpBufInit;
		@Value("${communication.tcp.server.tcpBufMax}")
		private int tcpBufMax;
		@Value("#{'${communication.tcp.server.serverAddress}'.split(',')}")
		private String[] serverAddress;
		//tcp指令接受端口
		private static String tcpReciveCmdAddr;
		//---------------udp---------------
		@Value("${communication.udp.used}")
		private boolean udp;
		@Value("${communication.udp.udpBufMin}")
		private int udpBufMin;
		@Value("${communication.udp.udpBufInit}")
		private int udpBufInit;
		@Value("${communication.udp.udpBufMax}")
		private int udpBufMax;
		@Value("#{'${communication.udp.udpAddress}'.split(',')}")
		private String[] udpAddress;
		//---------------http---------------
		@Value("${communication.http.used}")
		private boolean http;
		@Value("${communication.http.httpBufMin}")
		private int httpBufMin;
		@Value("${communication.http.httpBufInit}")
		private int httpBufInit;
		@Value("${communication.http.httpBufMax}")
		private int httpBufMax;
		@Value("#{'${communication.http.httpAddress}'.split(',')}")
		private String[] httpAddress;
		//----------------------------------
		
		@Bean(name = "tcpServer")
		public SocketCommunicationPojo initLocalTcpServer(){
			SocketCommunicationPojo cp = null;
			if(tcpServer){
				
			}
			return cp;
		}
		@Bean(name = "udp")
		public SocketCommunicationPojo initLocalUdpServer(){
			SocketCommunicationPojo cp = null;
			if(udp){
				
			}
			return cp;
		}
		@Bean(name = "http")
		public SocketCommunicationPojo initLocalHttpServer(){
			SocketCommunicationPojo cp = null;
			if(http){
				
			}
			return cp;
		}
}
