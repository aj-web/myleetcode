package leetcode.array.array1001_1500;

import org.apache.commons.lang3.time.StopWatch;

/**
 * 统计有序矩阵中的负数
 *
 * @author : chezj
 * @date : 2023/5/21 16:28
 */
public class Problem1351 {


    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem1351 p = new Problem1351();

        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }


    public int countNegatives(int[][] grid) {
        int m = grid[0].length;
        int n = grid.length;

        int count = 0;
        for (int i = 0; i < n; i++) {
            int[] temp = grid[i];
            if (temp[m - 1] >= 0) {
                continue;
            }
            int left = 0;
            int right = m - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (temp[mid] < 0) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            count += m - left;
        }

        return count;


    }
}
