package DynamicProgramming;

import org.apache.commons.lang3.time.StopWatch;

/**
 * 最长回文子串
 *
 * @author : chezj
 * @date : 2022/8/31 23:34
 */
public class Problem5 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem5 p = new Problem5();
        System.out.println(p.longestPalindrome1("ba"));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    
    public String longestPalindrome(String s) {
        int m = s.length();
        boolean[][] dp = new boolean[m][m];
        for (int i = 0; i < m; i++) {
            dp[i][i] = true;
        }
        int maxLen = 1;
        int begin = 0;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (j >= i) {
                    break;
                }
                if (s.charAt(i) != s.charAt(j)) {
                    dp[j][i] = false;
                } else {
                    if (i - j < 3) {
                        dp[j][i] = true;
                    } else {
                        dp[j][i] = dp[j + 1][i - 1];
                    }
                }
                if (dp[j][i] && i - j + 1 > maxLen) {
                    maxLen = i - j + 1;
                    begin = j;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
    
    /**
     * 使用双指针求解
     *
     * @param s
     * @return
     */
    public String longestPalindrome1(String s) {
        if (s.length() == 2) {
            return s;
        }
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String res1 = palindrome(s, i, i);
            String res2 = palindrome(s, i, i + 1);
            res = res.length() > res1.length() ? res : res1;
            res = res.length() > res2.length() ? res : res2;
        }
        return res;
    }
    
    
    public String palindrome(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
    
    
}
