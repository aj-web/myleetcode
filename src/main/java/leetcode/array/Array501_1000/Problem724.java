package leetcode.array.Array501_1000;

/**寻找数组的中心下标
 * @author : chezj
 * @date : 2022/8/19 16:27
 */
public class Problem724 {

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }

    public static int pivotIndex(int[] nums) {
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;

        for (int i = 1; i <= nums.length; i++) {
            preSum[i] += nums[i-1]+preSum[i-1];
        }

        for (int i = 1; i < preSum.length; i++) {
            int left = preSum[i-1];
            int right = preSum[preSum.length-1] - preSum[i];
            if (left == right){
                return i-1;
            }
        }
        return -1;
    }
}
