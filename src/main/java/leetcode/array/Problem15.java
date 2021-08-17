package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author chezhijun
 * @descririon
 * @date 2021/8/16
 */
public class Problem15 {

    public static void main(String[] args) {
        int[] a= new int[]{-1,0,1,2,-1,-4};
        List tar = threeSum(a);
        for (int i = 0; i < tar.size(); i++) {
            System.out.println(tar.get(i));
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ls = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ls;
        }
        Arrays.sort(nums);

        int p2 = nums.length -1;

        for (int i = 0; i < nums.length - 1; i++) {
            int p1 = i +1;
            while (p1 < p2){
                if (nums[i] + nums[p1] + nums[p2]==0){

                    ls.add(Arrays.asList(nums[i],nums[p1],nums[p2]));

                    while(nums[p1] == nums[p1+1]){
                        p1++;
                    }
                    while (nums[p2] == nums[p2-1]){
                        p2--;
                    }
                }else if (nums[i] + nums[p1] + nums[p2] >0){
                    p2--;
                }else {
                    p1++;
                }
            }
        }

        return ls;
    }
}
