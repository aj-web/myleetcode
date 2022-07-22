package leetcode.array.Array1_500;

/**
 * LeetCode283：移动零
 * AC
 */
public class Problem283 {

    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 0, 3, 12};
    }


    /**
     * 采用快慢指针
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        for (; slow < nums.length; slow++) {
            nums[slow] = 0;
        }
    }
}
