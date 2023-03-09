package leetcode.array.array1_500;

import org.apache.commons.lang3.time.StopWatch;

/**
 * 二维区域和检索 - 矩阵不可变
 *
 * @author : chezj
 * @date : 2023/3/9 16:32
 */
public class Problem304 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem304 p = new Problem304();
        
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    
}

class NumMatrix {
    
    int[][] preSum = null;
    
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (m == 0 || n == 0) {
            return;
        }
        preSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return preSum[row2 + 1][col2 + 1] - preSum[row2 + 1][col1] - preSum[row1][col2 + 1] + preSum[row1][col1];
    }
    
    
}