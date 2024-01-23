package thread;

class SharedCounter {
    long count;
    void increment() {
        count++;
    }
}
class UnsafeAccess extends Thread {
    private final SharedCounter sharedCounter;
    public UnsafeAccess(SharedCounter sharedCounter){
        this.sharedCounter = sharedCounter;
    }
    public void run() {
        for (var i = 0; i < 100000000; i++) {
            sharedCounter.increment();
        }
    }
}
public class ThreadSyncUnSafeExampleMain {
    public static void main(String... args) {
        var counter =  new SharedCounter();
        var thread1 = new UnsafeAccess(counter);
        var thread2 = new UnsafeAccess(counter);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ignored) { }
        System.out.format("Final Count Value : %d", counter.count);
    }
}

