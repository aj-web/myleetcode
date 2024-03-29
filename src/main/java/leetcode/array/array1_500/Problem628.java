package leetcode.array.array1_500;

import java.util.Arrays;

/**
 * leetcode三个数的最大乘积
 */
public class Problem628 {
    
    
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3],
                nums[0] * nums[1] * nums[nums.length - 1]);
    }
    
}
