package leetcode.array.doing;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : chezj
 * @date : 2022/8/31 17:42
 */
public class Problem914 {
    
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length == 0) {
            return true;
        }
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i : deck) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        Integer tag = map.get(deck[0]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() < 2) {
                return false;
            }
            if (!(entry.getValue() % tag == 0) && !(tag % entry.getValue() == 0)) {
                return false;
            }
        }
        return true;
    }
    
}
