package DynamicProgramming;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;

/**
 * 最长递增子序列
 *
 * @author : chezj
 * @date : 2022/8/20 23:00
 */
public class Problem300 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem300 p1 = new Problem300();
        int[] p = new int[] {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(p1.lengthOfLIS(p));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        //base_case
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        int res = 0;
        for (int i : dp) {
            res = Math.max(i, res);
        }
        return res;
    }
    
    /**
     * @param nums
     * @return
     * @date 20221014重新回顾了一遍
     */
    public static int lengthOfLIS1(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i : dp) {
            res = Math.max(i, res);
        }
        return res;
    }
    
    
}
