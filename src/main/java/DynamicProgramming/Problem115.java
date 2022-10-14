package DynamicProgramming;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;

/**
 * 不同的子序列
 *
 * @author : chezj
 * @date : 2022/9/3 16:09
 */
public class Problem115 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem115 p = new Problem115();
        System.out.println(p.numDistinct("rabbbit", "rabbit"));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    int[][] memo;
    
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(s, 0, t, 0);
    }
    
    public int dp(String s1, int i, String s2, int j) {
        if (j == s2.length()) {
            return 1;
        }
        if (s1.length() - i < s2.length() - j) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = 0;
        for (int p = i; p < s1.length(); p++) {
            if (s1.charAt(p) == s2.charAt(j)) {
                res += dp(s1, p + 1, s2, j + 1);
            }
        }
        // 存入备忘录
        memo[i][j] = res;
        return res;
    }
    
    
    
}
