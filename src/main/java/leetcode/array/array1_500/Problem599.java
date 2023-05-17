package leetcode.array.array1_500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode两个列表最小索引总和
 */
public class Problem599 {
    
    public static void main(String[] args) {
        int i = "Shogun".hashCode();
        System.out.println(i);
    }
    
    public String[] findRestaurant(String[] list1, String[] list2) {
        
        Map<String, Integer> map1 = new HashMap<>(list1.length);
        for (int i = 0; i < list1.length; i++) {
            map1.put(list1[i], i);
        }
        List<String> res = new ArrayList<>();
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            
            if (map1.containsKey(list2[i])) {
                int temp = map1.get(list2[i]) + i;
                if (temp < count) {
                    count = map1.get(list2[i]) + i;
                    res.clear();
                    res.add(list2[i]);
                } else if (temp == count) {
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
