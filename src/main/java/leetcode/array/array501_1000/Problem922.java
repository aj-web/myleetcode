package leetcode.array.array501_1000;

import java.util.Arrays;

/**
 * 按奇偶排列数组
 *
 * @author : chezj
 * @date : 2022/9/1 16:55
 */
public class Problem922 {
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParityII(new int[] {1, 1, 2, 2})));
    }
    
    public static int[] sortArrayByParityII(int[] nums) {
        int p1 = 0;
        int p2 = 1;
        
        //[0,mid],[mid+1,num.length-1]
        int[] ints = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                ints[p1] = nums[i];
                p1 += 2;
            } else {
                ints[p2] = nums[i];
                p2 += 2;
            }
        }
        
        return ints;
    }
}
