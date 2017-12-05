package cn.unicorn.factory;
/**
 * 静态
 * 工厂设计模式,就是对客户端隐藏实现细节，只将接口暴露给客户端(Mybatis其实就运用了该设计模式)
 * @author UNICORN
 *
 */
public class FactoryMode {
	public static void main(String[] args) {
		IFruit fruit = Factory.getInstanse("apple");
		fruit.eat();
	}
}


class Apple implements IFruit {
	@Override
	public void eat() {
		System.out.println("吔苹果");
	}
}

class Factory {
	private Factory() {
	}

	public static IFruit getInstanse(String className) {
		if ("apple".equals(className)) {
			return new Apple();
		}
		return null;
	}
}