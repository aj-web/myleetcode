package leetcode.array.array501_1000;

import org.apache.commons.lang3.time.StopWatch;

import java.util.HashMap;

/**
 * 连续的子数组和
 *
 * @author : chezj
 * @date : 2023/3/12 17:02
 */
public class Problem523 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem523 p = new Problem523();
        
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        // 计算 nums 的前缀和
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        
        // 前缀和与 k 的余数到索引的映射，方便快速查找所需的前缀和
        HashMap<Integer, Integer> valToIndex = new HashMap<>();
        for (int i = 0; i < preSum.length; i++) {
            // 在哈希表中记录余数
            int val = preSum[i] % k;
            // 如果这个余数还没有对应的索引，则记录下来
            if (!valToIndex.containsKey(val)) {
                valToIndex.put(val, i);
            }
            // 如果这个前缀和已经有对应的索引了，则什么都不做
            // 因为题目想找长度最大的子数组，所以前缀和索引应尽可能小
        }
        
        int res = 0;
        for (int j = 1; j < preSum.length; j++) {
            // 计算 need，使得 (preSum[j] - need) % k == 0
            int need = preSum[j] % k;
            if (valToIndex.containsKey(need)) {
                if (j - valToIndex.get(need) >= 2) {
                    // 这个子数组的长度至少为 2
                    return true;
                }
            }
        }
        return false;
    }
    
}

