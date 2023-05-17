package leetcode.array.array1_500;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * LeetCode49：字母异位次分组
 */
public class Problem49 {
    
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (String str : strs) {
            String s = deCode(str);
            result.putIfAbsent(s, new LinkedList<>());
            result.get(s).add(str);
        }
        
        List<List<String>> end = new LinkedList<>();
        for (List<String> value : result.values()) {
            end.add(value);
        }
        
        return end;
        
    }
    
    public static String deCode(String s) {
        char[] count = new char[26];
        for (char c : s.toCharArray()) {
            int delta = c - 'a';
            count[delta]++;
        }
        
        return new String(count);
    }
}
