package leetcode.array.array501_1000;

import org.apache.commons.lang3.time.StopWatch;

import java.util.HashMap;

/**
 * 连续数组
 * :前缀和
 *
 * @author : chezj
 * @date : 2023/3/12 15:46
 */
public class Problem525 {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem525 p = new Problem525();

        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }

    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        // 计算 nums 的前缀和
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + (nums[i] == 0 ? -1 : 1);
        }
        // 前缀和到索引的映射，方便快速查找所需的前缀和
        HashMap<Integer, Integer> valToIndex = new HashMap<>();
        int res = 0;
        for (int i = 0; i < preSum.length; i++) {
            // 如果这个前缀和还没有对应的索引，说明这个前缀和第一次出现，记录下来
            if (!valToIndex.containsKey(preSum[i])) {
                valToIndex.put(preSum[i], i);
            } else {
                // 这个前缀和已经出现过了，则找到一个和为 0 的子数组
                res = Math.max(res, i - valToIndex.get(preSum[i]));
            }
            // 因为题目想找长度最大的子数组，所以前缀和索引应尽可能小
        }
        return res;
    }

}
