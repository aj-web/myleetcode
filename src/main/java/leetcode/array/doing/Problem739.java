package leetcode.array.doing;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;
import java.util.Stack;

/**
 * 每日温度
 * 单调栈
 *
 * @author : chezj
 * @date : 2022/9/7 15:15
 */
public class Problem739 {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem739 problem739 = new Problem739();
        System.out.println(Arrays.toString(problem739.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? 0 : (stack.peek() - i);
            stack.push(i);
        }
        return res;
    }
}
