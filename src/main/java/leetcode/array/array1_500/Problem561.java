package leetcode.array.array1_500;

import java.util.Arrays;

/**
 * 数组拆分
 */
public class Problem561 {
    
    
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < nums.length; i += 2) {
            ans += nums[i];
        }
        return ans;
    }
}
