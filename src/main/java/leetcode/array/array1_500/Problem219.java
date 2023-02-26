package leetcode.array.array1_500;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode:219 存在重复元素II
 * 滑动窗口
 */
public class Problem219 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1, 2, 3};
        containsNearbyDuplicate1(nums, 3);
    }


    public static boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set window = new HashSet();
        int left = 0, right = 0;

        while (right < nums.length) {

            if (window.contains(nums[right])) {
                return true;
            }
            window.add(nums[right]);
            right++;

            if (right - left > k) {
                window.remove(nums[left]);
                left++;

            }
        }
        return false;

    }
}
