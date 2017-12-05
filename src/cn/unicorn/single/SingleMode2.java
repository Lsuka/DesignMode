package cn.unicorn.single;

/**
 * 单例设计，只实例化一次对象，分为懒汉式和饿汉式
 * 
 * @author UNICORN
 *
 */
public class SingleMode2 {
	public static void main(String[] args) {
		SingleHungry inst = SingleHungry.getInstance();// 外部通过static属性获取对象
		inst.print();
	}
}

class SingleHungry {
	private static final SingleHungry INSTANCE = new SingleHungry();// 构造方法内部调用

	private SingleHungry() {
	}// 构造方法私有化

	public static SingleHungry getInstance() {
		return INSTANCE;
	}

	public void print() {
		System.out.println("单例设计模式--饿汉式");
	}
}