package leetcode.array.Array501_1000;

import java.util.Arrays;

/**
 * @author : chezj
 * @TODO 数学结论没懂
 * @date : 2022/9/19 22:08
 */
public class Problem908 {


    public int smallestRangeI(int[] nums, int k) {

        int minNum = Arrays.stream(nums).min().getAsInt();
        int maxNum = Arrays.stream(nums).max().getAsInt();
        return maxNum - minNum <= 2 * k ? 0 : maxNum - minNum - 2 * k;

    }


}
