package DynamicProgramming;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;

/**
 * leetcode 最长公共子序列
 *
 * @author : chezj
 * @date : 2022/8/27 17:01
 */
public class Problem1143 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem1143 p = new Problem1143();
        System.out.println(p.longestCommonSubsequence1("abcde", "ace"));
        
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    /**
     * 自低向上
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
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
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }
    
    
    int[][] memo = null;
    
    /**
     * 添加备忘录优化
     *
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence1(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        memo = new int[m + 1][n + 1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(text1, 0, text2, 0);
    }
    
    public int dp(String s1, int i, String s2, int j) {
        if (s1.length() == i || s2.length() == j) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = 1 + dp(s1, i + 1, s2, j + 1);
        } else {
            memo[i][j] = Math.max(dp(s1, i + 1, s2, j), dp(s1, i, s2, j + 1));
        }
        return memo[i][j];
    }
}
