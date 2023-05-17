package leetcode.array.array1501_2000;

import org.apache.commons.lang3.time.StopWatch;

import java.util.HashSet;

/**
 * @author : chezj
 * @date : 2022/11/8 22:59
 */
public class Problem1684 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem1684 p = new Problem1684();
        System.out.println(p.countConsistentStrings1("fstqyienx",
                new String[] {"n", "eeitfns", "eqqqsfs", "i", "feniqis", "lhoa", "yqyitei", "sqtn", "kug", "z",
                        "neqqis"}));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> dict = new HashSet<>(allowed.length());
        
        for (char c : allowed.toCharArray()) {
            dict.add(c);
        }
        int res = words.length;
        for (String word : words) {
            char[] charArray = word.toCharArray();
            for (char c : charArray) {
                if (!dict.contains(c)) {
                    res--;
                    break;
                }
            }
        }
        return res;
    }
    
    /**
     * 字符串判断直接new boolean[26]
     *
     * @param allowed
     * @param words
     * @return
     */
    public int countConsistentStrings1(String allowed, String[] words) {
        boolean[] dict = new boolean[26];
        for (char c : allowed.toCharArray()) {
            dict[c - 'a'] = true;
        }
        int res = words.length;
        for (String word : words) {
            char[] charArray = word.toCharArray();
            for (char c : charArray) {
                if (!dict[c - 'a']) {
                    res--;
                    break;
                }
            }
        }
        return res;
    }
    
}
