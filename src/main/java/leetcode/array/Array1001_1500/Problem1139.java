package leetcode.array.Array1001_1500;

import org.apache.commons.lang3.time.StopWatch;

/**
 * 最大的以 1 为边界的正方形 使用前缀和来判断连续1的个数
 *
 * @author : chezj
 * @date : 2023/2/17 11:07
 */
public class Problem1139 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem1139 p = new Problem1139();
        
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    /**
     * 动态规划+前缀和判断
     *
     * @param grid
     * @return
     */
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][][] dp = new int[m + 1][n + 1][2];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (grid[i - 1][j - 1] == 0) {
                    continue;
                }
                dp[i][j][0] = dp[i][j - 1][0] + 1;
                dp[i][j][1] = dp[i - 1][j][1] + 1;
            }
        }
        
        int maxSide = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int curSide = Math.min(dp[i][j][0], dp[i][j][1]);
                if (curSide <= maxSide) {
                    continue;
                }
                
                for (; curSide > maxSide; curSide--) {
                    if (dp[i - curSide + 1][j][0] >= curSide && dp[i][j - curSide + 1][1] >= curSide) {
                        maxSide = curSide;
                        break;
                    }
                }
            }
        }
        return maxSide * maxSide;
    }
}
