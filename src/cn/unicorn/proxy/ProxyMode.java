package cn.unicorn.proxy;

/**
 * 静态代理模式，主要是核心业务只实现核心业务，其他准备工作交给其他处理 比如说DAO中的准备数据库连接的打开关闭这些准备工作
 * 
 * @author UNICORN
 *
 */
public class ProxyMode {
	public static void main(String[] args) {
		IMessage message = new ProxyMessage(new RealMessage());
		message.send("我是核心业务");
	}
}



class ProxyMessage implements IMessage {
	private IMessage obj;

	public ProxyMessage(IMessage obj) {// 保存真实主题
		this.obj = obj;
	}

	public void build() {
		System.out.println("为核心业务做准备工作");
	}

	public void release() {
		System.out.println("为核心业务做收尾工作");
	}

	@Override
	public void send(String msg) {
		this.build();
		this.obj.send(msg);
		this.release();
	}
}