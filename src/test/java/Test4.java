import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : chezj
 * @date : 2024/3/27 14:12
 */
public class Test4 {
    
    static int flag = 0;
    
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition A = lock.newCondition();
        Condition B = lock.newCondition();
        Condition C = lock.newCondition();
        
        Thread a = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                lock.lock();
                try {
                    while (flag == 2) {
                        A.await();
                    }
                    System.out.println("aaa");
                    flag = 2;
                    C.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
                
            }
        });
        
        Thread b = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    lock.lock();
                    while (flag == 2) {
                        B.await();
                    }
                    System.out.println("bbb");
                    flag = 2;
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
                try {
                    lock.lock();
                    while (flag != 2) {
                        C.await();
                    }
                    System.out.println("ccc");
                    flag = 0;
                    A.signal();
                    B.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
                
            }
        });
        
        a.start();
        b.start();
        c.start();
    }
    
    
}
