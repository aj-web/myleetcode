package leetcode.array.Array1_500;

import java.util.HashSet;

/**
 *
 * ：异或运算，0-n的每个数 异或 nums里的每个数 #(因为这些数放在一起，只有缺失的数出现一次，其余数均出现两次)
 */
public class Problem268 {

    public static void main(String[] args) {

        int[] nums = new int[]{0,1,2,3,4,6,7,8,9};
        System.out.println(missingNumber2(nums));
    }

    public static int missingNumber(int[] nums) {
        int length = nums.length;

        HashSet<Integer> hashSet = new HashSet<>(length+1);
        for (int i = 0; i < length+1; i++) {
            hashSet.add(i);
        }

        for (int num : nums) {
            if (hashSet.contains(num)) {
                hashSet.remove(num);
            }
        }
        for (Integer integer : hashSet) {
            return integer;
        }

        return -1;
    }


    public static int missingNumber1(int[] nums) {
        int length = nums.length;

        boolean[] hashSet = new boolean[length+1];
        for (int i = 0; i < length; i++) {
            hashSet[nums[i]] = true;
        }

        for (int i = 0; i < length; i++) {
            if (!hashSet[i]){
                return i;
            }
        }
        return length;
    }

    public static int missingNumber2(int[] nums) {
        int n = nums.length;
        int res = 0;
        // 先和新补的索引异或一下
        res ^= n;
        // 和其他的元素、索引做异或
        for (int i = 0; i < n; i++)
            res ^= i ^ nums[i];
        return res;
    }
}
