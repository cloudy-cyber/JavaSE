package club.banyuan.June23.skill;

import club.banyuan.June23.fighter.Fighter;

import java.util.Random;

public class Light implements Skill{
    @Override
    public void apply(Fighter from, Fighter to) {
        Random random=new Random();
        int a=random.nextInt(10)+30;
        from.setHp(from.getHp()+a);
        System.out.println(from.getName()+"使用了圣光闪现，恢复了"+a+"点生命值，剩余生命值"+from.getHp());
    }
}
