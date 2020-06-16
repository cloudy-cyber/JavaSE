// 1.设计一个方法，可以实现获取任意范围内的随机数。包括负数，例如输入randomInt(-10,5)

import java.util.Random;

public class random {
	public static final int start = -10;
	public static final int end = 5;


	public static void main(String[] args) {
		Random random = new Random();
		int number = random.nextInt(end - start + 1) + start;
		System.out.println(number);
	}
}