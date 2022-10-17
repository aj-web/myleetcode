package leetcode.array.Array1501_2000;

/**
 * 最大升序子数组和
 *
 * @author : chezj
 * @date : 2022/10/7 21:49
 */
public class Problem1800 {

    public static void main(String[] args) {
        Problem1800 p = new Problem1800();
        System.out.println(p.maxAscendingSum(new int[]{10, 20, 30, 5, 10, 50}));
    }


    public int maxAscendingSum(int[] nums) {
        int res = nums[0];
        int total = res;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                total += nums[i];
            } else {
                total = nums[i];
            }
            res = Math.max(total, res);
        }
        return res;
    }
}
