package leetcode.array;

import java.util.Arrays;


/**
 * @Author ninan
 * @Description 寻找两个正序数组的中位数
 * 思路1：合并两个数据 时间复杂度为快速排序时间复杂度O(m+n)log(m+n)
 * 思路2：归并排序
 * @Date 2021/7/26
 **/
public class Problem4 {


    public static void main(String[] args) {
        int[] a = new int[]{1, 2};
        int[] b = new int[]{3, 4};
        System.out.println(finefindMedianSortedArrays1(a, b));
    }

    public static double finefindMedianSortedArrays1(int[] nums1, int[] nums2) {
        int[] target = new int[nums1.length + nums2.length];

        for (int i = 0; i < nums1.length; i++) {
            target[i] = nums1[i];
        }
        System.arraycopy(nums2, 0, target, nums1.length, nums2.length);
        Arrays.sort(target);


        if (target.length % 2 == 0) {

            return ((double) target[(target.length) / 2] + (double) target[(target.length - 1) / 2]) / 2;
        } else {
            return target[target.length / 2];
        }
    }

    /**
     * @Author ninan
     * @Description 双指针合并两个有序数组，然后求出中位数,合并的时候用一个新数组，来保存两个旧数组
     * @Date 21:40
     **/
    public static double finefindMedianSortedArrays2(int[] nums1, int[] nums2) {
        int p1 = 0;
        int p2 = 0;
        int cur;
        int[] tar = new int[nums1.length + nums2.length];
        while (p1 < nums1.length || p2 < nums2.length) {
            if (nums1.length == p1) {
                cur = nums2[p2++];
            } else if (nums2.length == p2) {
                cur = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                cur = nums1[p1++];
            } else {
                cur = nums2[p2++];
            }
            tar[p1 + p2 - 1] = cur;
        }
        if (tar.length % 2 == 0) {

            return ((double) tar[(tar.length) / 2] + (double) tar[(tar.length - 1) / 2]) / 2;
        } else {
            return tar[tar.length / 2];
        }
    }


    /**
     * @Author ninan
     * @Description 如果第一个数组能够放下两个数据，那么倒序，把两个数组存入第一个数组，对比上面可以节约空间
     * @Date 21:54
     **/
    public static double finefindMedianSortedArrays3(int[] nums1, int[] nums2) {
        int p1 = nums1.length - 1;
        int p2 = nums2.length - 1;
        int cur;
        int[] tar = new int[nums1.length + nums2.length];
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }

            tar[p1 + p2 -1] =cur;
        }


        return 0;
    }


    public static double finefindMedianSortedArrays4(int[] nums1, int[] nums2) {
        return 0;
    }
}




