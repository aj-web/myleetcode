package leetcode.array.doing;

import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.TimeUnit;

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
        System.out.println(stopWatch.getTime(TimeUnit.MICROSECONDS) + "毫秒");
    }
    
    
    public static boolean isAlienSorted(String[] words, String order) {
        for (int i = 1; i < words.length; i++) {
            String w1 = words[i];
            String w0 = words[i - 1];
            if (w1.length() < w0.length()) {
                return false;
            }
            for (int j = 0; j < w1.length(); j++) {
                if (j > w0.length() - 1) {
                    break;
                }
                if ((order.indexOf(w1.charAt(j)) < order.indexOf(w0.charAt(j)))) {
                    return false;
                }
                
            }
        }
        return true;
        
    }
    
}
