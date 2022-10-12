package leetcode.array.Array1_500;

/**
 * leetcode136:只出现一次的数组
 * 异或操作
 * AC
 */
public class Problem136 {
    public static void main(String[] args) {
        int[] p = new int[]{1, 1, 2, 3, 3, 4, 4};
        System.out.println(singleNumber(p));
    }

    public static int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
