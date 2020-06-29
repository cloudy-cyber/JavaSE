package club.banyuan.June23.skill;

import club.banyuan.June23.fighter.Fighter;

public class VertigoSkill implements Skill{
    @Override
    public void apply(Fighter from, Fighter to) {
        int hurtHp=from.getWeapon().attack()/2;
        System.out.println(from.getName()+"向"+to.getName()+"使用了闪电链");
        to.hurt(hurtHp);
        to.vertigo(1);
    }
}
