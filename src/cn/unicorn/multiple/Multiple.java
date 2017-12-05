package cn.unicorn.multiple;

/**
 * 多例设计模式
 * @author UNICORN
 *
 */
public class Multiple {
	public static void main(String[] args) {
		Sex sex = Sex.getInstance(0);
		System.out.println(sex);
	}
}

class Sex {
	private static final Sex MALE = new Sex("male");
	private static final Sex FEMALE = new Sex("female");
	private String note;

	public Sex(String note) {
		this.note = note;
	}

	public static Sex getInstance(int ch) {
		switch (ch) {
		case 0:
			return MALE;
		case 1:
			return FEMALE;
		}
		return null;
	}

	@Override
	public String toString() {
		return "Sex:" + this.note;
	}
}