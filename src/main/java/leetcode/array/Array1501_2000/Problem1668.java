package leetcode.array.Array1501_2000;

import org.apache.commons.lang3.time.StopWatch;

/**
 * @author : chezj
 * @date : 2022/11/3 17:15
 */
public class Problem1668 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem1668 p = new Problem1668();
        System.out.println(p.maxRepeating("aaaba aaaba aabaa aaba aaaba aaaba aaaba", "aaaba"));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    public int maxRepeating(String sequence, String word) {
        int len = sequence.length();
        int s = word.length();
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (s + i - 1 >= len) {
                break;
            }
            String substring = sequence.substring(i, i + s);
            if (substring.contains(word)) {
                ans++;
                i = i + s - 1;
            }
            System.out.println(substring);
        }
        return ans;
    }
    
}
