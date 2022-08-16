package leetcode.array.Array1_500;

import java.util.HashMap;
import java.util.Map;

public class Problem697 {

    public static void main(String[] args) {
        findShortestSubArray(new int[]{2,1});
    }


    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new Integer[]{i, 1, i});
            } else {
                Integer[] temp = map.get(nums[i]);
                map.put(nums[i], new Integer[]{temp[0], temp[1] + 1, i});
            }
        }

        int count = 0;
        for (Map.Entry<Integer, Integer[]> entry : map.entrySet()) {
            count = Math.max(entry.getValue()[1], count);
        }

        int res = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer[]> entry : map.entrySet()) {
            if (count == entry.getValue()[1]) {
                res = Math.min(entry.getValue()[2] - entry.getValue()[0] + 1, res);
            }
        }
        return res;
    }
}
