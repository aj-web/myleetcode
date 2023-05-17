package leetcode.array.array1_500;

/**
 * @author : chezj
 * @date : 2022/8/26 14:12
 */
public class Problem766 {
    
    
    public static void main(String[] args) {
        int[][] a = new int[][] {{36, 59, 71, 15, 26, 82, 87}, {56, 36, 59, 71, 15, 26, 82},
                {15, 0, 36, 59, 71, 15, 26}};
        System.out.println(isToeplitzMatrix(a));
    }
    
    public static boolean isToeplitzMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
    
}
