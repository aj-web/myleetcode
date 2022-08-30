package leetcode.array.doing;

/**
 * 单调数列
 *
 * @author : chezj
 * @date : 2022/8/30 23:30
 */
public class Problem896 {
    public static void main(String[] args) {

    }


    public boolean isMonotonic(int[] nums) {
        if (nums.length <= 2) {
            return true;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] <= nums[i]) {
                up++;
            }
            if (nums[i - 1] >= nums[i]) {
                down++;
            }
        }
        if (up == nums.length || down == nums.length) {
            return true;
        }
        return false;
    }
}
