package club.banyuan.June18.doudizhu;

public class Card {
    //牌的花色 点数 和大小王
    private final String pattern;
    private final String face;
    private final boolean isJoker;

    public Card(String pattern, String face) {
        this.pattern = pattern;
        this.face = face;
        this.isJoker = false;
    }

    public Card(String face) {
        this.face = face;
        this.isJoker = true;
        this.pattern = null;
    }

    public String toString() {
        if (isJoker) {
            return face;
        }
        return pattern + face;
    }

}
