package leetcode.array;

import java.util.Arrays;

/**
 * @Author ninan
 * @description 合并两个有序数组
 * 思路1：直接将两个数组合并，然后重新排序
 * @Date 2021/8/3
 **/
public class Problem88 {

    public static void main(String[] args) {
        int[] a1 = new int[]{1,2,3,0,0,0};
        int[] a2 = new int[]{2,5,6};
        merger2(a1,3,a2,3);
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums1, 0, nums2, n, m);
        Arrays.sort(nums2);
    }

    /**
     * @Author ninan
     * @Description 使用指针进行比较
     * @Date 2021/8/10
     **/
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int current;
        int[] sort = new int[m + n];
        while (p1 < m || p2 < n) {
            if (m == p1) {
                current = nums1[p2++];
            } else if (n == p2) {
                current = nums2[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                current = nums1[p1++];
            } else {
                current = nums2[p2++];
            }

            sort[p1 + p2 - 1] = current;
        }

        for (int i = 0; i < m + n; i++) {
            nums1[i] = sort[i];
        }
    }

    /**
     * @Author ninan
     * @Description
     * @Date 2021/8/10
     **/
    public static void merger2(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == 0 && nums2.length > 0) {
            for (int i = 0; i != n; ++i) {
                nums1[m + i] = nums2[i];
            }
        } else if (nums2.length == 0 && nums1.length > 0) {

        } else if (nums1.length == 0 && nums2.length == 0) {

        } else {
            int p1 = m - 1;
            int p2 = n - 1;
            int current;
            while (p1 > 0 || p2 > 0) {
                if (nums1[p1] > nums2[p2]){
                    current = nums1[p1];
                }else {
                    current = nums2[p2--];
                }
                    nums1[p1--] = current;
            }
        }

    }
}
