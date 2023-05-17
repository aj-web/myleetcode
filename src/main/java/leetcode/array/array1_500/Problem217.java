package leetcode.array.array1_500;

import java.util.Arrays;
import java.util.HashMap;

/**
 * LeetCode217:存在重复元素 map判断 双指针判断
 */
public class Problem217 {
    
    public static void main(String[] args) {
        int[] p = new int[] {1, 7, 8, 9, 3, 4, 5, 6, 2, 2};
        System.out.println(containsDuplicate(p));
    }
    
    public static boolean containsDuplicate(int[] nums) {
        int slow = 0;
        int fast = 1;
        while (fast < nums.length || slow < nums.length - 1) {
            if (nums[fast] == nums[slow]) {
                return true;
            }
            if (fast + 1 == nums.length) {
                slow++;
                if (slow == nums.length - 1) {
                    return false;
                }
                fast = slow;
            }
            fast++;
        }
        return false;
    }
    
    public static boolean containsDuplicate1(int[] nums) {
        
        HashMap map = new HashMap(nums.length);
        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            } else {
                map.put(num, null);
            }
        }
        return false;
    }
    
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
        
    }
}
