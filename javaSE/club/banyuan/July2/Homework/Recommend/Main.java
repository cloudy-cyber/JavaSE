package club.banyuan.July2.Homework.Recommend;

public class Main {
    public static void main(String[] args) {
        PersonalRecommender personalRecommender = new PersonalRecommender();
        personalRecommender.addLikes("张三","可乐");
        personalRecommender.addLikes("张三","复仇者联盟");
        personalRecommender.addLikes("张三","see you again");
        personalRecommender.addLikes("李四","可乐");
        personalRecommender.addLikes("李四","速度与激情");
        personalRecommender.addLikes("李四","yesterday once more");

        System.out.println(personalRecommender.likesBoth("张三","可乐","复仇者联盟"));
        System.out.println(personalRecommender.recommendByPerson("李四"));
        System.out.println(personalRecommender.recommendByProject("可乐"));
    }
}
