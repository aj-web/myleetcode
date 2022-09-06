package DynamicProgramming;

import org.apache.commons.lang3.time.StopWatch;

/**
 * @author : chezj
 * @date : 2022/9/6 16:02
 */
public class Problem907 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem907 problem907 = new Problem907();
        System.out.println(problem907.sumSubarrayMins1(new int[] {3, 1, 2, 4}));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    
    
    public int sumSubarrayMins(int[] arr) {
    
    }
    
    
    
    
    
    //暴力 超时
    public int sumSubarrayMins1(int[] arr) {
        final int MOD = 1000000007;
        
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int n = arr.length;
        long ans = 0;
        // 起点
        for (int i = 0; i < n; i++) {
            int min = arr[i];
            // 终点
            for (int j = i; j < n; j++) {
                min = Math.min(min, arr[j]);
                ans += min;
                // 将取余转换为减法
                if (ans >= MOD) {
                    ans -= MOD;
                }
            }
        }
        return (int) ans;
    }
    
}
