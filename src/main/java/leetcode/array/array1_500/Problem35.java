package leetcode.array.array1_500;

/**
 * @author chezhijun
 * @descririon 搜索插入位置   (x & y) + ((x ^ y) >> 1
 * @date 2021/11/8
 */
public class Problem35 {
    public static void main(String[] args) {
        int[] a = new int[]{-1, 3, 5, 6};
        int searchInsert = searchInsert(a, 0);
        System.out.println(searchInsert);
    }

    public static int searchInsert(int[] nums, int target) {

        if (nums[0] >= target) {
            return 0;
        }

        if (nums[nums.length - 1] == target) {
            return nums.length - 1;
        }

        if (nums.length == 1) {
            if (target > nums[0]) {
                return 1;
            } else {
                return 0;
            }
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
            if (left == right) {
                if (nums[left] > target) {
                    return left;
                } else if (nums[left] < target) {
                    return left + 1;
                }
            }
        }
        return -1;
    }
}
