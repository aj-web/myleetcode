package leetcode.array;

import java.util.*;

import static leetcode.array.Solution4.findMedianSortedArrays;

/**
 * @Author ninan
 * @Description 寻找两个正序数组的中位数
 * 思路1：合并两个数据 时间复杂度为快速排序时间复杂度O(m+n)log(m+n)
 * 思路2：归并排序
 * @Date 2021/7/26
 **/
public class Problem4 {


    public static void main(String[] args) {
        int[] a = new int[]{1, 3};
        int[] b = new int[]{2};
        System.out.println(findMedianSortedArrays(a, b));
    }
}

class Solution4 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new TreeMap<>();

        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }

        for (int i = 0; i < nums1.length; i++) {
            map.put(i, nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            map.put(i+nums1.length, nums2[i]);
        }

        if (map.size() % 2 == 0) {

            return  ((double) map.get((0 + map.size() - 1) / 2) + (double) map.get((0 + map.size() - 1) / 2 + 1)) / 2;
        } else {
            return  (double) map.get((0 + map.size()) / 2);
        }

    }
}
