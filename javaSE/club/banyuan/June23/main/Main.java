package club.banyuan.June23.main;

import club.banyuan.June23.fighter.Fighter;
import club.banyuan.June23.skill.DoubleAttack;
import club.banyuan.June23.skill.Light;
import club.banyuan.June23.skill.Skill;
import club.banyuan.June23.skill.VertigoSkill;
import club.banyuan.June23.weapon.KillDragon;
import club.banyuan.June23.weapon.SkyBlade;

public class Main {
    public static void main(String[] args) {
        Skill[] skills=new Skill[]{new DoubleAttack(),new VertigoSkill(),new Light()};
        Fighter fighter1=new Fighter("古尔丹",new SkyBlade(), skills);
        Fighter fighter2=new Fighter("萨尔",new KillDragon(),skills);
        while (fighter1.isAlive()&&fighter2.isAlive()){
            attack(fighter1,fighter2);
            if(fighter2.isAlive()){
                attack(fighter2,fighter1);
            }
            System.out.println("-------------");
        }
        if(fighter1.isAlive()){
            print(fighter1,fighter2);
        }else{
            print(fighter2,fighter1);
        }
    }
    public static void attack(Fighter fighter1,Fighter fighter2){
        if(fighter1.getVertigo()==0){
            fighter1.attack(fighter2);
        }else{
            fighter1.recover();
        }
    }

    public static void print(Fighter fighter1,Fighter fighter2){
        System.out.println(fighter1.getName()+"打败了"+fighter2.getName());
    }
}
