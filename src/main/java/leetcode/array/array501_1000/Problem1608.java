package leetcode.array.array501_1000;

import java.util.Arrays;

/**
 * 特殊数组的特征值
 *
 * @author : chezj
 * @date : 2022/9/12 14:22
 */
public class Problem1608 {


    public static void main(String[] args) {
        Problem1608 p = new Problem1608();

        System.out.println(p.specialArray(new int[]{1, 2, 3, 5, 6}));
    }


    public int specialArray(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;
        for (int x = 0; x < 1010; x++) {
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (nums[mid] >= x) r = mid;
                else l = mid + 1;
            }
            if (nums[r] >= x && x == n - r) return x;
        }
        return -1;
    }


    public int specialArray1(int[] nums) {
        int n = nums.length;
        for (int i = 0; i <= n; i++) {
            int cnt = 0;
            for (int num : nums) {
                if (num >= i) cnt++;
            }
            if (cnt == i) return i;
        }
        return -1;
    }

}
