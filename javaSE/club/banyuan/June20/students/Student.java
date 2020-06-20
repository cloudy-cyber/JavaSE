package club.banyuan.June20.students;

public class Student {
private String name;

    final String getName() {
        return name;
    }

    final void setName(String name) {
        this.name = name;
    }
    public Student(String name){
        this.name=name;
    }
    public void Study(){
        System.out.println("好好学习天天向上");
    }
}
