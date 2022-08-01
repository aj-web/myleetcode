package leetcode.array.Array1_500;


import java.util.HashSet;
import java.util.Set;

/**
 * leetcode349：两个数组的交集
 */
public class Problem349 {

    public static void main(String[] args) {

    }


    public int[] intersection(int[] nums1, int[] nums2) {
        int index = 0;
        Set<Integer> set1 = new HashSet(nums1.length);
        Set<Integer> result;
        if (nums1.length> nums2.length){
            result = new HashSet<>(nums1.length);
        }else {
            result = new HashSet<>(nums2.length);
        }


        for (int i : nums1) {
            set1.add(i);
        }


        for (int i : nums2) {
            if (set1.contains(i)) {
                result.add(i);
            }
        }


        Integer[] integers = result.toArray(new Integer[result.size()]);
        int[] nums = new int[result.size()];

        for (int i = 0; i < integers.length; i++) {
            nums[i] = integers[i];
        }

        return  nums;
    }
}
