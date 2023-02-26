package leetcode.array.array1_500;


import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 在部分有序的数组中，我们可以尝试用二分查找优化
 * leetcode33：搜索旋转排序数组数组
 * AC 二分查找在部分有序的数组中，可以尝试构造有序的部分来优化
 */
public class Problem33 {

    public static void main(String[] args) {
        String s = "k1=v1;k2=v2;k3=v3;k4=v41=v42";

        Map result = new HashMap();
        String[] split = s.split(";");
        for (String str : split) {
            if (StringUtils.isEmpty(str)) {
                continue;
            }
            if (str.contains("=") || !str.startsWith(";") || !str.endsWith(";")) {
                int i = str.indexOf("=");
                if (i == -1) {
                    continue;
                }
                result.put(str.substring(0, i), str.substring(i + 1));
            }
        }

    }


/*    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7,  0, 1, 2};
        int search = search(nums, 6);
    }


    public static int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int search1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[left]) {

                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[right] >= target && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

        }
        return -1;
    }*/


}
