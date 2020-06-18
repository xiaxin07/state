package com.xiaxin.ch05.rmi.server;

/**
 * @author high concurrency
 */
public interface ServerCenter {
	/**
	 * 启动服务
	 */
	void start() ;

	/**
	 * 关闭服务
	 */
	void stop();

	/**
	 * 注册服务
	 * @param service
	 * @param serviceImpl
	 */
	void register(Class service, Class serviceImpl);
}
