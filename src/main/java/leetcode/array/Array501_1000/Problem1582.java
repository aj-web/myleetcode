package leetcode.array.Array501_1000;

/**
 * 二进制矩阵中的特殊位置
 *
 * @author : chezj
 * @date : 2022/9/4 14:33
 */
public class Problem1582 {


    public static void main(String[] args) {
        System.out.println(numSpecial(new int[][]{{1, 0, 0}, {0, 0, 1}, {1, 0, 0}}));
    }


    public static int numSpecial(int[][] mat) {
        int m = mat[0].length;
        int n = mat.length;

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    int sum = 0;
                    for (int k = 0; k < m; k++) {
                        sum += mat[k][j];
                    }
                    for (int k = 0; k < n; k++) {
                        sum += mat[i][k];
                    }
                    if (sum == 2) {
                        res++;
                    }
                }

            }
        }
        return res;
    }


    public int numSpecial1(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    //计算行列相加是否为2
                    int sum = 0;
                    for (int k = 0; k < m; k++) {
                        sum += mat[k][j];
                    }
                    for (int k = 0; k < n; k++) {
                        sum += mat[i][k];
                    }
                    if (sum == 2) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

}
