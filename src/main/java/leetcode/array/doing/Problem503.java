package leetcode.array.doing;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;
import java.util.Stack;

/**
 * 下一个更大元素 单调栈
 *
 * @author : chezj
 * @date : 2022/9/7 14:54
 */
public class Problem503 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem503 p = new Problem503();
        System.out.println(Arrays.toString(p.nextGreaterElements(new int[] {1, 2, 3, 4, 3})));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        for (int i = 2 * n - 1; i > 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }
            res[i % n] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % n]);
        }
        return res;
    }
    
}
