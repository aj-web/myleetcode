package leetcode.array.Array501_1000;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * leetcode最长和谐子序列
 */
public class Problem594 {
    /**
     * 排序+滑动窗口
     * @param nums
     * @return
     */
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int slow = 0;
        int fast = 0;
        int res = 0;
        for (; fast < nums.length; fast++) {
            while (nums[fast] - nums[slow] > 1) {
                slow++;
            }
            if (nums[fast] - nums[slow] == 1) {
                res = Math.max(res, fast - slow + 1);
            }

        }
        return res;
    }

    /**
     * 使用map存储个数
     * @param nums
     * @return
     */
    public int findLHS1(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for (int i : map.keySet()) {
            if (map.containsKey(i+1)){
                res = Math.max(res,map.get(i)+ map.get(i+1)) ;
            }
        }
        return res;
    }

}
