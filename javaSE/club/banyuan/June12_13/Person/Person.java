package club.banyuan.June12_13.Person;

public class Person {

    private String name;
    private int age;
    static int c2 = 0;
    static int c1 = 0;
    static int c0 = 0;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        c2++;
    }

    public Person(String name) {
        this.name = name;
        c1++;

    }

    public Person() {
        c0++;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //定义speak方法 显示姓名和年龄
    public void speak() {
        System.out.println("姓名：" + name + " " + "年龄：" + age);
    }

}
