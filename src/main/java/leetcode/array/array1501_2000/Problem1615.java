package leetcode.array.array1501_2000;

import org.apache.commons.lang3.time.StopWatch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author : chezj
 * @date : 2023/3/15 17:42
 */
public class Problem1615 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem1615 p = new Problem1615();
        p.maximalNetworkRank(5, new int[][] {{0, 1}, {0, 3}, {1, 2}, {1, 3}, {2, 3}, {2, 4}});
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    public int maximalNetworkRank(int n, int[][] roads) {
        
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] road : roads) {
            for (int temp : road) {
                set.add(temp);
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        
        for (int i = 0; i < set.size(); i++) {
            for (int j = i + 1; j < set.size(); j++) {
            
            }
        }
        return 1;
    }
}
