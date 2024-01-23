package thread;

class Counter {
    long count;
     void increment() {
         synchronized (this){
             count++;
         }
    }
}
class SafeAccess extends Thread {
    private  Counter counter;
    public SafeAccess(Counter counter){
        this.counter = counter;
    }
    public void run() {
        for (var i = 0; i < 100000000; i++) {
            counter.increment();
        }
    }
}
public class ThreadSyncSafeExampleMain {
    public static void main(String... args) {
        var counter =  new Counter();
        var thread1 = new SafeAccess(counter);
        var thread2 = new SafeAccess(counter);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException ignored) { }
        System.out.format("Final Count Value : %d", counter.count);
    }
}

