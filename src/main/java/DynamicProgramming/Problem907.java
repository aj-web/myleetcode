package DynamicProgramming;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**子数组的最小值之和
 * 单调栈
 *  TODO
 * @author : chezj
 * @date : 2022/9/6 16:02
 */
public class Problem907 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem907 problem907 = new Problem907();
        System.out.println(problem907.sumSubarrayMins2(new int[] {80, 75, 30, 45,78,35}));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    
    public int sumSubarrayMins(int[] arr) {
        int MOD = (int) 1e9 + 7;
        
        int len = arr.length;
        int[] l = new int[len];
        int[] r = new int[len];
        
        Arrays.fill(l, -1);
        Arrays.fill(r, len);
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            while (!deque.isEmpty() && arr[deque.peekLast()] >= arr[i]) {
                r[deque.pollLast()] = i;
            }
            //尾部插入元素
            deque.addLast(i);
        }
        
        deque.clear();
        
        for (int i = len - 1; i >= 0; i--) {
            while (!deque.isEmpty() && arr[deque.peekLast()] > arr[i]) {
                l[deque.pollLast()] = i;
            }
            deque.addLast(i);
        }
        long ans = 0;
        for (int i = 0; i < len; i++) {
            int a = l[i], b = r[i];
            ans += (i - a) * 1L * (b - i) % MOD * arr[i] % MOD;
            ans %= MOD;
        }
        return (int) ans;
        
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
    
    
    /**
     * 80, 75, 30, 45,78,35
     * @param arr
     * @return
     */
    public int sumSubarrayMins2(int[] arr) {
        int MOD = 1_000_000_007;
        int N = arr.length;
        
        // 第 1 步：计算当前下标 i 的左边第 1 个比 arr[i] 小的元素的下标
        Deque<Integer> stack1 = new ArrayDeque<>();
        int[] prev = new int[N];
        for (int i = 0; i < N; i++) {
            while (!stack1.isEmpty() && arr[i] <= arr[stack1.peekLast()]) {
                stack1.removeLast();
            }
            prev[i] = stack1.isEmpty() ? -1 : stack1.peekLast();
            stack1.addLast(i);
        }
        
        // 第 2 步：计算当前下标 i 的右边第 1 个比 arr[i] 小的元素的下标
        Deque<Integer> stack2 = new ArrayDeque<>();
        int[] next = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            while (!stack2.isEmpty() && arr[i] < arr[stack2.peekLast()]) {
                stack2.removeLast();
            }
            next[i] = stack2.isEmpty() ? N : stack2.peekLast();
            stack2.addLast(i);
        }
        
        // 第 3 步：计算结果
        long ans = 0;
        for (int i = 0; i < N; ++i) {
            // 注意：乘法可能越界，须要先转成 long 类型
            ans += (long) (i - prev[i]) * (next[i] - i) % MOD * arr[i] % MOD;
            ans %= MOD;
        }
        return (int) ans;
    }

    
}
