package cn.unicorn.thread;

public class ProducerAndConsumer {
	public static void main(String[] args) {
		Message msg = new Message();
		new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				if (i % 2 == 0) {
					msg.set("消息一", "我是消息一的内容");
				} else {
					msg.set("消息二", "我是消息二的内容");
				}
			}
		}, "MessageProducer").start();
		new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				msg.get();
			}
		}, "MessageConsumer").start();
	}
}

class Message {
	private String title;
	private String note;
	private boolean flag = true;// true表示可以生产，false表示可以取走

	public synchronized void set(String title, String note) {
		if (this.flag == false) {// 不能生产
			try {
				super.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.title = title;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.note = note;
		this.flag = false;// 生产过要变为false
		super.notify();
	}

	public synchronized void get() {
		if (this.flag == true) {// 不能取走
			try {
				super.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("[" + Thread.currentThread().getName() + "]title = " + this.title + ",note = " + this.note);
		this.flag = true;// 取走后要变为true
		super.notify();
	}
}