package club.banyuan.June11.dog_cat;

class main {

    public static void main(String[] args) {


        Dog dog1 = new Dog();
        dog1.kind = "哈士奇";
        dog1.iq = -100;
        dog1.print();

        Dog dog2 = new Dog();
        dog2.kind = "柯基";
        dog2.iq = 40;
        dog2.print();

        Dog dog3 = new Dog();
        dog3.kind = "金毛";
        dog3.iq = 100;
        dog3.print();

        Cat cat1 = new Cat();
        cat1.kind = "英短";
        cat1.color = "白色";
        cat1.print();

        Cat cat2 = new Cat();
        cat2.kind = "波斯";
        cat2.color = "绿色";
        cat2.print();

        cat1.playwith(dog2);
        dog1.playwith(cat1);
    }
}
