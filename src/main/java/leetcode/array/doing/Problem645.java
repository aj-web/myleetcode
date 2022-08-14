package leetcode.array.doing;

/**
 * leetcode错误的集合
 */
public class Problem645 {

    public int[] findErrorNums(int[] nums) {
        int dup = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                dup = Math.abs(nums[i]);
            } else {
                nums[index] *= -1;
            }
        }
        int mis = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > 0) {
                mis = j + 1;
            }
        }
        return new int[]{dup, mis};

    }
}
