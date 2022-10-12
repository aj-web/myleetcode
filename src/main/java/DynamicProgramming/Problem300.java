package DynamicProgramming;

import java.util.Arrays;

/**
 * 最长递增子序列
 *
 * @author : chezj
 * @date : 2022/8/20 23:00
 */
public class Problem300 {
    public static void main(String[] args) {

        int[] p = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(p));
    }

    public static int lengthOfLIS(int[] nums) {
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


}
