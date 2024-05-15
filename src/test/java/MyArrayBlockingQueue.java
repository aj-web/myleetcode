import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : chezj
 * @date : 2024/4/1 14:55
 */
public class MyArrayBlockingQueue<T> {
    
    private final T[] items;
    
    private int count;
    
    private int putIndex;
    
    private int takeIndex;
    
    
    private final ReentrantLock lock = new ReentrantLock();
    
    private final Condition notEmpty = lock.newCondition(); // 用于队列非空的条件等待/通知
    
    private final Condition notFull = lock.newCondition();  // 用于队列未满的条件等待/通知
    
    
    public MyArrayBlockingQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero");
        }
        this.items = (T[]) new Object[capacity];
    }
    
    
    public void put(T e) {
        lock.lock();
        try {
            while (count == items.length) {
                notFull.await();
            }
            items[putIndex] = e;
            if (++putIndex == items.length) {
                putIndex = 0;
            }
            ++count;
            notEmpty.signal();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    
    public T take() {
        lock.lock();
        T t = null;
        try {
            while (count == 0) {
                notEmpty.await();
            }
            t = items[takeIndex];
            items[takeIndex] = null;
            if (++takeIndex == items.length) {
                takeIndex = 0;
            }
            count--;
            notFull.signal();
            
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            lock.unlock();
        }
        
        return t;
        
    }
    
}
