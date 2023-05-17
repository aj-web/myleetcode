package leetcode.array.array2001_2501;

import org.apache.commons.lang3.time.StopWatch;

/**
 * 判断矩阵是否是一个 X 矩阵
 *
 * @author : chezj
 * @date : 2023/1/31 23:00
 */
public class Problem2319 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem2319 p = new Problem2319();
        System.out.println(p.checkXMatrix(
                new int[][] {{6, 0, 0, 0, 0, 0, 0, 18}, {0, 17, 0, 0, 0, 0, 18, 0}, {0, 0, 13, 0, 0, 17, 0, 0},
                        {19, 0, 0, 0, 0, 0, 0, 9}}));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    public boolean checkXMatrix(int[][] grid) {
        int m = grid.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == j) || (i + j + 1 == m)) {
                    if ((grid[i][j] == 0)) {
                        return false;
                    }
                } else if (grid[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
