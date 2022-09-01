package DynamicProgramming;

/**
 * 最长回文子串
 *
 * @author : chezj
 * @date : 2022/8/31 23:34
 */
public class Problem5 {
    
    public static void main(String[] args) {
        
        System.out.println(longestPalindrome1("ba"));
        
    }
    
    
    public static String longestPalindrome(String s) {
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
    
    
    public static String longestPalindrome1(String s) {
        if (s.length()<2){
            return s;
        }
        
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            
            if (s.length() % 2 == 0) {
                String s2 = palindrome(s, i, i + 1);
                res = res.length() > s2.length() ? res : s2;
            } else {
                String s1 = palindrome(s, i, i);
                res = res.length() > s1.length() ? res : s1;
            }
            
            
        }
        if ("".equals(res)) {
            return  s.substring(0,1);
        }
        return res;
    }
    
    static String palindrome(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            // 向两边展开
            l--;
            r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(l + 1, r);
    }
    
}
