import java.util.*;

public class StringBuffer {
	public String string1 = "";
	public char char1;
	//1.接收字符串
	void addend(String str) {
		string1 = str;
	}
	//2.接收字符
	void addend(char str) {
		char1 = str;
	}
	//3.将之前接收到的字符拼接到一起返回
	String ToString() {
		String string2;
		string2 = string1 + (char1 + "");
		return string2;
	}
	//4.清除之前输入的内容
	void clear() {
		string1 = null;
	}
	//5.将之前输入的内容反转
	String reverse() {
		char[] arr = string1.toCharArray();
		char temp = ' ';
		for (int i = 0; i < arr.length / 2; i++) {
			temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}
		String string3 = "";
		for (int i = 0; i < arr.length; i++) {
			string3 += (arr[i] + "");
		}
		return string3;
	}
	//6.指定位置反转
	String reverse(int x, int y) {
		char[] arr = string1.toCharArray();
		String string4 = "";
		for (int i = 0; i < x; i++) {
			string4 += (arr[i] + "");
		}
		for (int j = y - 1; j >= x; j--) {
			string4 += (arr[j] + "");
		}
		for (int k = y; k < arr.length; k++) {
			string4 += (arr[k] + "");
		}
		return string4;


	}

}
