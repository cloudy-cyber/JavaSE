package club.banyuan.June22.Practice.Cake;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Cake[] cakes = new Cake[10];
        Random random = new Random(10);
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                cakes[i] = new ReadyMadeCake(i, random.nextDouble() * 20, random.nextInt(20));
            } else {
                cakes[i] = new OrderCake(i, random.nextDouble() * 20, random.nextInt(20));
            }
        }
        double total = 0.0;
        for (Cake cake : cakes) {
            total += cake.calcPrice();
        }
        System.out.println(total);

        //显示ReadyMadeCake蛋糕的总价和数量之和；
        double pt = 0.0;//总价之和
        int qt = 0;//数量之和
        for (Cake cake : cakes) {
            if (cake instanceof ReadyMadeCake) {
                ReadyMadeCake readyMadeCake = (ReadyMadeCake) cake;
                pt += readyMadeCake.calcPrice();
                qt += readyMadeCake.getQuantity();
            }
        }
        System.out.println("总价之和为：" + pt);
        System.out.println("数量之和为：" + qt);

        //显示最高价格出售的蛋糕信息
        double max = cakes[0].calcPrice();
        int jMax = 0;
        for (int j = 1; j < cakes.length; j++) {
            if (cakes[j].calcPrice() > max) {
                max = cakes[j].calcPrice();
                jMax = j;
            }
        }if(jMax%2==0){

            System.out.println("最贵的蛋糕是第"+jMax+"号,"+"单价是："+cakes[jMax].price+"数量是："+((ReadyMadeCake)cakes[jMax]).getQuantity());
        }else{
            System.out.println("最贵的蛋糕是第"+jMax+"号,"+"单价是："+cakes[jMax].price+"重量是："+((OrderCake)cakes[jMax]).getWeightInKG());
        }
    }
}
