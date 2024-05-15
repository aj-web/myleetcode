/**
 * @author : chezj
 * @date : 2024/4/1 15:48
 */
public class BlockingQueueTest {
    
    public static void main(String[] args) {
        
        MyArrayBlockingQueue<Integer> blockingQueue = new MyArrayBlockingQueue<>(5);
        
        for (int i = 0; i < 10; i++) {
            if (i == 9) {
                System.out.println("will end ");
            }
            new Thread(() -> blockingQueue.put(1)).start();
            new Thread(() -> blockingQueue.put(1)).start();
        }
        
        
    }
    
}
