package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class CallableImpl implements Callable<Long> {
    @Override
    public Long call() throws Exception {
        var sum = 0L;
        for(long value = 0 ; value <= 10000000; value++){
            sum += value;
        }
        System.out.printf("End of %s \n", Thread.currentThread().getName());

        return sum;
    }
}
public class CallableThreadMain {
    public static void main(String... args) throws ExecutionException, InterruptedException {
        FutureTask<Long> futureTask = new FutureTask<>(new CallableImpl());
        var thread = new Thread(futureTask, "Future Thread");
        thread.start();
        System.out.format("sum = %d \n", futureTask.get());
        System.out.printf("End of %s Thread \n", Thread.currentThread().getName());
    }
}
