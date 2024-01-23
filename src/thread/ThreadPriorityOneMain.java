package thread;

class ThreadPriorityOneMain extends Thread {

    public static void main(String[] args) {

        var thread1 = new ThreadPriorityOneMain();
        var thread2 = new ThreadPriorityOneMain();
        var thread3 = new ThreadPriorityOneMain();

        System.out.printf("첫번째 쓰레드 우선순위(디폴트값) : %d \n", thread1.getPriority());
        System.out.printf("두번째 쓰레드 우선순위(디폴트값) : %d \n", thread2.getPriority());
        System.out.printf("세번째 쓰레드 우선순위(디폴트값) : %d \n", thread3.getPriority());

        //우선순위 변경
        thread1.setPriority(2);
        thread2.setPriority(5);
        thread3.setPriority(8);

        System.out.printf("첫번째 쓰레드 우선순위(변경 후) : %d \n", thread1.getPriority());
        System.out.printf("두번째 쓰레드 우선순위(변경 후) : %d \n", thread2.getPriority());
        System.out.printf("세번째 쓰레드 우선순위(변경 후) : %d \n", thread3.getPriority());


        // Main thread
        System.out.format("메인 쓰레드: %s , 우선순위(디폴트) %d \n", Thread.currentThread().getName(), Thread.currentThread().getPriority());

        // Main Thread 우선순위 변경
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

        System.out.format("메인 쓰레드: %s , 우선순위(변경 후) %d \n", Thread.currentThread().getName(), Thread.currentThread().getPriority());

    }
}
