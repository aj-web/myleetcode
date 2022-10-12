package leetcode.array.Array1_500;

import java.util.Arrays;

/**
 * @author : chezj
 * @date : 2022/8/17 16:21
 */
public class Problem976 {

    public static void main(String[] args) {
        int[] p = new int[]{1, 2, 2};
        System.out.println(largestPerimeter(p));
    }

    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }

        }
        return 0;
    }
}
