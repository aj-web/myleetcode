package leetcode.array.Array2001_2501;

import org.apache.commons.lang3.time.StopWatch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 最好的扑克手牌
 *
 * @author : chezj
 * @date : 2023/2/20 14:08
 */
public class Problem2347 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem2347 p = new Problem2347();
        
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    
    public String bestHand(int[] ranks, char[] suits) {
        Set<Character> set = new HashSet<>(suits.length);
        for (char c : suits) {
            set.add(c);
        }
        if (set.size() == 1) {
            return "Flush";
        }
        
        Map<Integer, Integer> map = new HashMap<>(ranks.length);
        for (int i = 0; i < ranks.length; i++) {
            map.put(ranks[i], map.getOrDefault(ranks[i], 0) + 1);
        }
        
        if (map.size() == 5) {
            return "High Card";
        }
        if (map.size() == 4) {
            return "Pair";
        }
        if (map.size() <= 3) {
            for (Integer value : map.values()) {
                if (value >= 3) {
                    return "Three of a Kind";
                }
            }
            return "Pair";
        }
        return null;
    }
    
}
