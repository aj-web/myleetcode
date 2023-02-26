package leetcode.array.array1_500;

import java.util.ArrayList;
import java.util.List;

/**
 * 最大连续1的数
 */
public class Problem485 {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }


    public static int findMaxConsecutiveOnes(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                list.add(i, i);
            }
            if (nums[i] == 0) {
                list.add(i + 1);
            }
            if (i == nums.length - 1) {
                list.add(nums.length + 1);
            }
        }
        for (int i = 1; i < list.size(); i++) {
            count = Math.max(count, list.get(i) - list.get(i - 1) - 1);
        }
        return count;
    }
}
