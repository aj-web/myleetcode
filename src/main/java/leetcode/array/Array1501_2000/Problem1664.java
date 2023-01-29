package leetcode.array.Array1501_2000;

import org.apache.commons.lang3.time.StopWatch;

/**
 * @author : chezj
 * @date : 2023/1/29 9:32
 */
public class Problem1664 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem1664 p = new Problem1664();
        int i = p.waysToMakeFair(new int[] {2, 1, 6, 4});
        System.out.println(i);
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    public int waysToMakeFair(int[] nums) {
        
        int res = 0;
        int n = nums.length;
        int[] prefixEvenSum = new int[n];
        int[] prefixOddSum = new int[n];
        int[] suffixEvenSum = new int[n];
        int[] suffixOddSum = new int[n];
        int evenSum = 0;
        int oddSum = 0;
        for (int i = 0; i < n; i++) {
            prefixOddSum[i] = oddSum;
            prefixEvenSum[i] = evenSum;
            if ((i & 1) == 0) {
                evenSum += nums[i];
            } else {
                oddSum += nums[i];
            }
        }
        evenSum = 0;
        oddSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            suffixEvenSum[i] = evenSum;
            suffixOddSum[i] = oddSum;
            if ((i & 1) == 0) {
                evenSum += nums[i];
            } else {
                oddSum += nums[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (prefixOddSum[i] + suffixEvenSum[i] == prefixEvenSum[i] + suffixOddSum[i]) {
                res++;
            }
        }
        return res;
    }
    
    /**
     * 空间时间优化
     *
     * @param nums
     * @return
     */
    public int waysToMakeFair1(int[] nums) {
        
        int res = 0;
        int n = nums.length;
        int[] suffixEvenSum = new int[n];
        int[] suffixOddSum = new int[n];
        int evenSum = 0;
        int oddSum = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            suffixEvenSum[i] = evenSum;
            suffixOddSum[i] = oddSum;
            if ((i & 1) == 0) {
                evenSum += nums[i];
            } else {
                oddSum += nums[i];
            }
        }
        evenSum = 0;
        oddSum = 0;
        
        for (int i = 0; i < n; i++) {
            if (oddSum + suffixEvenSum[i] == evenSum + suffixOddSum[i]) {
                res++;
            }
            if ((i & 1) == 0) {
                evenSum += nums[i];
            } else {
                oddSum += nums[i];
            }
        }
        
        return res;
    }
    
    
    /**
     * 时间优化 不再分别求前奇数和 前偶数和  后奇数和  后偶数和，而是求偶数总和，奇数总和，这样减去index的值，得到当前index的后缀和 核心 偶数总和=前缀偶数和+后缀偶数和，奇数也如此
     *
     * @param nums
     * @return
     */
    public int waysToMakeFair2(int[] nums) {
        int n = nums.length;
        // 前缀奇数下标元素和
        int prefixOddSum = 0;
        // 后缀奇数下标元素和
        int suffixOddSum = 0;
        // 前缀偶数下标元素和
        int prefixEvenSum = 0;
        // 后缀偶数下标元素和
        int suffixEvenSum = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            if ((i & 1) == 0) {
                suffixEvenSum += nums[i];
            } else {
                suffixOddSum += nums[i];
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if ((i & 1) == 0) {
                suffixEvenSum -= nums[i];
            } else {
                suffixOddSum -= nums[i];
            }
            
            if (prefixEvenSum + suffixOddSum == prefixOddSum + suffixEvenSum) {
                count++;
            }
            
            // 更新前缀和
            if ((i & 1) == 0) {
                prefixEvenSum += nums[i];
            } else {
                prefixOddSum += nums[i];
            }
        }
        return count;
    }
}
