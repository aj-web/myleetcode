package leetcode.array.Array1_500;

import java.util.HashMap;

/**
 * LeetCode169:多数元素
 */
public class Problem169 {

    public int majorityElement(int[] nums) {

        if (nums.length==1){
            return nums[0];
        }

        HashMap<Integer,Integer> map = new HashMap(nums.length);
        for (int num : nums) {
            if (map.containsKey(num)) {
                if (map.get(num)+1>nums.length/2) {
                    return num;
                }else {
                    map.put(num,map.get(num)+1);
                }
            }else {
                map.put(num,1);
            }
        }

        return 0;
    }
}
