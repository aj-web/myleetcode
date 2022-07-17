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


    /**
     * 二分查找查找最左边界 ：注意查找范围为[left，right)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchLeft(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length; // 注意
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }

        return left;
    }


    /**
     * 二分查找查找最左边界 ：注意查找范围为[left，right]
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchLeftUnite(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length - 1; // 注意
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        return left;
    }


    /**
     * 二分查找查找最右边界 ：注意查找范围为[left，right)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchRight(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length; // 注意
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                //这里不能收缩，因为右侧为开区间，如果，mid-1的话，那么指针就直接指向3，漏了一个数6    {1,.....,3,6,8}
                right = mid;
            }
        }
        return left;
    }


    /**
     * 二分查找查找最右边界 ：注意查找范围为[left，right]
     *
     * @param nums
     * @param target
     * @return
     */
    public static int binarySearchRightUnite(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = nums.length-1; // 注意
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                //这里可以收缩边界
                right = mid-1;
            }
        }
        return left;
    }
}
