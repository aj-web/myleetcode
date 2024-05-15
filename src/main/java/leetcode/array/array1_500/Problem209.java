package leetcode.array.array1_500;

import org.apache.commons.lang3.time.StopWatch;

/**
 * @author : chezj
 * @date : 2024/4/2 16:05
 */
public class Problem209 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem209 p = new Problem209();
        
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    
    public int minSubArrayLen(int target, int[] nums) {
        int count = 0;
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        
        while (right < nums.length) {
            count += nums[right];
            
            while (count >= target) {
                minLength = Math.min(minLength, right - left + 1);
                count -= nums[left];
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
