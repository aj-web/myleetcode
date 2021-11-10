package leetcode.array;

/**
 * @author chezhijun
 * @descririon 移除元素
 * @date 2021/11/7
 */
public class Problem27 {
    public static void main(String[] args) {
        int a[] = new int[]{2, 2, 2};
        int removeElement = removeElement1(a, 2);
        System.out.println(removeElement);
    }

    public static int removeElement(int[] nums, int val) {

        if (nums.length == 1 && nums[0] == val) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        }

        int fast = 0;
        int slow = 0;
        for (; fast < nums.length ; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public static int removeElement1(int[] nums, int val) {

        if (nums.length == 1 && nums[0] == val) {
            return 0;
        } else if (nums.length == 1) {
            return 1;
        }

        int right = nums.length;
        int left = 0;
        while (left<right){
            if (nums[left]==val){
                nums[left]=nums[right-1];
                right--;
            }else {
                left++;
            }
        }
        return left;
    }
}
