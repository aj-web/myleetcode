package leetcode.array;

import java.util.*;

/**
 * @author czj
 * @description LeetCode第一题：两数之和
 */
public class Problem1 {
    public static void main(String[] args) {
        int[] a = new int[]{3, 3};
        Solution s = new Solution();
        int[] end = s.twoSum(a, 6);
        for (int i = 0; i < end.length; i++) {
            System.out.println(i + ":" + end[i]);
        }
    }

}


/**
 * @Author ninan
 * @Description 使用hashmap求解
 * @Date 2021/7/16
 **/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                return new int[]{hashMap.get(target-nums[i]), i};
            } else {
                hashMap.put(nums[i],i);
            }
        }
        return null;
    }
}


/**
 * @Author ninan
 * @Description 使用hashset求解，成为leetcode，2ms模板
 * @Date  2021/7/16
 **/
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
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
