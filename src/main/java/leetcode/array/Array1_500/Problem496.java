package leetcode.array.Array1_500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * 下一个更大元素
 * 单调栈入门问题
 */
public class Problem496 {

    public static void main(String[] args) {
        int[] num1 = new int[]{4, 1, 2};
        int[] num2 = new int[]{1, 3, 4, 2};
        System.out.println(Arrays.toString(nextGreaterElement1(num1, num2)));
    }

    /**
     * 暴力解法
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Integer[] res = new Integer[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    int temp = nums2[j];
                    for (int t = j; t < nums2.length; t++) {
                        if (nums2[t] > temp) {
                            res[i] = nums2[t];
                            break;
                        }
                    }
                    if (null != res[i]) {
                        break;
                    }
                }
            }
            if (null == res[i]) {
                res[i] = -1;
            }
        }
        return Arrays.stream(res).mapToInt(Integer::valueOf).toArray();
    }


    /**
     * 简单隐射处理+单调栈
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        int[] greaterElement = nextGreaterElement(nums2);
        HashMap<Integer, Integer> greatMap = new HashMap<>(greaterElement.length);
        for (int i = 0; i < nums2.length; i++) {
            greatMap.put(nums2[i], greaterElement[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = greatMap.get(nums1[i]);
        }
        return res;
    }


    /**
     * 使用单调栈求出 下一个更大的元素
     *
     * @param nums 输入数组
     * @return 对应的下一个更大的元素
     */
    public static int[] nextGreaterElement(int[] nums) {
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
