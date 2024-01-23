package thread;

class SubThread extends Thread{
    public SubThread(String name) {
        super(name);
    }
    @Override
    public void run() {
        System.out.printf("Current Thread Name : %s -> Start", currentThread().getName());
        var sum = 0;
        try {
            for (var i = 0; i < 100; i++) {
                sum += i;
                sleep(100L);
            }
        } catch (InterruptedException ie) {
            System.out.printf("인터럽트 예외 발생 :  %s \n",ie);
        } finally {
            System.out.printf("총합 : %d \n", sum);
            System.out.printf("Current Thread Name : %s -> End\n", currentThread().getName());
        }
    }
}
public class ThreadInterruptedMain {
    public static void main(String... args){
        System.out.println();
        var subThread = new SubThread("SubThread");
        subThread.start();
        try {
            Thread.sleep(3000L);
            subThread.interrupt();
        } catch (InterruptedException ignored) {}
    }
}
