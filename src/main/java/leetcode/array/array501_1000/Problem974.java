package leetcode.array.array501_1000;

import org.apache.commons.lang3.time.StopWatch;

import java.util.HashMap;
import java.util.Map;

/**
 * 和可被 K 整除的子数组
 *
 * @author : chezj
 * @description: 如果两个数的差能被K整除，就说明这两个数 mod K得到的结果相同
 * @date : 2023/3/14 17:20
 */
public class Problem974 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem974 p = new Problem974();
        System.out.println(p.subarraysDivByK(new int[] {5}, 9));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    public int subarraysDivByK(int[] nums, int k) {
        int m = nums.length;
        int[] preSum = new int[m + 1];
        Map<Integer, Integer> map = new HashMap<>();
        preSum[0] = 0;
        map.put(0, 1);
        int res = 0;
        for (int i = 0; i < m; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
            int need = preSum[i + 1] % k;
            if ((need < 0)) {
                need += k;
            }
            if (map.containsKey(need)) {
                res += map.get(need);
                map.put(need, map.get(need) + 1);
            } else {
                map.put(need, 1);
            }
            
        }
        
        return res;
    }
}
