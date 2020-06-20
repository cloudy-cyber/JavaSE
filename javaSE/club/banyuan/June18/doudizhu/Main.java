package club.banyuan.June18.doudizhu;

public class Main {

        public static void main(String[] args) {
            Poker poker = new Poker();
            poker.initCards();
            poker.printCards();

            Player player1 = new Player("玩家1", "地主");
            Player player2 = new Player("玩家2", "农民");
            Player player3 = new Player("玩家3", "农民");

            poker.dealCard(player1);
            poker.dealCard(player2);
            poker.dealCard(player3);

            System.out.println(player1);
            System.out.println(player2);
            System.out.println(player3);
        }
}
