package dynamicprogramming;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;

/**
 * 不同的子序列 两个字符串的子序列问题通常dp(String s,int i,String t,int k)
 *
 * @author : chezj
 * @date : 2022/9/3 16:09
 */
public class Problem115 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem115 p = new Problem115();
        System.out.println(p.numDistinct1("rabbbit", "rabbit"));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    int[][] memo;
    
    
    /**
     * 以t为视角 我们的原问题是求s[0..]的所有子序列中t[0..]出现的次数，那么可以先看t[0]在s中的什么位置，假设s[2], s[6]是字符t[0]，那么原问题转化成了在s[2..]和s[6..]的所有子序列中计算t[1..]出现的次数。
     *
     * @param s
     * @param t
     * @return
     */
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
    
    
    /**
     * 站在s的视角需要考虑"aab"的这种情况 如果s[0]可以匹配t[0]，那么又有两种情况，这两种情况是累加的关系 1、让s[0]匹配t[0]，那么原问题转化为在s[1..]的所有子序列中计算t[1..]出现的次数。
     * 2、不让s[0]匹配t[0]，那么原问题转化为在s[1..]的所有子序列中计算t[0..]出现的次数。 为啥明明s[0]可以匹配t[0]，还不让它俩匹配呢？主要是为了给s[0]之后的元素匹配的机会，比如s = "aab", t
     * = "ab"，就有两种匹配方式：a_b和_ab。
     *
     * @param s
     * @param t
     * @return
     */
    int[][] memo1;
    
    public int numDistinct1(String s, String t) {
        int m = s.length(), n = t.length();
        memo1 = new int[m][n];
        for (int[] row : memo1) {
            Arrays.fill(row, -1);
        }
        return dp1(s, 0, t, 0);
    }
    
    public int dp1(String s1, int i, String s2, int j) {
        if (j == s2.length()) {
            return 1;
        }
        if (s1.length() - i < s2.length() - j) {
            return 0;
        }
        if (memo1[i][j] != -1) {
            return memo1[i][j];
        }
        int res = 0;
        if (s1.charAt(i) == s2.charAt(j)) {
            res += dp1(s1, i + 1, s2, j + 1) + dp1(s1, i + 1, s2, j);
        } else {
            res += dp1(s1, i + 1, s2, j);
        }
        // 存入备忘录
        memo1[i][j] = res;
        return res;
    }
}
