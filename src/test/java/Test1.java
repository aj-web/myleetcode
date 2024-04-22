import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Test1 {

/*        public static void main(String[] args) {
        Thread a = new Thread(() -> System.out.println("我是线程a"));


        Thread b = new Thread(() -> {
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我是线程b");
        });


        Thread c = new Thread(() -> {
            try {
                b.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我是线程c");
        });


        a.start();
        b.start();
        c.start();
    }*/

    private static int state = 0;
    private static ReentrantLock lock = new ReentrantLock();
    private static final Condition A = lock.newCondition();
    private static final Condition B = lock.newCondition();
    private static final Condition C = lock.newCondition();

    public static void main(String[] args) {


        Thread a = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                lock.lock();
                try {
                    while (state % 3 != 0) {
                        A.await();
                    }
                    System.out.println("第" + i + "次输" + "a");
                    state++;
                    B.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        });

        Thread b = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                lock.lock();
                try {
                    while (state % 3 != 1) {
                        B.await();
                    }
                    System.out.println("第" + i + "次输出" + "b");
                    state++;
                    C.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        });

        Thread c = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                lock.lock();
                try {
                    while (state % 3 != 2) {
                        C.await();
                    }
                    System.out.println("第" + i + "次输出" + "c");
                    state++;
                    A.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        });

        // 启动三个线程
        a.start();
        b.start();
        c.start();


    }


}
