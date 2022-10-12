package DynamicProgramming;

/**
 * 最长重复子数组
 * 注意这题目的隐藏条件 子数组的是连续的
 *
 * @author : chezj
 * @date : 2022/8/21 12:26
 */
public class Problem718 {

    public static void main(String[] args) {
        System.out.println(findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }


    /**
     * 注意优化 这里的dp[i][j] 是由dp[i-1][j-1]推到来的 如果自底向上会有很多重复情况
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int res = 0;
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                res = Math.max(dp[i][j], res);
            }
        }
        return res;
    }


    /**
     * 注意优化 采用倒序自顶向下循环
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int findLength1(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int res = 0;
        for (int i = nums1.length - 1; i >= 0; i--) {
            for (int j = nums2.length - 1; j >= 0; j--) {
                dp[i][j] = nums1[i] == nums2[j] ? dp[i + 1][j + 1] + 1 : 0;
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }

}
