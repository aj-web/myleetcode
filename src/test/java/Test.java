import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author : chezj
 * @date : 2023/11/27 11:33
 */
public class Test {
    
    static int state = 0;
    
    static ReentrantLock reentrantLock = new ReentrantLock();
    
    

        /*        Thread a = new Thread(() -> System.out.println("a"));
        
        Thread b = new Thread(() -> {
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("b");
            
        });
        
        Thread c = new Thread(() -> {
            try {
                b.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("c");
        });
        
        a.start();
        b.start();
        c.start();*/
    
    Condition a = reentrantLock.newCondition();
    
    Condition b = reentrantLock.newCondition();
    
    Condition c = reentrantLock.newCondition();
    
    Thread A = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                reentrantLock.lock();
                try {
                    if (state % 3 != 0) {
                        a.await();
                    }
                    System.out.println("a");
                    state++;
                    b.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
            
        }
    });
    
    Thread B = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                reentrantLock.lock();
                try {
                    if (state % 3 != 1) {
                        b.await();
                        
                    }
                    System.out.println("b");
                    state++;
                    c.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
            
        }
    });
    
    Thread C = new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                reentrantLock.lock();
                try {
                    if (state % 3 != 2) {
                        c.await();
                    }
                    System.out.println("c");
                    state++;
                    a.signal();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    reentrantLock.unlock();
                }
            }
            
        }
    });
        
        A.start();
        B.start();
        C.start();
    
    
    public int[] LIS(int[] arr) {
        // write code here
        int[] res = new int[0];
        
        List<List<Integer>> list = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(temp);
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arrayList.get(arrayList.size() - 1)) {
                    arrayList.add(arr[j]);
                }
            }
            list.add(arrayList);
        }
        
        int max = 0;
        for (List<Integer> integers : list) {
            if (integers.size() > max) {
                max = integers.size();
            }
        }
        
        for (List<Integer> integers : list) {
            if (integers.size() == max) {
                res = new int[integers.size()];
                for (int i = 0; i < integers.size(); i++) {
                    res[i] = integers.get(i);
                }
                return res;
            }
        }
        
        return res;
    }
}
