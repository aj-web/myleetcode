package leetcode.array.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chezhijun
 * @descririon 返回数组所有子集
 * @date 2021/11/24
 */
public class Offer79 {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6,7,8,9};
        List<List<Integer>> subsets = subsets(a);
        System.out.println("");
    }

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        while (p1<= nums.length-1){
            while (p2< nums.length-1){
                List<Integer> l1 = new ArrayList();
                List<Integer> l2 = new ArrayList<>();

                if (p1==0){
                    int num = nums[p2];
                    l1.add(num);
                    list.add(l1);
                }

                if (p2>p1 ){
                    l2.add(nums[p2]);
                    l2.add(nums[p1]);
                    list.add(l2);
                }
                p2++;
            }
            p1++;
            p2 =p1;
        }

        return list;
    }
}
