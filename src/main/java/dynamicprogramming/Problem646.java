package dynamicprogramming;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 最长数对链
 *
 * @author : chezj
 * @date : 2022/9/3 15:09
 */
public class Problem646 {


    public int findLongestChain(int[][] pairs) {
        int[] dp = new int[pairs.length];
        Arrays.sort(pairs, Comparator.comparingInt(a -> a[0]));
        Arrays.fill(dp, 1);

        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
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
