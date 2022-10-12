package leetcode.array.Array1_500;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * leetcode:找到所以数组中消失的数字
 */
public class Problem448 {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        findDisappearedNumbers1(nums);
    }


    /**
     * 暴力解法
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> set = new HashSet<>(nums.length);
        List<Integer> list = new ArrayList<>(nums.length);
        for (int i : nums) {
            set.add(i);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }

        return list;
    }

    /**
     * 暴力解法
     *
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int i1 = Math.abs(nums[i]) - 1;
            if (nums[i1] > 0) {
                nums[i1] = -nums[i1];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(i + 1);
            }
        }
        return list;
    }

}
