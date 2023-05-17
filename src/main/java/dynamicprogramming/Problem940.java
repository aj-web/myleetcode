package dynamicprogramming;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;

/**
 * 不同的子序列 II
 *
 * @author : chezj
 * @TODO 太难了 我真服了
 * @date : 2022/10/14 10:55
 */
public class Problem940 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem940 p = new Problem940();
        System.out.println(p.distinctSubseqII("abc"));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    /**
     * 字符串          子序列 a              a    dp[1] = 1 ab             a的子序列 + ab b     dp[2] = dp[1] * 2 + 1 abc
     * ab的子序列 + ac abc bc c     dp[3] = dp[2] * 2 + 1 abcc           abc的子序列 + ac abc bc acc abcc bcc cc c `有重复`
     *
     * @param s
     * @return
     */
    public int distinctSubseqII(String s) {
        int mod = (int) 1e9 + 7;
        char c[] = s.toCharArray();
        int last[] = new int[26];
        long count[] = new long[c.length];
        Arrays.fill(last, -1);
        Arrays.fill(count, 1);
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < 26; j++) {
                if (last[j] >= 0) {
                    count[i] += count[last[j]];
                }
            }
            count[i] %= mod;
            last[c[i] - 'a'] = i;
        }
        long ans = 0;
        for (int i = 0; i < 26; i++) {
            if (last[i] >= 0) {
                ans += count[last[i]];
            }
        }
        return (int) (ans % mod);
    }
    
    
}
