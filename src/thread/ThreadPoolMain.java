package thread;

import java.util.concurrent.Executors;

class PoolThread implements Runnable{
    private String threadName = "";
    private long delayTime = 0;
    private boolean flag;

    public PoolThread(String threadName, long delayTime, boolean flag) {
        this.threadName = threadName;
        this.delayTime = delayTime;
        this.flag = flag;
    }

    @Override
    public void run() {
        while(flag){
            try{
                Thread.sleep(delayTime);
                System.out.printf("실행 중 %s \n",Thread.currentThread().getName());
            }catch(InterruptedException ic){
                flag = false;
            }
        }
    }
}
public class ThreadPoolMain {
    public static void main(String... args){
        var executorService = Executors.newFixedThreadPool(3);
        //var executorService = Executors.newCachedThreadPool();

        for (long delayTime = 1; delayTime <= 10; delayTime++) {
            var thread = new PoolThread(String.format("Pool Thread Name %d", delayTime), delayTime * 1000, true);
            executorService.submit(thread);
        }
        try{
            Thread.sleep(11000);
        }catch (InterruptedException ignored){}
        //executorService.shutdownNow();
    }
}
