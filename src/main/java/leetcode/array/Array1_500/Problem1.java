package leetcode.array.Array1_500;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author czj
 * @description LeetCode第一题：两数之和
 * AC
 */
public class Problem1 {
    public static void main(String[] args) {


    }

    /**
     * 时间复杂度 O的平方
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] TwoSum(int[] nums, int target) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }


    /**
     * 时间复杂度 O的n
     *
     * @Author ninan
     * @Description 使用hashmap求解
     * @Date 2021/7/16
     **/
    public int[] twoSumHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target - nums[i]), i};
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return null;
    }


    /**
     * @Author ninan O的n
     * @Description 使用hashset求解，成为leetcode，2ms模板
     * @Date 2021/7/16
     **/

    public int[] twoSumHashSet(int[] nums, int target) {
        HashSet hashSet = new HashSet(2);
        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(target - nums[i])) {

                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] == (target - nums[i])) {
                        return new int[]{j, i};
                    }
                }
            } else {
                hashSet.add(nums[i]);
            }
        }
        return null;
    }


}
