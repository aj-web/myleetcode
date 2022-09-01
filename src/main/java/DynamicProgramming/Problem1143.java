package DynamicProgramming;

import java.util.Arrays;

/**leetcode 最长公共子序列
 * @author : chezj
 * @date : 2022/8/27 17:01
 */
public class Problem1143 {

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
    }


    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        //二维dp数组
        int[][] dp = new int[m + 1][n + 1];
        Arrays.fill(dp[0], 0);
        for (int[] ints : dp) {
            ints[0] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }

            }
        }

        return dp[m][n];
    }


}
