package DynamicProgramming;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;

/**
 * 不同的子序列 II
 *
 * @author : chezj
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
    
    
    public int distinctSubseqII(String s) {
        int m = s.length();
        int n = s.length();
        int[][] dp = new int[][]{};
        Arrays.fill(dp[0],0);
        for (int[] ints : dp) {
            ints[0] = 0;
        }
        
        
        
        
        return 0;
    }
    
}
