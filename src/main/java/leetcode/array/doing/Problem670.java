package leetcode.array.doing;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Stack;

/**
 * 最大交换
 *
 * @author : chezj
 * @date : 2022/9/13 17:49
 */
public class Problem670 {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem670 p = new Problem670();
        System.out.println(p.maximumSwap(988357));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }

    /**
     * 单调栈求解
     * @param num
     * @return
     */
    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int[] res = new int[chars.length];
        for (int i = 0; i < chars.length; ++i) {
            res[i] = Integer.parseInt(String.valueOf(chars[i]));
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (; i < res.length; i++) {
            if (stack.isEmpty() || res[stack.peek()] >= res[i]) {
                stack.push(i);
            } else {
                break;
            }
        }
        if (i == res.length) {
            return num;
        }

        int left = 0;
        int right = i;

        for (; i < res.length; i++) {
            if (res[i] >= res[right]) {
                right = i;
            }
        }

        while (!stack.isEmpty() && res[right] > res[stack.peek()]) {
            left = stack.pop();
        }


        int temp = res[left];
        res[left] = res[right];
        res[right] = temp;

        StringBuilder stringBuilder = new StringBuilder();
        for (int re : res) {
            stringBuilder.append(re);
        }


        return Integer.parseInt(stringBuilder.toString());
    }


}
