package club.banyuan.June23.fighter;

import club.banyuan.June23.skill.Skill;
import club.banyuan.June23.weapon.Weapon;

import java.util.Random;

public class Fighter {
    private String name;
    private int hp = 1000;
    private Weapon weapon;
    private Skill[] skill;
    private int vertigo = 0;
    private final Random rand = new Random();

    public int getVertigo() {
        return vertigo;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Fighter(String name, Weapon weapon, Skill[] skill) {
        this.name = name;
        this.weapon = weapon;
        this.skill = skill;
    }

    // 方法参数为一个人物对象，表示向该人物发起攻击。攻击时从技能数组中随机选择一项技能进行方法调用，调用需要满足技能接口的方法声明
    public void attack(Fighter fighter) {
        int index = rand.nextInt(skill.length);
        Skill skills = skill[index];
        skills.apply(this, fighter);
    }

    // 方法接收一个数值作为受到伤害的数值，将会扣除血量值
    public void hurt(int hurt){
        hp-=hurt;
        System.out.println(getName()+"受到了"+hurt+"点伤害，剩余生命值"+hp);
    }
    //受到眩晕伤害，增加眩晕值，眩晕值如果不为零则会跳过一个回合攻击
    public void vertigo(int rounds){
        vertigo+=rounds;
    }
    //从眩晕中恢复，眩晕值如果不为零则减一
    public void recover(){
        if(vertigo!=0){
            vertigo--;
        }
    }
    public boolean isAlive(){
        return hp>0;
    }


}
