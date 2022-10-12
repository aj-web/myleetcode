package leetcode.array.Array1_500;


import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;

/**
 * LeetCode31：下一个排列 思路很重要
 */
public class Problem31 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem31 p = new Problem31();
        p.nextPermutation1(new int[] {5,4,2,3,1});
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        if (i >= 0) {
            int j = nums.length - 1;
            while (j > 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        
        reverse(nums, i + 1);
        System.out.println(Arrays.toString(nums));
    }
    
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    
    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
    
    
    public void nextPermutation1(int[] nums) {
        int index = nums.length - 2;
        while (index >= 0 && nums[index] >= nums[index+1]) {
            index--;
        }
        if (index > 0) {
            int two = nums.length - 1;
            while (two >= 0 && nums[two] <= nums[index]) {
                two--;
            }
            swap(nums, index, two);
        }
        
        reverse1(nums, index + 1);
        System.out.println(Arrays.toString(nums));
    }
    
    
    public void reverse1(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
    
    
}
