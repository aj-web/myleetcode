package leetcode.array.doing;

import java.util.Arrays;

/**
 * @author : chezj
 * @date : 2022/8/29 15:24
 */
public class Problem1470 {
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shuffle(new int[] {2, 5, 1, 3, 4, 7}, 3)));
    }
    
    public static int[] shuffle(int[] nums, int n) {
        int[] res = new int[nums.length];
        int index = 0;
        int right = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i<=n-1){
                res[index] = nums[i];
                index+=2;
            }else {
                res[right] = nums[i];
                right+=2;
            }
        }
        
        return res;
    }
    
    
    
    public static int[] shuffle1(int[] nums, int n) {
        int[] res = new int[nums.length];
        int index = 0;
        for (int i = 0; i < n; i++) {
            res[index++] = nums[i];
            res[index++] = nums[i+n];
        }
        return res;
    }
    
}
