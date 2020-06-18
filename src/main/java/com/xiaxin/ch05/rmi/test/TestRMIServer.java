package com.xiaxin.ch05.rmi.test;

import com.xiaxin.ch05.rmi.server.RMIService;
import com.xiaxin.ch05.rmi.server.RMIServiceImpl;
import com.xiaxin.ch05.rmi.server.ServerCenter;
import com.xiaxin.ch05.rmi.server.ServerCenterImpl;

/**
 * @author high concurrency
 */
public class TestRMIServer {

	public static void main(String[] args) {
		//用线程的形式启动服务
		new Thread(() -> {
			//服务中心
			ServerCenter server = new ServerCenterImpl(9999);
			//将RMIService接口及实现类，注册到服务中心
			server.register(RMIService.class, RMIServiceImpl.class);
			server.start();
		}).start();
	}
}
