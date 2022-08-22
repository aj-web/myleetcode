package leetcode.array.doing;

/**最长连续递增序列
 * @TODO 贪心求解
 * @author : chezj
 * @date : 2022/8/22 17:06
 */
public class Problem674 {

    public static void main(String[] args) {
        System.out.println(findLengthOfLCIS(new int[]{2, 2, 2, 2, 2}));
    }

    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int le = 0;
        int temp = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                temp++;
            } else {
                temp = 1;
            }
            le = Math.max(le, temp);
        }
        return le;
    }
}
