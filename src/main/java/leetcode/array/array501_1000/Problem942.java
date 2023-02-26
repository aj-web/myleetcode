package leetcode.array.array501_1000;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/**
 * 增减字符串匹配
 *
 * @author : chezj
 * @date : 2022/9/5 11:06
 */
public class Problem942 {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println(Arrays.toString(diStringMatch("IDID")));
        stopWatch.stop();
        System.out.println(stopWatch.getTime(TimeUnit.MICROSECONDS) + "毫秒");
    }


    /**
     * 简单贪心
     *
     * @param s
     * @return
     */
    public static int[] diStringMatch(String s) {
        int len = s.length();
        int lo = 0;
        int hi = len;
        int[] res = new int[s.length() + 1];
        for (int i = 0; i < len; i++) {
            res[i] = s.charAt(i) == 'I' ? lo++ : hi--;
        }
        res[len] = lo;
        return res;
    }

}
