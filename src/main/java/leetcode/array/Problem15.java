package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

/**
 * @author chezhijun
 * @descririon
 * @date 2021/8/16
 */
public class Problem15 {

    public static void main(String[] args) {
        int[] t1 = new int[]{-1,0,1,2,-1,-4};

        List l = threeSum(t1);
        for (int i = 0; i < l.size(); i++) {
            System.out.println(l.get(i));
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int p1 = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int p2 = nums[i + 1];
                for (int k = i + 2; k < nums.length; k++) {
                    if (nums[k] == (-p1 - p2)) {
                        list.add(Arrays.asList(p1,p2,nums[k]));
                    }
                }
            }

        }
        return  list;
    }
}
