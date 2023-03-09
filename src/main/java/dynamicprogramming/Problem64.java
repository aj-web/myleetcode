package dynamicprogramming;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;

/**
 * 最小路径和
 *
 * @author : chezj
 * @date : 2023/3/8 15:37
 */
public class Problem64 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem64 p = new Problem64();
        System.out.println(p.minPathSum1(new int[][] {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    int[][] memo;
    
    /**
     * 自顶向下并添加备忘录 提交超时
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        memo = new int[m][n];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dp(grid, m - 1, n - 1);
    }
    
    private int dp(int[][] grid, int i, int j) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        return Math.min(dp(grid, i - 1, j), dp(grid, i, j - 1)) + grid[i][j];
    }
    
    /**
     * 自底向上
     *
     * @param grid
     * @return
     */
    public int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        
        //base case
        dp[0][0] = grid[0][0];
        
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        
        //状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }
    
}
