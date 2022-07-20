package leetcode.array.doing;

/**
 * @author chezhijun
 * @descririon 下一个排列
 * @date 2022/3/14
 */
public class Problem31 {
    public static void main(String[] args) {
//        int[] a = new int[]{4,3,2,5,7,1};
        int[] a = new int[]{7, 5, 5, 5, 5, 4};
        nextPermutation(a);
        System.out.println();
    }

    public static void nextPermutation(int[] nums) {

        if (nums.length == 1) {
            return;
        }


        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[nums.length - 1]) {
                int temp = nums[i];
                nums[i] = nums[nums.length - 1];
                nums[nums.length - 1] = temp;
                break;
            }
            //i=0的时候 其实是所有的数都比nums.length-1小
            if (i == 0) {
                int temp = nums[0];
                nums[0] = nums[i + 1];
                nums[i + 1] = temp;
            }

        }
    }
}
