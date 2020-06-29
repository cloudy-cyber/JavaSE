package club.banyuan.June28.Bird;

public class Main {

    public static void show(Bird bird) {
        bird.setName("燕子");
        System.out.println(bird.getName() + "能够飞 " + bird.fly() + "米");
    }

    public static void main(String[] args) {

        show(new Bird() {
            @Override
            public int fly() {
                return 1000;
            }

            //TODO
        });
    }
}
