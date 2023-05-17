package leetcode.array.array501_1000;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 取模运算也叫取余运算，它们返回的结果都是余数。rem(取余)和mod(取模)唯一的区别在于：当X和Y的正负号一样的时候，两个函数结果是等同的；当X和Y的符号不同时，rem(取余)函数的结果的符号和X的符号一样，而mod(取模)
 * 函数的结果符号和Y的符号一样
 * <p>
 * <p>
 * (int)1e9是10的9次方
 *
 * @author : chezj
 * @date : 2022/10/28 11:04
 */
public class Problem907 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem907 p = new Problem907();
        System.out.println(p.sumSubarrayMins(new int[] {3, 1, 2, 4}));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    /**
     * @param arr
     * @return
     */
    public int sumSubarrayMins(int[] arr) {
        int MOD = (int) 1e9 + 7;
        int ans = 0;
        int len = arr.length;
        //l[i] = loc 含义为下标 i 左边最近一个比 arr[i] 小的位置是 loc（若在 arr[i]左侧不存在比其小的数，则 loc = -1）
        int[] l = new int[len];
        //r[i] = loc 含义为下标 i 右边最近一个比 arr[i] 大的位置是 loc（若在 arr[i]左侧不存在比其大的数，则 loc = n
        int[] r = new int[len];
        
        Deque<Integer> deque = new ArrayDeque<>();
        Arrays.fill(l, -1);
        Arrays.fill(r, len);
        
        //两边预处理
        //右边第一个比它大的数，比他小则放入deque，如果比它大，在r[]中记录i
        for (int i = 0; i < len; i++) {
            while (!deque.isEmpty() && arr[deque.peekLast()] >= arr[i]) {
                r[deque.pollLast()] = i;
            }
            deque.addLast(i);
        }
        deque.clear();
        //左边第一个比它小的数，比它大放入deque，如果比它小，在l[]中记录i
        for (int i = len - 1; i >= 0; i--) {
            while (!deque.isEmpty() && arr[deque.peekLast()] > arr[i]) {
                l[deque.pollLast()] = i;
            }
            deque.add(i);
        }
        
        for (int i = 0; i < len; i++) {
            int a = i - l[i];
            int b = r[i] - i;
            ans += a * 1L * b % MOD * arr[i] % MOD;
            ans %= MOD;
        }
        
        return ans;
    }
    
    /**
     * 待优化
     */
}
