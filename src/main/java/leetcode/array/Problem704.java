package leetcode.array;

/**
 * @author chezhijun
 * @descririon 二分查找
 * @date 2021/11/8
 */
public class Problem704 {

    public static void main(String[] args) {
        int[] a = new int[]{-1, 0, 3, 5, 9, 12};
        int search = search(a, 0);
        System.out.println(search);
    }


    public static int search(int[] nums, int target) {

        if (nums.length == 0) {
            return -1;
        }

        if (nums[0] == target) {
            return 0;
        }

        if (nums[nums.length - 1] == target) {
            return nums.length - 1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
