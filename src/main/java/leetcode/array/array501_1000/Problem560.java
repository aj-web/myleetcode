package leetcode.array.array501_1000;

import org.apache.commons.lang3.time.StopWatch;

import java.util.HashMap;

/**
 * 和为K的子数组
 *
 * @author : chezj
 * @description: pre[i]=pre[i−1]+nums[i]------>pre[i]−pre[j−1]==k--------->pre[j−1]==pre[i]−k
 * @date : 2023/3/14 15:02
 */
public class Problem560 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem560 p = new Problem560();
        System.out.println(p.subarraySum(new int[] {1, 2, 3, 4, 5}, 8));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    public int subarraySum(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
    
    public int subarraySum1(int[] nums, int k) {
        int m = nums.length;
        int res = 0;
        int preSum[] = new int[m + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 1; i <= m; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
            int need = preSum[i] - k;
            if (map.containsKey(need)) {
                res += map.get(need);
            }
            map.put(preSum[i], map.getOrDefault(preSum[i], 0) + 1);
        }
        
        return res;
    }
}
