package leetcode.array;

import java.util.Arrays;


/**
 * @Author ninan
 * @Description 寻找两个正序数组的中位数
 * 思路1：合并两个数据 时间复杂度为快速排序时间复杂度O(m+n)log(m+n)
 * 思路2：归并排序
 * TODO
 * @Date 2021/7/26
 **/
public class Problem4 {


    public static void main(String[] args) {
        int[] a = new int[]{1,3,6};
        int[] b = new int[]{14,16,18,20,21};
        System.out.println(finefindMedianSortedArrays4(a, b));
    }


    /**
     * 时间负载度 nlogn
     * 暴力破解 1.创建新数组 2.复制两个数组到新数组 3.排序取中位数
     * @param nums1
     * @param nums2
     * @return
     */
    public static double finefindMedianSortedArraysViolent(int[] nums1, int[] nums2) {
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
     *
     * @Author ninan
     * @Description 双指针合并两个有序数组，然后求出中位数,合并的时候用一个新数组，来保存两个旧数组
     * @Date 21:40
     **/
    public static double finefindMedianSortedArrays(int[] nums1, int[] nums2) {
        int p1 = 0;
        int p2 = 0;
        int cur = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        int length3 = length1+length2;
        int[] target = new int[length3];

        while (p1<length1 || p2< length2){
            if (p1 == nums1.length){
                target[cur] = nums2[p2];
                p2++;
            }else if (p2 == nums2.length){
                target[cur] = nums1[p1++];
            }else if (nums1[p1]<nums2[p2]){
                target[cur] = nums1[p1];
                p1++;
            }else{
                target[cur] = nums2[p2];
                p2++;
            }
            cur++;
        }
        if (length3%2==0){
            return ((double) (target[length3/2]+target[(length3-1)/2])/2);
        }else {
            return target[length3/2];
        }
    }


    /**
     * @Author ninan
     * @Description 如果第一个数组能够放下两个数据，那么倒序，把两个数组存入第一个数组，对比上面可以节约空间
     * @Date 21:54
     **/
    public static double finefindMedianSortedArrays2(int[] nums1, int[] nums2) {
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


    /**
     * 采用新思路 不合并数组 直接根据中位数进行判断
     * TODO  类似第K小数  暂时不会
     * @param nums1
     * @param nums2
     * @return
     */
    public static double finefindMedianSortedArrays4(int[] nums1, int[] nums2) {

        return 0;
    }
}




