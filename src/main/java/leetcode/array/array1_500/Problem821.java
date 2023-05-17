package leetcode.array.array1_500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 字符的最短距离
 *
 * @author : chezj
 * @date : 2022/8/29 21:38
 */
public class Problem821 {
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestToChar("aaab", 'b')));
    }
    
    /**
     * 4ms
     *
     * @param s
     * @param c
     * @return
     */
    public static int[] shortestToChar(String s, char c) {
        int[] res = new int[s.length()];
        Arrays.fill(res, s.length());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                res[i] = 0;
                list.add(i);
            }
            
        }
        for (Integer in : list) {
            for (int i = 0; i < res.length; i++) {
                res[i] = Math.min(res[i], Math.abs(in - i));
            }
        }
        return res;
    }
    
    
    /**
     * 两次遍历 @TODO
     *
     * @param s
     * @param c
     * @return
     */
    public static int[] shortestToChar1(String s, char c) {
        int[] res = new int[s.length()];
        Arrays.fill(res, s.length());
        
        for (int i = 0, j = -1; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                j = i;
            }
            if (j != -1) {
                res[i] = i - j;
            }
        }
        
        for (int i = s.length() - 1, j = -1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                j = i;
            }
            if (j != -1) {
                res[i] = Math.min(res[i], j - i);
            }
        }
        return res;
    }
}
