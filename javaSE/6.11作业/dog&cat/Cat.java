package banyuan.cat;
import banyuan.dog.Dog;


public class Cat {

	public String kind;
	public String color;
	public void print() {
		System.out.println(color + "的" + kind);
	}
	public void playwith(Dog dog) {
		System.out.println(kind + dog.kind + "一起玩。");
	}
}