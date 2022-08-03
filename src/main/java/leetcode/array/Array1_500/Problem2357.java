package leetcode.array.Array1_500;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode2357：使数组中元素所有个数都等于0
 */
public class Problem2357 {


    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        return set.contains(0) ? set.size() - 1 : set.size();
    }
}
