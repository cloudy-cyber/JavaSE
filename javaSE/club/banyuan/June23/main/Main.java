package club.banyuan.June23.main;

import club.banyuan.June23.fighter.Fighter;
import club.banyuan.June23.skill.DoubleSkills;
import club.banyuan.June23.skill.Skills;
import club.banyuan.June23.skill.VertigoSkills;
import club.banyuan.June23.weapon.Weapon;
import club.banyuan.June23.weapon.WeaponKillDragon;
import club.banyuan.June23.weapon.WeaponSkyBlade;

public class Main {
    public static void main(String[] args) {
        Skills[] skills=new Skills[2];
        skills[0]=new DoubleSkills();
        skills[1]=new VertigoSkills();

        Fighter fighter1=new Fighter("张无忌", new WeaponKillDragon(),skills);
        Fighter fighter2=new Fighter("灭绝师太",new WeaponSkyBlade(),skills);

        while (fighter1.getHp() > 0 && fighter2.getHp() > 0) {
            if (fighter1.getVertigo() == 0) {
                fighter1.attack(fighter2);
                if(fighter2.getHp()<=0){
                    break;
                }
            } else {
                fighter1.recover();
            }
            if (fighter2.getVertigo() == 0) {
                fighter2.attack(fighter1);
            } else {
                fighter2.recover();
            }
        }
        if (fighter1.getHp()<=0) {
            System.out.println(fighter1.getName()+"被"+fighter2.getName()+"打败了");
        }else {
            System.out.println(fighter2.getName()+"被"+fighter1.getName()+"打败了");
        }
    }
}
