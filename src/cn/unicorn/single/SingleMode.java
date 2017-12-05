package cn.unicorn.single;

/**
 * 单例设计，只实例化一次对象，分为懒汉式和饿汉式
 * 
 * @author UNICORN
 *
 */
public class SingleMode {
	public static void main(String[] args) {
		SingleLazy inst = SingleLazy.getInstance();// 外部通过static属性获取对象
		inst.print();
	}
}

class SingleLazy {
	private static SingleLazy instance;// 构造方法内部调用

	private SingleLazy() {
	}// 构造方法私有化

	public static SingleLazy getInstance() {
		if (instance == null) {// 第一次使用时候没有对象
			instance = new SingleLazy();
		}
		return instance;
	}

	public void print() {
		System.out.println("单例设计模式--懒汉式");
	}
}