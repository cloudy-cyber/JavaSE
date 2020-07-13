import java.util.concurrent.Callable;

public class Myrunnable implements Callable<Integer> {

    private int x;
    private int y;

    public Myrunnable(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Integer call() throws Exception {
        return x + y;
    }
}

