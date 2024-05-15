import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : chezj
 * @date : 2024/4/13 11:36
 */
public class Test_tow_thread {


    static int state = 0;
    static ReentrantLock reentrantLock = new ReentrantLock();

    static final Condition A = reentrantLock.newCondition();
    static final Condition B = reentrantLock.newCondition();

    public static void main(String[] args) {


        Thread a = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                reentrantLock.lock();
                try {
                    while (state % 2 != 0) {
                        A.await();
                    }
                    System.out.println("第" + i + "输出：" + "a");
                    state++;
                    B.signal();
                } catch (Exception e) {
                    reentrantLock.unlock();
                } finally {
                    reentrantLock.unlock();
                }
            }


        });


/*        Thread a = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                reentrantLock.lock();
                try {
                    while (state % 2 != 0) {
                        A.await();
                    }
                    System.out.println("第" + i + "次输" + "a");
                    state++;
                    B.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }

            }
        });*/


/*        Thread b = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                reentrantLock.lock();
                try {
                    while (state % 2 != 1) {
                        B.await();
                    }
                    System.out.println("第" + i + "次输出" + "b");
                    state++;
                    A.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }

            }
        });*/


        Thread b = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                reentrantLock.lock();
                try {
                    while (state % 2 != 1) {
                        B.await();
                    }
                    System.out.println("第" + i + "次输出" + "b");
                    state++;
                    A.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }

            }
        });


        a.start();
        b.start();
    }
}
