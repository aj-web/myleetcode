package leetcode.array.doing;

import java.util.ArrayList;
import java.util.List;

public class Problem643 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 12, -5, -6, 50, 3};
        System.out.println(findMaxAverage1(nums, 4));
    }

    public static double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int right = 0;

        List<Integer> list = new ArrayList<>(k);

        int avg = -Integer.MAX_VALUE;
        while (right < nums.length) {
            list.add(nums[right]);
            right++;

            if (list.size() >= k) {
                int temp = 0;
                for (Integer integer : list) {
                    temp += integer;
                }
                avg = Math.max(avg, temp);
            }
            while (right - left + 1 > k) {
                list.remove(0);
                left++;
            }
        }
        return 1.0 * avg / k;
    }


    /**
     * 优化版
     *AC   3ms  但是可以优化
     * @param nums
     * @param k
     * @return
     */
    public static double findMaxAverage1(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        int res = -Integer.MAX_VALUE;
        while (right < nums.length) {
            count += nums[right];
            right++;
            while (right - left + 1 > k) {

                    res = Math.max(res, count);

                count = count - nums[left];
                left++;
            }
        }
        return 1.0 * res / k;
    }


}
