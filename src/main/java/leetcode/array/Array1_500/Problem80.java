package leetcode.array.Array1_500;


/**
 * LeetCode80：删除有序数组中的重复项
 * AC
 */
public class Problem80 {

    public static void main(String[] args) {
        System.out.println("11111");
        int[] a = new int[]{1, 1, 1, 2, 2, 3};
        removeDuplicates3(a);
    }


    public static int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int slow = 0;
        int slowCount = 0;
        int fast = 0;
        int move = 0;
        int temp = 0;

        while (fast < nums.length - move) {
            if (nums[slow] == nums[fast]) {
                slowCount++;
                if (slowCount == 2) {
                    slow = fast;
                }
            } else {
                System.arraycopy(nums, fast, nums, slow + 1, nums.length - fast);
                temp = fast - slow - 1;
                move = move + temp;
                fast = fast - temp;
                slow = fast;
                slowCount = 0;
                if (nums[slow] == nums[fast]) {
                    slowCount++;
                }
            }

            fast++;
        }

        return slow + 1;
    }

    public static int removeDuplicates1(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int slow = 2;
        int slowCount = 0;
        int fast = 2;


        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slowCount++;
                nums[slow] = nums[fast];
            } else if (slow < fast && slowCount < 2) {
                slow++;
                nums[slow] = nums[fast];
            }

            fast++;
            slowCount++;
            if (fast < nums.length && nums[fast] != nums[fast - 1]) {
                slowCount = 0;
            }

        }

        return slow + 1;
    }


    public static int removeDuplicates3(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }

        int slow = 0;
        int fast = 0;
        int slowCount = 0;


        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            } else if (slow < fast && slowCount < 2) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
            slowCount++;
            if (fast < nums.length && nums[fast] != nums[fast - 1]) {
                slowCount = 0;
            }

        }

        return slow + 1;
    }

}
