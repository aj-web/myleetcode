package leetcode.array.doing;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayDeque;
import java.util.Deque;

/**最多能完成排序的块
 * @author : chezj
 * @date : 2022/10/13 10:08
 */
public class Problem769 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem769 p = new Problem769();
        
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    
    /**
     * 要点：单调栈中存储块，对下一个值判断是否是同一个块，不是放入下一个块
     * @param arr
     * @return
     */
    public int maxChunksToSorted(int[] arr) {
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i : arr) {
            int min = i;
            int max = i;
            while (!deque.isEmpty() && (deque.peekLast()[1] > i || deque.peekLast()[0] > i)) {
                int[] pollLast = deque.pollLast();
                max = Math.max(max, pollLast[1]);
                min = Math.min(min, pollLast[0]);
            }
            deque.add(new int[] {min, max});
        }
        return deque.size();
    }
}
