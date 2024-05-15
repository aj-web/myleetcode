import java.util.concurrent.CyclicBarrier;

/**
 * @author : chezj
 * @date : 2024/4/15 10:12
 */
public class SemTest {
    
    private static final int NUMBER_OF_THREADS = 3; // 三个同步线程
    
    private static final int REPEAT_COUNT = 10; // 每个线程打印10次
    
    private static CyclicBarrier barrier = new CyclicBarrier(NUMBER_OF_THREADS);
    
    public static void main(String[] args) {
        // 创建并启动三个线程
        Thread threadA = new Thread(new Worker('a'), "Thread-A");
        Thread threadB = new Thread(new Worker('b'), "Thread-B");
        Thread threadC = new Thread(new Worker('c'), "Thread-C");
        
        threadA.start();
        threadB.start();
        threadC.start();
    }
    
    static class Worker implements Runnable {
        
        private char characterToPrint;
        
        public Worker(char character) {
            this.characterToPrint = character;
        }
        
        @Override
        public void run() {
            for (int i = 0; i < REPEAT_COUNT; i++) {
                try {
                    // 在打印之前先到达屏障
                    barrier.await();
                    // 打印字符
                    System.out.print(characterToPrint + " ");
                    // 等待其他线程
                    barrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
}
