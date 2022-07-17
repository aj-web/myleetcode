package leetcode.array;

/**
 * LeetCode74:搜索二维矩阵
 * 二维数组看做一维数组处理
 * AC
 */
public class Problem74 {

    public static void main(String[] args) {
        int[][] a = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}};
//        int[] transNum = transNum(a);
//        int num = getNum(a, 7);
        boolean b = searchMatrix(a, 3);
        System.out.println("end");

    }


    /**
     * 用一维数组下标去访问二维数组
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {
        int i = matrix[0].length;
        int j = matrix.length;
        int left = 0;
        int right = i * j - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (getNum(matrix, mid) < target) {
                left = mid + 1;
            } else if (getNum(matrix, mid) > target) {
                right = mid - 1;
            } else if (getNum(matrix, mid) == target) {
                return true;
            }
        }
        return false;
    }

    public static int getNum(int[][] matrix, int index) {
        int n = matrix[0].length;
        return matrix[index/n][index%n];
    }


    /**
     * 暴力解法，直接转换一维数组再二分查找
     * @param matrix
     * @return
     */
    public static int[] transNum(int[][] matrix) {
        if (matrix.length == 0) {
            return null;
        }
        int[] target = new int[matrix.length * matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                target[i * matrix[0].length + j] = matrix[i][j];
            }
        }
        return target;
    }

}
