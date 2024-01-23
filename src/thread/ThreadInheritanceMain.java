package thread;

class SimpleThread extends Thread {
    private Long delayTime;
    private String threadName;
    private boolean flag = false;
    public SimpleThread(String threadName, Long delayTime){
        super(threadName);
        this.delayTime = delayTime;
    }
    @Override
    public void run() {
        while(!flag){
            try {
                sleep(delayTime);
                System.out.printf("%s\t", currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class ThreadInheritanceMain {
    public static void main(String... args){
        var thread1 = new SimpleThread("T500", 500L);
        var thread2 = new SimpleThread("T1000", 1000L);
        thread1.start() ;
        thread2.start();
        try{
            Thread.sleep(5000);
        }catch(InterruptedException ignored){}
        System.out.printf("\n End of %s Thread \n", Thread.currentThread().getName());
    }
}
