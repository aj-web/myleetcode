package test;

/**
 * @author chezhijun
 * @descririon 34. 在排序数组中查找元素的第一个和最后一个位置
 * @date 2021/11/7
 */
public class Test34 {
    public static void main(String[] args) {
        int c[] = new int[]{2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 8};
        searchRange(c, 5);
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] a = new int[2];
        int left = 0;
        int right = nums.length - 1;

        if (nums.length == 0) {
            a[0] = -1;
            a[1] = -1;
            return a;
        }
        if (nums[nums.length - 1] < target) {
            a[0] = -1;
            a[1] = -1;
            return a;
        }
        int ftrst = findFtrst(nums, target, left, right);
        int last = findLast(nums, target, left, right);

        a[0] = ftrst;
        a[1] = last;
        return a;
    }

    public static int findFtrst(int nums[], int target, int left, int right) {

        while (left < right) {
            //中位数向下取整
            int mind = left + (right - left) / 2;
            if (nums[mind] < target) {
                left = mind + 1;
            } else if (nums[mind] == target) {
                right = mind;
            } else {
                right = mind - 1;
            }
        }

        if (nums[left] == target) {
            return left;
        }
        return -1;
    }

    public static int findLast(int nums[], int target, int left, int right) {
        while (left < right) {
            //中位数向上取整
            int mind = left + (right - left + 1) / 2;
            if (nums[mind] < target) {
                left = mind + 1;
            } else if (nums[mind] == target) {
                left = mind;
            } else {
                right = mind - 1;
            }
        }

        if (nums[right] == target) {
            return right;
        }
        return -1;
    }
}
