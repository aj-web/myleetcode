package leetcode.array.Array1001_1500;

import org.apache.commons.lang3.time.StopWatch;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : chezj
 * @date : 2023/2/15 22:58
 */
public class Problem1124 {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem1124 p = new Problem1124();
        System.out.println(p.longestWPI(new int[]{9, 9, 6, 0, 6, 6, 9}));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }


    public int longestWPI(int[] hours) {
        Map<Integer, Integer> map = new HashMap<>();
        int s = 0, res = 0;
        for (int i = 0; i < hours.length; i++) {
            s += hours[i] > 8 ? 1 : -1;
            if (s > 0) {
                res = Math.max(res, i + 1);
            } else {
                if (map.containsKey(s - 1)) {
                    res = Math.max(res, i - map.get(s - 1));
                }
            }
            if (!map.containsKey(s)) {
                map.put(s, i);
            }

        }
        return res;
    }
}
