package leetcode.array.array501_1000;

import org.apache.commons.lang3.time.StopWatch;

import java.util.HashMap;
import java.util.Map;

/**水果成篮
 * @author : chezj
 * @date : 2022/10/17 21:00
 */
public class Problem904 {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem904 p = new Problem904();
        System.out.println(p.totalFruit(new int[]{1,2,1}));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }


    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> windows = new HashMap<>();
        int left = 0;
        int right = 0;
        int ans = 0;
        while (right < fruits.length) {
            windows.put(fruits[right], windows.getOrDefault(fruits[right], 0) + 1);
            while (windows.size() >= 3) {
                int remove = fruits[left];
                windows.put(remove, windows.get(remove) - 1);
                if (windows.get(remove) == 0) {
                    windows.remove(remove);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
