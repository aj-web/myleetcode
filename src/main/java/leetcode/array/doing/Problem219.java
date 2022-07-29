package leetcode.array.doing;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode:219 存在重复元素II
 * 滑动窗口
 */
public class Problem219 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1,2,3};
        containsNearbyDuplicate(nums,2);
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length==1) {
            return false;
        }
        int slow = 0;
        int fast = 1;
        while (fast< nums.length || slow< nums.length){
            if (nums[fast]==nums[slow]){
                if (Math.abs(fast- slow)<=k) {
                    return true;
                }
            }

            if (fast+1>=nums.length){
                slow++;
                if (slow== nums.length-1) {
                    return false;
                }
                fast = slow;
            }
            fast++;
        }
        return false;
    }

    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Map<Integer,Integer> window = new HashMap<>();
        Map<Integer,Integer> need = new HashMap<>();
        int left =0,right =0;
        while (right<window.size()){
            int num = nums[right];
            right++;


            /**
             *
             */



        }





    }
}
