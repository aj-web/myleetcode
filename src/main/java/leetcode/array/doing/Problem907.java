package leetcode.array.doing;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 子数组的最小值之和
 * TODO
 * @author : chezj
 * @date : 2022/9/6 23:51
 */
public class Problem907 {

    public static void main(String[] args) {

    }


    public int sumSubarrayMins(int[] arr) {
        int MOD = (int)1e9+7;

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
}
