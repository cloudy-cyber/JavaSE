package club.banyuan.June20.students;

public class Main {
    public static void main(String[] args) {
        Pupil pupil=new Pupil("我是小学生");
        MStudent mStudent=new MStudent("我是中学生");
        HStudent hStudent=new HStudent("我是高中生");
        pupil.Study();
        mStudent.Study();
        hStudent.Study();
        System.out.println(pupil.getName());
    }
}
