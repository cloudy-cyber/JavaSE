import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Myrunnable myrunnable = new Myrunnable(2, 3);
        ExecutorService service= Executors.newFixedThreadPool(2);
        Future<Integer>result=service.submit(myrunnable);
        Integer sum=result.get();
        System.out.println(sum);
    }
}
