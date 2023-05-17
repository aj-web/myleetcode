package leetcode.array.array1_500;

import org.apache.commons.lang3.time.StopWatch;

/**
 * @author chezhijun
 * @descririon 搜索插入位置   (x & y) + ((x ^ y) >> 1
 * @date 2021/11/8
 */
public class Problem35 {
    
    
    public static void main(String[] args) {
        int[] a = new int[] {-1, 3, 5, 6};
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem35 p = new Problem35();
        System.out.println(p.searchInsersasdawa(a, 5));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    public int searchInsert(int[] nums, int target) {
        
        if (nums[0] >= target) {
            return 0;
        }
        
        if (nums[nums.length - 1] == target) {
            return nums.length - 1;
        }
        
        if (nums.length == 1) {
            if (target > nums[0]) {
                return 1;
            } else {
                return 0;
            }
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
            if (left == right) {
                if (nums[left] > target) {
                    return left;
                } else if (nums[left] < target) {
                    return left + 1;
                }
            }
        }
        return -1;
    }
    
    /**
     * 左闭右闭找左节点有问题，这题的思路是让写左闭右开？
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsersadt(int[] nums, int target) {
        if (nums.length == 1) {
            if (target > nums[0]) {
                return 1;
            } else {
                return 0;
            }
        }
        
        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            
            if (left == right) {
                if (nums[left] >= target) {
                    return left;
                } else {
                    return left + 1;
                }
            }
        }
        return -1;
    }
    
    
    /**
     * 左闭右开找左节点
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsersasdawa(int[] nums, int target) {
        if (nums.length == 1) {
            if (target > nums[0]) {
                return 1;
            } else {
                return 0;
            }
        }
        
        if (target < nums[0]) {
            return 0;
        }
        if (target > nums[nums.length - 1]) {
            return nums.length;
        }
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
            
            if (left == right) {
                if (nums[left] >= target) {
                    return left;
                } else {
                    return left + 1;
                }
            }
        }
        return -1;
    }
}
