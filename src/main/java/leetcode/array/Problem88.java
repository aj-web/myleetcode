package leetcode.array;

import java.util.Arrays;

/**
 * @Author ninan
 * @Description 合并两个有序数组
 * 思路1：直接将两个数组合并，然后重新排序
 * @Date  2021/8/3
 **/
public class Problem88 {

    public static void main(String[] args) {


    }



    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums1,0,nums2,n,m);
        Arrays.sort(nums2);
    }
}
