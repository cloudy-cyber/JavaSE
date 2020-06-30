package club.banyuan.June30.Practice;

public enum Season {
    SPRING,
    SUMMER,
    AUTUMN,
    WINTER,
    ;

    void getMonthRange(Season season) {
        switch (season) {
            case SPRING:
                System.out.println("3~5");
                break;
            case AUTUMN:
                System.out.println("9~11");
                break;
            case SUMMER:
                System.out.println("6~8");
                break;
            case WINTER:
                System.out.println("12~2");
                break;
        }
    }
}
