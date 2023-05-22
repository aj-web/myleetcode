package leetcode.array.array1_500;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;

/**
 * LeetCode34. 在排序数组中查找元素的第一个和最后一个位置 AC
 */
public class Problem34 {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem34 p = new Problem34();

        int[] a = new int[]{1};
        System.out.println(Arrays.toString(p.searchRange(a, 0)));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{leftBound(nums, target), rightBound(nums, target)};
    }

    /**
     * 找左边界
     * 从这里我开始懂了的为什么要补上最后的if判断因为左闭右开的区间，最终退出循环的条件是left=right 所以还需要补漏判断一下left或者right
     */
    public int leftBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }
        if (left >= nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }


    /**
     * 找右边界
     */
    public int rightBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                left = mid + 1;
            }
        }
        if (right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }

    
}
