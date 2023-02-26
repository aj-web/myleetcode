package leetcode.array.array1_500;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode228：汇总区间
 * AC
 */
public class Problem228 {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 2, 3, 4, 6, 8, 9};
        System.out.println(summaryRanges1(nums));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            result.add(String.valueOf(nums[0]));
            return result;
        }

        int left = 0;
        int right = 1;
        for (; right < nums.length; right++) {
            if (nums[right - 1] + 1 != nums[right]) {
                if (right == left + 1) {
                    result.add(String.valueOf(nums[left]));
                } else {
                    result.add(nums[left] + "->" + nums[right - 1]);
                }
                left = right;
            }
            if (left == nums.length - 1) {
                result.add(String.valueOf(nums[nums.length - 1]));
            }
            if (right == nums.length - 1 && left != nums.length - 1) {
                result.add(nums[left] + "->" + nums[right]);
            }
        }
        return result;
    }


    public static List<String> summaryRanges1(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        if (nums.length == 1) {
            result.add(String.valueOf(nums[0]));
            return result;
        }

        int left = 0;
        int right = 0;

        while (right < nums.length) {
            right++;
            while (right < nums.length && nums[right - 1] + 1 == nums[right]) {
                right++;
            }

            StringBuffer temp = new StringBuffer(Integer.toString(nums[left]));
            if (left < right - 1) {
                temp.append("->");
                temp.append(nums[right - 1]);
            }
            result.add(temp.toString());
            left = right;

        }
        return result;
    }
}
