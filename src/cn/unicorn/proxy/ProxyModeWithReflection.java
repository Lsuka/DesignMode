package cn.unicorn.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理设计设计模式
 * 
 * @author UNICORN
 *
 */
public class ProxyModeWithReflection {
	public static void main(String[] args) {
		IMessage message = (IMessage) new MessageProxy().bind(new RealMessage());
		message.send("我是核心业务");
	}
}

class MessageProxy implements InvocationHandler {// 动态代理类
	private Object realObject;

	public Object bind(Object realObject) {
		this.realObject = realObject;
		return Proxy.newProxyInstance(realObject.getClass().getClassLoader(), realObject.getClass().getInterfaces(),
				this);
	}

	public void build() {
		System.out.println("为核心业务做准备工作");
	}

	public void release() {
		System.out.println("为核心业务做收尾工作");
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		this.build();
		Object backResult = method.invoke(this.realObject, args);// 执行真实主题对象
		this.release();
		return backResult;
	}
}
