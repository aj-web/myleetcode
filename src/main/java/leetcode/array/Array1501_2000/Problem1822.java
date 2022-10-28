package leetcode.array.Array1501_2000;

import org.apache.commons.lang3.time.StopWatch;

/**
 * 数组元素积的符号
 *
 * @author : chezj
 * @date : 2022/10/27 10:21
 */
public class Problem1822 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem1822 p = new Problem1822();
        
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    public int arraySign(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            }
            if (num < 0) {
                count++;
            }
        }
        return count % 2 == 0 ? 1 : -1;
    }
    
}
