package leetcode.array.array1_500;

import java.util.HashMap;

/**
 * LeetCode169:多数元素 AC
 */
public class Problem169 {
    
    
    public static void main(String[] args) {
        int[] nums = new int[] {2, 2, 1, 1, 1, 2, 2};
        Problem169 p = new Problem169();
        p.majorityElement1(nums);
    }
    
    
    /**
     * 常规思路用一个map存储每个数组的数量
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        HashMap<Integer, Integer> map = new HashMap(nums.length);
        for (int num : nums) {
            if (map.containsKey(num)) {
                if (map.get(num) + 1 > nums.length / 2) {
                    return num;
                } else {
                    map.put(num, map.get(num) + 1);
                }
            } else {
                map.put(num, 1);
            }
        }
        
        return 0;
    }
    
    
    /**
     * 寻找众数思路：众数记作1，其他数字记作-1，互相抵消，那么最后的count一定是正数
     *
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        
        if (nums.length == 1) {
            return nums[0];
        }
        
        int count = 0;
        int target = 0;
        for (int num : nums) {
            if (count == 0) {
                target = num;
                count++;
            } else if (num != target) {
                count--;
            } else if (num == target) {
                count++;
            }
        }
        return target;
    }
    
    
}
