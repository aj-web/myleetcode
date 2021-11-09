package leetcode.array;

/**
 * @author chezhijun
 * @descririon 删除有序数组中的重复项
 * @date 2021/11/6
 */
public class Problem26 {
    public static void main(String[] args) {
        int a[] = new int[]{1,1,2,2,3,3};
        int i = removeDuplicates1(a);
        System.out.println(i);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            int k = i + 1;
            while (k <= nums.length - 1 && nums[k] <= nums[i]) {
                k++;

            }
            if (k <= nums.length - 1) {
                nums[i + 1] = nums[k];
            }
        }

        return c;
    }

    public static int removeDuplicates1(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }

        int fast = 1;
        int slow = 1;

        while (fast < nums.length){
            if (nums[fast]!=nums[fast-1]){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }


}
