package club.banyuan.June28.Bird;

public abstract class Bird {
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int fly();
}
