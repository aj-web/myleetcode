package leetcode.array.array501_1000;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 至少是其他数字两倍的最大数
 *
 * @author : chezj
 * @date : 2022/8/21 0:25
 */
public class Problem747 {

    public static void main(String[] args) {
        System.out.println(dominantIndex(new int[]{3, 6, 1, 0}));
    }

    public static int dominantIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[nums.length - 1] < 2 * nums[i]) {
                return -1;
            }
        }

        return map.get(nums[nums.length - 1]);
    }
}
