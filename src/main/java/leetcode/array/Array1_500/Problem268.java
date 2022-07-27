package leetcode.array.Array1_500;

import java.util.HashSet;

public class Problem268 {

    public static void main(String[] args) {

        int[] nums = new int[]{0,1,2,3,4,6,7,8,9};
        System.out.println(missingNumber1(nums));
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
}
