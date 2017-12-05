package cn.unicorn.factory;

/**
 * 动态工厂设计模式
 * 
 * @author UNICORN
 *
 */
public class FactoryModeWithReflection {
	public static void main(String[] args) {
		IFruit fruit = FactoryDynamic.getInstance("cn.unicorn.factory.Orange");
		fruit.eat();
	}
}

class FactoryDynamic {
	private FactoryDynamic() {
	}

	public static IFruit getInstance(String className) {
		try {
			Class<?> cls = Class.forName(className);// 获取指定类的Class对象
			Object obj = cls.newInstance();// 反射实例化对象
			return (IFruit) obj;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}

class Orange implements IFruit {
	@Override
	public void eat() {
		System.out.println("吔橙");
	}
}