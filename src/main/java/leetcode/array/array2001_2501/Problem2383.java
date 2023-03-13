package leetcode.array.array2001_2501;

import org.apache.commons.lang3.time.StopWatch;

/**
 * @author : chezj
 * @date : 2023/3/13 22:45
 */
public class Problem2383 {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem2383 p = new Problem2383();
        System.out.println(p.minNumberOfHours(1, 1, new int[]{1, 1, 1, 1}, new int[]{1, 1, 1, 50}));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }

    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {

        int s = 0;
        for (int x : energy) {
            s += x;
        }
        int ans = Math.max(0, s - initialEnergy + 1);
        for (int x : experience) {
            if (initialExperience <= x) {
                ans += x - initialExperience + 1;
                initialExperience = x + 1;
            }
            initialExperience += x;
        }
        return ans;
    }


}
