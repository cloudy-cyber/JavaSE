package club.banyuan.June11.dog_cat;

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
