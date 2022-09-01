package leetcode.array.Array1_500;

import java.util.Arrays;

/**
 * 下一个更大元素
 */
public class Problem496 {
    public static void main(String[] args) {
        int[] num1 = new int[]{4,1,2};
        int[] num2 = new int[]{1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(num1, num2)));
    }


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
                    if (null != res[i]){
                        break;
                    }
                }
            }
            if (null == res[i]){
                res[i] = -1;
            }
        }
        return Arrays.stream(res).mapToInt(Integer::valueOf).toArray();
    }
}
