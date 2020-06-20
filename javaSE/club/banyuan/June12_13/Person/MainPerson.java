package club.banyuan.June12_13.Person;

public class MainPerson {

    public static void main(String[] args) {
        Person person = new Person();
        Person zhangsan = new Person("张三", 18);
        Person lisi = new Person("李四");
        Person wangwu = new Person("王五");
        Person zhaoliu = new Person("赵六", 20);
        System.out.printf("一共创建了%d个对象\n", Person.c0 + Person.c1 + Person.c2);
        System.out.println("两个参数的构造方法被调用了" + Person.c2 + "次");
        lisi.speak();
    }
}