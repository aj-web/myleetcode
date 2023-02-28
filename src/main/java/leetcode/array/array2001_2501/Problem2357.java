package leetcode.array.array2001_2501;

import org.apache.commons.lang3.time.StopWatch;

import java.util.HashSet;
import java.util.Set;

/**
 * 使数组中所有元素都等于零
 *
 * @author : chezj
 * @date : 2023/2/27 14:15
 */
public class Problem2357 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem2357 p = new Problem2357();
        
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
            }
        }
        return set.size();
    }
}
