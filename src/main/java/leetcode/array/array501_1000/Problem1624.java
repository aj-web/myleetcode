package leetcode.array.array501_1000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 两个相同字符之间的最长子字符串
 *
 * @author : chezj
 * @date : 2022/9/17 23:44
 */
public class Problem1624 {
    
    public static void main(String[] args) {
        Problem1624 p = new Problem1624();
        System.out.println(p.maxLengthBetweenEqualCharacters2("mgntdygtxrvxjnwksqhxuxtrv"));
    }
    
    
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, List<Integer>> map = new HashMap<>(300);
        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.get(c).add(i);
            } else {
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(i);
                map.put(c, arrayList);
            }
        }
        int res = -1;
        for (Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            List<Integer> value = entry.getValue();
            if (value.size() >= 2) {
                res = Math.max(res, value.get(value.size() - 1) - value.get(0) - 1);
            }
        }
        return res;
    }
    
    
    public int maxLengthBetweenEqualCharacters1(String s) {
        Map<Character, Integer[]> map = new HashMap<>(300);
        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.get(c)[1] = i;
            } else {
                Integer[] ints = {i, -1};
                map.put(c, ints);
            }
        }
        int res = -1;
        for (Map.Entry<Character, Integer[]> entry : map.entrySet()) {
            Integer[] value = entry.getValue();
            if (value.length >= 2) {
                res = Math.max(res, value[1] - value[0] - 1);
            }
        }
        return res;
    }
    
    
    /**
     * 思想 直接利用26个字符统计出所有每个字母，继而算出所有字母的最大长度
     *
     * @param s
     * @return
     */
    public int maxLengthBetweenEqualCharacters2(String s) {
        int[] firstIndex = new int[26];
        Arrays.fill(firstIndex, -1);
        int maxLength = -1;
        for (int i = 0; i < s.length(); i++) {
            if (firstIndex[s.charAt(i) - 'a'] < 0) {
                firstIndex[s.charAt(i) - 'a'] = i;
            } else {
                maxLength = Math.max(maxLength, i - firstIndex[s.charAt(i) - 'a'] - 1);
            }
        }
        return maxLength;
    }
}
