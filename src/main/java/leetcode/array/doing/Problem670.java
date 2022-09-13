package leetcode.array.doing;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Stack;

/**最大交换
 * @author : chezj
 * @date : 2022/9/13 17:49
 */
public class Problem670 {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem670  p = new Problem670();
        System.out.println(p.maximumSwap(2736));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    
    
    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int[] res = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            res[i] = Integer.parseInt(String.valueOf(chars[i]));
        }
    
        int[] ints = nextGreaterElement(res);
        return 1;
    }
    
    
    public int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }
    
    

}
