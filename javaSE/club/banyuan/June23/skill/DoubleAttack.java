package club.banyuan.June23.skill;
import club.banyuan.June23.fighter.Fighter;

public class DoubleAttack implements Skill{
    @Override
    public void apply(Fighter from, Fighter to) {
        int hurtHp=from.getWeapon().attack()*2;
        System.out.println(from.getName()+"向"+to.getName()+"使用了暗影箭");
        to.hurt(hurtHp);
    }
}
