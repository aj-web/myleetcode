package leetcode.array.array501_1000;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * 商品折扣后的最终价格
 *
 * @author : chezj
 * @date : 2022/9/3 13:29
 */
public class Problem1475 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(finalPrices(new int[]{10, 1, 1, 6})));
    }

    /**
     * 一次遍历
     *
     * @param prices
     * @return
     */
    public static int[] finalPrices(int[] prices) {
        int[] res = new int[prices.length];
        res[prices.length - 1] = prices[prices.length - 1];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    res[i] = prices[i] - prices[j];
                    break;
                }
                if (j == prices.length - 1) {
                    res[i] = prices[i];
                }
            }
        }
        return res;
    }

    /**
     * 使用单调栈求解
     *
     * @param prices
     * @return
     */
    public static int[] finalPrices1(int[] prices) {
        int[] res = new int[prices.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = prices.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? prices[i] : prices[i] - stack.peek();
            stack.push(prices[i]);
        }
        return res;
    }

}
