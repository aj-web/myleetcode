package leetcode.array.array501_1000;

import java.util.ArrayList;
import java.util.List;

/**
 * 按奇偶排列数组
 *
 * @author : chezj
 * @date : 2022/8/31 17:06
 */
public class Problem905 {
    
    public int[] sortArrayByParity(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                list.add(num);
            } else {
                list2.add(num);
            }
        }
        list.addAll(list2);
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
    
    /**
     * 两遍遍历，追加结果
     *
     * @param nums
     * @return
     */
    public int[] sortArrayByParity1(int[] nums) {
        int n = nums.length, index = 0;
        int[] res = new int[n];
        for (int num : nums) {
            if (num % 2 == 0) {
                res[index++] = num;
            }
        }
        for (int num : nums) {
            if (num % 2 == 1) {
                res[index++] = num;
            }
        }
        return res;
    }
}
