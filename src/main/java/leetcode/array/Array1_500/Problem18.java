package leetcode.array.Array1_500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chezhijun
 * @descririon 寻找四数之和
 * @date 2021/8/19
 * TODO
 */
public class Problem18 {
    public static void main(String[] args) {
        int[] a = new int[]{2, 2, 2, 2, 2};
        fourSum(a, 8).stream().forEach(x -> {
            System.out.println(x);
        });
    }


    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        //1.排除特殊情况
        if (nums.length < 4) {
            return result;
        }
        if (nums.length == 4) {
            if (nums[0] + nums[1] + nums[2] + nums[3] == target) {
                result.add(Arrays.asList(nums[0], nums[1], nums[2], nums[3]));
            }
            return result;
        }
        //2.排序
        Arrays.sort(nums);
        //3.循环判断

        for (int i = 0; i < nums.length; i++) {
            //去掉左指针重复的情况
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j > (i + 1) && nums[j - 1] == nums[j]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    if (nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        right--;
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) left++; // 左指针此时指向最后一个重复元素
                        while (left < right && nums[right] == nums[right - 1]) right--; // 右指针此时指向最后一个重复元素
                        left++; // 左指针此时指向区间左侧第一个非重复元素
                        right--; // 右指针此时指向区间右侧第一个非重复元素
                    }
                }
            }
        }
        return result;
    }
}
