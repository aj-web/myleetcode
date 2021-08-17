package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chezhijun
 * @descririon 寻找三数之和
 * 1.特判，对于数组长度 nn，如果数组为 nullnull 或者数组长度小于 33，返回 [][]。
 * 2.对数组进行排序。
 * 3.遍历排序后数组：
 * 4.若 nums[i]>0nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 00，直接返回结果。
 * 5.对于重复元素：跳过，避免出现重复解
 * 6.令左指针 L=i+1L=i+1，右指针 R=n-1R=n−1，当 L<RL<R 时，执行循环：
 * 7.当 nums[i]+nums[L]+nums[R]==0nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,RL,R 移到下一位置，寻找新的解
 * 8.若和大于 0，说明 nums[R]nums[R] 太大，RR 左移
 * 9.若和小于 0，说明 nums[L]nums[L] 太小，LL 右移
 * @date 2021/8/16
 */
public class Problem15 {

    public static void main(String[] args) {
        int[] a = new int[]{-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4};
        List tar = threeSum(a);
        for (int i = 0; i < tar.size(); i++) {
            System.out.println(tar.get(i));
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ls = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ls;
        }
        if (nums.length == 3 && nums[0] + nums[1] + nums[2] == 0) {
            ls.add(Arrays.asList(nums[0], nums[1], nums[2]));
            return ls;
        } else if (nums.length == 3 && nums[0] + nums[1] + nums[2] != 0) {
            return ls;
        }

        Arrays.sort(nums);


        int leftjudge;
        int rightjudge;


        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int p1 = i + 1;
            int p2 = nums.length - 1;
            while (p1 < p2) {
                if (nums[i] + nums[p1] + nums[p2] == 0) {
                    ls.add(Arrays.asList(nums[i], nums[p1], nums[p2]));
                    leftjudge = nums[p1];
                    rightjudge = nums[p2];

                    p1++;
                    p2--;

                    while (leftjudge == nums[p1]) {
                        if (p1 + 1 <= nums.length - 1) {
                            p1++;
                        } else {
                            break;
                        }
                    }
                    while (rightjudge == nums[p2]) {
                        if (p2 - 1 >= 0) {
                            p2--;
                        } else {
                            break;
                        }
                    }
                    if (p1 > p2) {
                        break;
                    }
                } else if (nums[i] + nums[p1] + nums[p2] > 0) {
                    p2--;
                } else {
                    p1++;
                }
            }
        }

        return ls;
    }

    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            if (nums == null || nums.length < 3) {
                return result;
            }
            Arrays.sort(nums);
            int len = nums.length;
            int left;
            int right;
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                left = i + 1;
                right = len - 1;
                if (i >= 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                while (left < right) {
                    if (nums[left] + nums[right] + nums[i] == 0) {
                        res = Arrays.asList(nums[i], nums[left], nums[right]);
                        result.add(res);
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (nums[left] + nums[right] + nums[i] > 0) {
                        right--;
                    } else {
                        left++;
                    }
                }

            }
            return result;
        }
    }
}
