package DynamicProgramming;

/**
 * leetcode 不相交的线
 *
 * @author : chezj
 * @date : 2022/8/27 21:11
 */
public class Problem1035 {

    public static void main(String[] args) {
        System.out.println(maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
    }


    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = Math.max(1 + dp[i - 1][j - 1], dp[i][j]);
                }

            }
        }

        return dp[m][n];
    }
}
