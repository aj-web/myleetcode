package leetcode.array.offer;

/**
 * @Author ninan
 * @Description leetcode，剑指offer53:有序重复数组查找数
 * @Date 2021/7/16
 **/
public class Offer53 {

    public static void main(String[] args) {
        int[] a = new int[]{5, 7, 7, 8, 8, 10};
        System.out.println(search(a, 6));

    }


    /**
     * 有序重复数组查找数
     * 采用二分法
     * 视屏心得：int mind = left + (right - left)/2  这样可以防止在left或者right很大的时候，mind值溢出
     */
    public static int search(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums[0] > target || nums[nums.length - 1] < target) {
            return 0;
        }

        int left = findFirstTarget3(nums, target);
        if (left == -1) {
            return 0;
        }
        int right = findLastTarget3(nums, target);

        return right - left + 1;

    }


    public static int findFirstTarget(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;


        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }


    public static int findLastTarget(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                left = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }


    public static int findFirstTarget2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;


        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return -1;
    }


    public static int findLastTarget2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public static int findFirstTarget3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                right = mid;
            } else {
                right = mid - 1;
            }
        }
        if (nums[left] == target) {
            return left;
        }
        return 0;
    }


    public static int findLastTarget3(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2 + 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] == target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }
}




