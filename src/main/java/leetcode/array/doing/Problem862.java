package leetcode.array.doing;

import org.apache.commons.lang3.time.StopWatch;

/**
 * @author : chezj
 * @date : 2022/10/26 17:13
 */
public class Problem862 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem862 p = new Problem862();
        p.shortestSubarray(new int[] {1, 2, 3, 4, 5}, 2);
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    
    public int shortestSubarray(int[] nums, int k) {
        int len = nums.length;
        int[][] dp = new int[len +1][len +1];
    
        for (int i = 0; i < len; i++) {
        
        }
    }
    
}
