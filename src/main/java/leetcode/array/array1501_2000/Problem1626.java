package leetcode.array.array1501_2000;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;

/**
 * 无矛盾的最佳球队
 *
 * @author : chezj
 * @TODO
 * @date : 2023/3/23 16:03
 */
public class Problem1626 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem1626 p = new Problem1626();
        
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    public int bestTeamScore(int[] scores, int[] ages) {
        int m = scores.length;
        int[][] people = new int[m][2];
        
        for (int i = 0; i < m; i++) {
            people[i] = new int[] {scores[i], ages[i]};
        }
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int[] dp = new int[m];
        int res = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                if (people[j][1] <= people[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += people[i][0];
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
