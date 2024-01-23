package thread;

class ThreadJoin extends Thread {
    private long first;
    private long last;

    public long sum;

    public ThreadJoin(long first, long last) {
        this.first = first;
        this.last = last;
    }
    @Override
    public void run() {
        for (var start = first; start <= last; start++) {
            sum += start;
        }
    }
}
public class ThreadJoinMain {
    public static void main(String... args) throws InterruptedException {
        var thread1 = new ThreadJoin(1, 1000000000);
        var thread2 = new ThreadJoin(1, 1000000000);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        thread1.interrupt();
        thread2.interrupt();
        System.out.printf("Main Thread 종료! \n 총 합 :   %d", (thread1.sum + thread2.sum));

    }
}
