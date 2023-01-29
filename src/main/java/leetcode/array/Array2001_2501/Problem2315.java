package leetcode.array.Array2001_2501;

import org.apache.commons.lang3.time.StopWatch;

/**
 * @author : chezj
 * @date : 2023/1/29 14:18
 */
public class Problem2315 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem2315 p = new Problem2315();
        System.out.println(p.countAsterisks2("l|*e*et|c**o|*de|"));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    public int countAsterisks(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        int total = 0;
        for (int i = 0; i < chars.length; i++) {
            
            if (total == 0 && chars[i] == '*') {
                res++;
            }
            
            if (chars[i] == '|') {
                total++;
            }
            
            if (total != 0 && (total & 1) == 0) {
                if (chars[i] == '*') {
                    res++;
                }
            }
        }
        return res;
    }
    
    /**
     * 代码优化
     *
     * @param s
     * @return
     */
    public int countAsterisks1(String s) {
        int res = 0;
        boolean valid = true;
        for (int i = 0; i < s.length(); i++) {
            if (valid && s.charAt(i) == '*') {
                res++;
            }
            if (s.charAt(i) == '|') {
                valid = !valid;
            }
        }
        return res;
    }
    
    
    /**
     * 空间最优解法
     *
     * @param s
     * @return
     */
    public int countAsterisks2(String s) {
        return s.replaceAll("\\|.*?\\||[^*]", "").length();
    }
    
}
