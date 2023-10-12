package leetcode.array.array2501_3000;

import org.apache.commons.lang3.time.StopWatch;

/**
 * 找出数组的串联值
 *
 * @author : chezj
 * @date : 2023/10/12 16:42
 */
public class Problem2562 {
    
    public static void main(String[] args) {
        
        Problem2562 p = new Problem2562();
        p.findTheArrayConcVal(new int[] {5, 14, 13, 8, 12});
        
    }
    
    public long findTheArrayConcVal(int[] nums) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        int size = nums.length;
        int round = size / 2;
        Long res = 0L;
        for (int i = 1; i <= round; i++) {
            int left = i - 1;
            int right = size - i;
            String temp = nums[left] + "" + nums[right];
            res += Long.parseLong(temp);
        }
        if ((size % 2 == 0)) {
            stopWatch.stop();
            System.out.println(stopWatch.getTime() + "毫秒");
            return res;
        } else {
            stopWatch.stop();
            System.out.println(stopWatch.getTime() + "毫秒");
            return res + nums[round];
        }
    }
}
