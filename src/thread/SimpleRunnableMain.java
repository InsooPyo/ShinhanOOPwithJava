package thread;

class SimpleRunnable implements Runnable{
    private Long delayTime;
    private boolean flag = false;

    public SimpleRunnable(Long delayTime) {
        this.delayTime = delayTime;
    }
    @Override
    public void run() {
        while(!Thread.interrupted()){
            try{
                Thread.sleep(delayTime);
                System.out.printf("%s\t", Thread.currentThread().getName());
            }catch(InterruptedException ic){
                Thread.currentThread().interrupt();
                System.out.printf("\n End of %s Thread \n", Thread.currentThread().getName());
                throw new RuntimeException("쓰레드 인터럽트 발생한 부분을 런타임예외로 포워딩!");
            }
        }
    }
}
public class SimpleRunnableMain {
    public static void main(String... args){
        var thread1 = new Thread(new SimpleRunnable(500L), "t500");
        var thread2 = new Thread(new SimpleRunnable(1000L), "t1000");
        thread1.start() ; thread2.start();
        try{
            Thread.sleep(5000);
        }catch(InterruptedException ignored){}
        System.out.printf("\n End of %s Thread \n", Thread.currentThread().getName());
    }
}
