package thread.Problem1114;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chezhijun
 * @descririon
 * @date 2022/1/10
 */
public class Problem1114 {
    static class Foo {

        private final Object obj = new Object();
        Lock lock = new ReentrantLock();
        Boolean firstJob = false;
        Boolean secondJob = false;

        public Foo() {
        }

        public void first(Runnable printFirst) throws InterruptedException {

            synchronized (obj) {
                // printFirst.run() outputs "first". Do not change or remove this line.
                for (int i = 0; i < 100; i++) {
                    printFirst.run();
                }
                firstJob = true;
                obj.notifyAll();
            }


        }

        public void second(Runnable printSecond) throws InterruptedException {
            // printSecond.run() outputs "second". Do not change or remove this line.
            synchronized (obj) {
                while (!firstJob) {
                    obj.wait();
                }
                for (int i = 0; i < 100; i++) {
                    printSecond.run();

                }
            }
        }

        public void third(Runnable printThird) throws InterruptedException {

            // printThird.run() outputs "third". Do not change or remove this line.
            for (int i = 0; i < 100; i++) {
                printThird.run();
            }
        }


        public void first() {
            System.out.println("first");
        }

        public void second() {
            System.out.println("second");
        }

        public void third() {
            System.out.println("third");
        }

    }


    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();

        Thread t1 = new Thread(() -> {
            foo.first();
        });
        Thread t2 = new Thread(() -> {
            foo.second();
        });
        Thread t3 = new Thread(() -> {
            foo.third();
        });


        foo.first(t1);
        foo.second(t2);
        foo.third(t3);

    }
}
