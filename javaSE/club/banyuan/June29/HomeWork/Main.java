package club.banyuan.June29.HomeWork;

public class Main {
    public static void main(String[] args) {
        WeekDay sat=WeekDay.SATURDAY;
        WeekDay[] days= WeekDay.values();
        for (WeekDay day : days) {
            System.out.println(day.compareTo(sat));
        }
    }
}
