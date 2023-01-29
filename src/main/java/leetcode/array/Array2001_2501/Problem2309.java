package leetcode.array.Array2001_2501;

import org.apache.commons.lang3.time.StopWatch;

/**
 * @author : chezj
 * @date : 2023/1/29 15:22
 */
public class Problem2309 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem2309 p = new Problem2309();
        System.out.println(p.greatestLetter("nzmguNAEtJHkQaWDVSKxRCUivXpGLBcsjeobYPFwTZqrhlyOIfdM"));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    public String greatestLetter(String s) {
        Character[] low = new Character[26];
        Character[] high = new Character[26];
        char[] array = s.toCharArray();
        for (char c : array) {
            if (c >= 97) {
                low[c - 'a'] = c;
            } else {
                high[c - 'A'] = c;
            }
        }
        for (int i = 25; i >= 0; i--) {
            if (low[i] != null && high[i] != null) {
                return high[i] + "";
            }
        }
        return "";
    }
    
    
}
