package leetcode.array.array1_500;

/**
 * 前缀和问题
 */
public class Problem303 {


    class NumArray {
        int[] preSum;

        public NumArray(int[] nums) {

            preSum = new int[nums.length + 1];
            preSum[0] = 0;
            for (int i = 1; i < nums.length; i++) {/*
                pres += nums[i+1];
                preSum[i] = pres;*/
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return preSum[right + 1] - preSum[left];
        }
    }
}
