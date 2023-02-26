package leetcode.array.array1501_2000;

import org.apache.commons.lang3.time.StopWatch;

/**
 * @author : chezj
 * @date : 2022/11/1 18:07
 */
public class Problem1662 {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem1662 p = new Problem1662();

        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder s1 = new StringBuilder();
        for (String s : word1) {
            s1.append(s);
        }

        StringBuilder s2 = new StringBuilder();
        for (String s : word2) {
            s2.append(s);
        }
        return s1.toString().equals(s2.toString());
    }

}
