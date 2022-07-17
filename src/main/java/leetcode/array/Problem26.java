package leetcode.array;

/**
 * @author chezhijun
 * @descririon 删除有序数组中的重复项
 * @date 2021/11/6
 * AC
 */
public class Problem26 {
    public static void main(String[] args) {
        int a[] = new int[]{1, 1, 2};
        int i = removeDuplicates1(a);
        System.out.println(i);
    }


    /**
     * 快慢指针 直接秒杀
     * @param nums
     * @return
     */
    public static int removeDuplicates1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow+1;
    }

}
