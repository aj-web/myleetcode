package leetcode.array.Array1001_1500;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;

/**
 * @author : chezj
 * @date : 2022/11/9 22:15
 */
public class Problem1051 {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem1051 p = new Problem1051();
        System.out.println(p.heightChecker(new int[]{5, 1, 2, 3, 4}));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }


    /**
     * 待优化
     *
     * @param heights
     * @return
     */
    public int heightChecker(int[] heights) {
        int[] copyOf = Arrays.copyOf(heights, heights.length);
        Arrays.sort(heights);
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != copyOf[i]) {
                res++;
            }
        }

        return res;
    }
}
