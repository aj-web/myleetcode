package leetcode.array.Array1_500;

import java.util.Arrays;

/**
 * 转置矩阵
 *
 * @author : chezj
 * @date : 2022/8/30 14:07
 */
public class Problem867 {
    
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(transpose(new int[][] {{1,2,3},{4,5,6},{7,8,9}})));
    }
    
    
    public static int[][] transpose(int[][] matrix) {
        int[][] res = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                res[j][i] = matrix[i][j];
            }
        }
        return res;
    }
    
}
