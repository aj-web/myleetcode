package leetcode.array.array1_500;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chezhijun
 * @descririon 寻找三数之和 1.特判，对于数组长度 nn，如果数组为 nullnull 或者数组长度小于 33，返回 [][]。 2.对数组进行排序。 3.遍历排序后数组： 4.若
 * nums[i]>0nums[i]>0：因为已经排序好，所以后面不可能有三个数加和等于 00，直接返回结果。 5.对于重复元素：跳过，避免出现重复解 6.令左指针 L=i+1L=i+1，右指针 R=n-1R=n−1，当 L<RL<R
 * 时，执行循环： 7.当 nums[i]+nums[L]+nums[R]==0nums[i]+nums[L]+nums[R]==0，执行循环，判断左界和右界是否和下一位置重复，去除重复解。并同时将 L,RL,R 移到下一位置，寻找新的解
 * 8.若和大于 0，说明 nums[R]nums[R] 太大，RR 左移 9.若和小于 0，说明 nums[L]nums[L] 太小，LL 右移
 * @date 2021/8/16 TODO
 */
public class Problem15 {
    
    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem15 p = new Problem15();
        List<List<Integer>> lists = p.threeSum20240401(new int[] {1, -1, -1, 0}, 0);
        Thread.sleep(1000);
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    
    /**
     * @Author ninan
     * @Description 思路如上，但是其中有些许优化能让循环提前返回,例如不重复
     * @Date 2021/8/19
     **/
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
    
    /**
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum20240401(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tuples = twoSumTarget(nums, i + 1, target - nums[i]);
            for (List<Integer> tuple : tuples) {
                tuple.add(nums[i]);
                res.add(tuple);
            }
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
        
    }
    
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        // 穷举 fourSum 的第一个数
        for (int i = 0; i < n; i++) {
            // 对 target - nums[i] 计算 threeSum
            List<List<Integer>> triples = threeSumTarget(nums, i + 1, target - nums[i]);
            // 如果存在满足条件的三元组，再加上 nums[i] 就是结果四元组
            for (List<Integer> triple : triples) {
                triple.add(nums[i]);
                res.add(triple);
            }
            // fourSum 的第一个数不能重复
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }
    
    
    public List<List<Integer>> threeSumTarget(int[] nums, int start, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        // i 从 start 开始穷举，其他都不变
        for (int i = start; i < n; i++) {
            List<List<Integer>> tuples = twoSumTarget(nums, i + 1, target - nums[i]);
            for (List<Integer> tuple : tuples) {
                tuple.add(nums[i]);
                res.add(tuple);
            }
            while (i < n - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return res;
    }
    
    
    /**
     * 先写一个通用的求两数之和的方法
     */
    public List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
        int lo = start;
        int hi = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            int left = nums[lo], right = nums[hi];
            if (sum < target) {
                while (lo < hi && left == nums[lo]) {
                    lo++;
                }
            } else if (sum > target) {
                while (lo < hi && nums[hi] == right) {
                    hi--;
                }
            } else {
                //                res.add(new ArrayList<>(Arrays.asList(left, right)));
                temp.add(left);
                temp.add(right);
                while (lo < hi && nums[lo] == left) {
                    lo++;
                }
                while (lo < hi && nums[hi] == right) {
                    hi--;
                }
            }
            
        }
        res.add(temp);
        return res;
    }
    
    
    public List<List<Integer>> twoSumTarget20240414(int[] nums, int start, int target) {
        int lo = start;
        int hi = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            int left = nums[lo];
            int right = nums[hi];
            if (sum < target) {
                while (lo < hi && left == nums[lo]) {
                    lo++;
                }
            } else if (sum > target) {
                while (lo < hi && right == nums[hi]) {
                    hi--;
                }
                
            } else {
                res.add(new ArrayList<>(Arrays.asList(left, right)));
                while (lo < hi && left == nums[lo]) {
                    lo++;
                }
                while (lo < hi && nums[hi] == right) {
                    hi--;
                }
                
            }
            
            
        }
        return res;
    }
    
    public List<List<Integer>> threeSumTarget20240414(int[] nums, int start, int target) {
        
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> twoSumTarget = twoSumTarget20240414(nums, i + 1, target - nums[i]);
            for (List<Integer> list : twoSumTarget) {
                list.add(nums[i]);
                res.add(list);
            }
            while (i < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
            
        }
        
        return res;
    }
    
    
}