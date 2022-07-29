package leetcode.array.doing;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode:76最小覆盖子串
 */
public class Problem76 {
    public static void main(String[] args) {

    }


    public String minWindow(String s, String t) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        int left = 0, right = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i),0) + 1);
        }

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c,0) + 1);
                valid++;
            }

            while (valid == need.size()){
                if (right-left<len){
                    start =left;
                    len = right-left;
                }


            }

        }


    }
}
