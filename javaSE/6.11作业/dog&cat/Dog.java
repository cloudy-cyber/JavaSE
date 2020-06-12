package banyuan.dog;
import banyuan.cat.Cat;


public class Dog {
	public String kind;
	public int iq;

	public void print() {
		if (iq < 20) {
			System.out.println(kind + "傻");
		} else if (iq > 80) {
			System.out.println(kind + "聪明");
		} else {
			System.out.println(kind + "智商还可以");
		}
	}
	public void playwith(Cat cat) {
		System.out.println(kind + cat.kind + "一起玩。");
	}

}