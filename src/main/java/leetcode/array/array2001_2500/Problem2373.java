package leetcode.array.array2001_2500;

import org.apache.commons.lang3.time.StopWatch;

/**
 * 矩阵中的局部最大值->最大池化
 *
 * @author : chezj
 * @date : 2023/3/1 15:04
 */
public class Problem2373 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem2373 p = new Problem2373();
        p.largestLocal(new int[][] {{9, 9, 8, 1}, {5, 6, 2, 6}, {8, 2, 6, 4}, {6, 2, 2, 2}});
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    /**
     * 暴力解法
     *
     * @param grid
     * @return
     */
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n - 2][n - 2];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                res[i][j] = localMax(grid, i, j);
            }
        }
        return res;
    }
    
    private int localMax(int[][] grid, int left, int top) {
        int max = 0;
        for (int i = left; i < left + 3; i++) {
            for (int j = top; j < top + 3; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }
}

