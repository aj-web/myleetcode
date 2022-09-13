package leetcode.array.Array501_1000;

import org.apache.commons.lang3.time.StopWatch;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : chezj
 * @date : 2022/9/5 17:22
 */
public class Problem953 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println(isAlienSorted(new String[] {"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    
    public static boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        for(int i = 0; i < words.length - 1; i++) {
            for(int j = 0; j < words[i].length(); j++) {
                if(j == words[i + 1].length()) {
                    return false;
                }
                int a = map.get(words[i].charAt(j)), b = map.get(words[i + 1].charAt(j));
                if(a > b) {
                    return false;
                } else if(a < b) {
                    break;
                }
            }
        }
        return true;
    }
    
}
