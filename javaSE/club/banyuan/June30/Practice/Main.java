package club.banyuan.June30.Practice;

public class Main {
    public static void main(String[] args) {
        Season[] seasons = Season.values();
        for (Season season : seasons) {
            season.getMonthRange(season);
        }
    }
}
