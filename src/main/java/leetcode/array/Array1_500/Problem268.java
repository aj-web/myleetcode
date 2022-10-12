package leetcode.array.Array1_500;

import java.util.HashSet;

/**
 * LeetCode268：丢失的数字
 * ：异或运算，0-n的每个数 异或 nums里的每个数 #(因为这些数放在一起，只有缺失的数出现一次，其余数均出现两次)
 * 因此，如果有多个数异或，其中由重复的数，不论这些重复的数是否相邻，如果这些数重复了偶数次，则异或后会全部消去；如果重复出现了奇数次，则会保留一个。这就是理论基础
 */
public class Problem268 {

    public static void main(String[] args) {

        int[] nums = new int[]{0, 1, 2, 3, 4, 6, 7, 8, 9};
        System.out.println(missingNumber2(nums));
    }

    public static int missingNumber(int[] nums) {
        int length = nums.length;

        HashSet<Integer> hashSet = new HashSet<>(length + 1);
        for (int i = 0; i < length + 1; i++) {
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

        boolean[] hashSet = new boolean[length + 1];
        for (int i = 0; i < length; i++) {
            hashSet[nums[i]] = true;
        }

        for (int i = 0; i < length; i++) {
            if (!hashSet[i]) {
                return i;
            }
        }
        return length;
    }

    /**
     * 采用异或的方法处理
     *
     * @param nums
     * @return
     */
    public static int missingNumber2(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i] ^ i;
        }
        return res;
    }


}
