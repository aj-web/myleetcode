package leetcode.array.Array1_500;


/**
 * LeetCode31：下一个排列
 * 思路很重要
 */
public class Problem31 {

    public static void main(String[] args) {
        int[] a = new int[]{1,5,1};
        nextPermutation(a);
     }




    public static void nextPermutation(int[] nums) {
        int i = nums.length-2;

        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }

        if (i>=0){
            int j = nums.length-1;
            while(j>0&& nums[j]<=nums[i] ){
                j--;
            }
            swap(nums,i,j);
        }

        reverse(nums,i+1);

    }



    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }


}
