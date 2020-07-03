package club.banyuan.July2.Practice;


import java.util.*;

public class Class {
    private Set<Student> set = new HashSet<>();

    public void add(Student student){
        set.add(student);
    }

    public void print(){
        for (Student student : set) {
            System.out.println(student);
        }
    }

    public List printId(){
        Set<Student> printId=new TreeSet<>(Comparator.comparingInt(Student::getId));
        printId.addAll(set);
        List<Student> printIdList=new ArrayList<>(printId);
        return printIdList;
    }

    public List printAge(){
        Set<Student> printAge=new TreeSet<>((o1, o2) -> o2.getAge()-o1.getAge());
        printAge.addAll(set);
        List<Student> printAgeList=new ArrayList<>(printAge);
        return printAgeList;
    }


    public static void main(String[] args) {
      Class students =new Class();
        students.add(new Student(1, "胃炎", 25));
        students.add(new Student(2, "魏延", 30));
        students.add(new Student(3, "威严", 10));
        students.add(new Student(4, "十环呈", 2));

        students.print();
        System.out.println("=================");
        System.out.println(students.printId());
        System.out.println(students.printAge());


    }
}



