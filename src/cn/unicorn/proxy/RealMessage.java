package cn.unicorn.proxy;

class RealMessage implements IMessage {
	public void send(String msg) {
		System.err.println("消息發送" + msg);
	}
}