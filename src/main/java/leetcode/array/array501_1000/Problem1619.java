package leetcode.array.array501_1000;

import java.util.Arrays;

/**
 * @author : chezj
 * @date : 2022/9/14 21:46
 */
public class Problem1619 {
    
    public static void main(String[] args) {
        Problem1619 p = new Problem1619();
        System.out.println(p.trimMean(
                new int[] {6, 0, 7, 0, 7, 5, 7, 8, 3, 4, 0, 7, 8, 1, 6, 8, 1, 1, 2, 4, 8, 1, 9, 5, 4, 3, 8, 5, 10, 8, 6,
                        6, 1, 0, 6, 10, 8, 2, 3, 4}));
    }
    
    
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int len = arr.length;
        int left = len * 5 / 100;
        int right = len - left;
        
        int cout = 0;
        double num = len - 2.0 * left;
        for (; left < right; left++) {
            cout += arr[left];
        }
        return cout / num;
    }
    
}
