package club.banyuan.June15;// 1.设计一个方法，可以实现获取任意范围内的随机数。包括负数，例如输入randomInt(-10,5)

import java.util.Random;
import java.util.Scanner;

public class random {
	public static final int start = -10;
	public static final int end = 5;


	public static void main(String[] args) {
		Random random = new Random();
		int number = random.nextInt(end - start + 1) + start;
		System.out.println(number);
	}

	static class reverseWord {
		public static void main(String[] args) {
			String a = "To Be Or Not To Be";
			String[] rlt = new String[20];
			System.out.println(revWord(a));
			// System.arraycopy(rlt, 0, revWord(a), 0, revWord(a).length);

			// for (String i : rlt) {
			// 	System.out.println(i);
			// }

		}

		public static String revWord(String target) {
			Scanner sc = new Scanner(target);
			String rlt = "";
			int index = 0;
			String[] temp = new String[20];

			do {
				temp[index] = sc.next();
				index++;
			} while (sc.hasNext());

			for (int i = 0; i < index; i++) {
				rlt += (reverse(temp[i]) + " ");
			}


			return rlt;
		}

		public static String reverse(String targetStr) {
			char[] char1 = targetStr.toCharArray();
			String str = "";
			for (int i = char1.length - 1; i >= 0; i--) {
				str = str + (char1[i] + "");
			}

			return str;
		}
	}
}