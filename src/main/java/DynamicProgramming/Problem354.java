package DynamicProgramming;

import java.util.Arrays;

/**
 * 俄罗斯套娃信封问题
 *
 * @author : chezj
 * @date : 2022/8/21 11:19
 */
public class Problem354 {

    public static void main(String[] args) {
        int[][] e = new int[][]{{1, 1}, {1, 1}, {1, 1}};
        System.out.println(maxEnvelopes(e));
    }


    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 1) {
            return 0;
        }
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);


        int[] height = new int[n];
        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);
    }


    public static int lengthOfLIS(int[] nums) {
        int[] top = new int[nums.length];
        // 牌堆数初始化为 0
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            // 要处理的扑克牌
            int poker = nums[i];

            /***** 搜索左侧边界的二分查找 *****/
            int left = 0, right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            /*********************************/

            // 没找到合适的牌堆，新建一堆
            if (left == piles) piles++;
            // 把这张牌放到牌堆顶
            top[left] = poker;
        }
        // 牌堆数就是 LIS 长度
        return piles;
    }


}
