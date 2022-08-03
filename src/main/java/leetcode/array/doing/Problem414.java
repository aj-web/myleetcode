package leetcode.array.doing;

import java.util.Arrays;

public class Problem414 {
    public static void main(String[] args) {
        int[] a= new int[]{2,2,3,1};
        System.out.println(thirdMax(a));
    }



    public static int thirdMax(int[] nums) {
        if (nums.length<3 ){
            return nums[nums.length-1];
        }
        Arrays.sort(nums);
        int min = 0;
        int max = nums.length-1;
        while(min<max){
            int temp = 0;
            temp = nums[min];
            nums[min] = nums[max];// 把最大的索引元素赋值给最小的索引元素
            nums[max] = temp;
            min++;
            max--;
        }
        for (int i = 1, diff = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i - 1] && ++diff == 3) { // 此时 nums[i] 就是第三大的数
                return nums[i];
            }
        }

        return nums[0];

    }

}
