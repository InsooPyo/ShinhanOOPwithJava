package thread;
class SemaphoreSharedData {
    private boolean isNew = false; //세마포어 변수
    private int data = 0;
    synchronized void produce(int inputData) { //생산
        try {
            while (isNew) // 새로 생산된 데이터인가?
                wait(); // unlocked
        } catch (InterruptedException ignored) {
        }
        data = inputData;
        isNew = true; //새로 생산된 데이터임을 나타내는 세마포어변수
        notifyAll();
    }

    synchronized int consume() { //소비
        try {
            while (!isNew) // 소비할 준비가 되었는가?
                wait(); // unlocked
        } catch (InterruptedException ignored) {
        }
        isNew = false;
        notifyAll(); //현재 메소드가 종료되기 전엔 깨우지 않는다
        return data;
    }
}
class ProducerThread extends Thread {
    private SemaphoreSharedData shared;
    private int initData;
    public ProducerThread(String threadName, SemaphoreSharedData shared, int initData) {
        super(threadName);
        this.shared = shared;
        this.initData = initData;
    }
    @Override
    public void run() {
        while (true) {
            shared.produce(initData);
            System.out.printf("%s:%d \n", currentThread().getName(), initData);
            initData++;
        }
    }
}
class ConsumerThread extends Thread {
    private final SemaphoreSharedData shared;
    public ConsumerThread(String threadName, SemaphoreSharedData shared) {
        super(threadName);
        this.shared = shared;
    }
    @Override
    public void run() {
        while(true) System.out.printf("%s:%d \n", currentThread().getName(), shared.consume());
    }
}
public class ThreadSemaphoreMain {
    public static void main(String... args) {
        var shared = new SemaphoreSharedData();
        new ConsumerThread("Consumer-T0", shared).start();
        var consumer = new ConsumerThread("Consumer-T1", shared);
        consumer.setPriority(Thread.MAX_PRIORITY);
        consumer.start();
        new ProducerThread("Producer-T0",shared, 10).start();
        var producer = new ProducerThread("Producer-T1",shared, 20);
        producer.setPriority(Thread.MAX_PRIORITY);
        producer.start();
    }
}
