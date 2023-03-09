package leetcode.array.array1001_1500;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author : chezj
 * @date : 2023/3/3 14:36
 */
public class Problem1487 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem1487 p = new Problem1487();
        System.out.println(Arrays.toString(p.getFolderNames(new String[] {"wano", "wano", "wano(1)", "wano(1)"})));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> index = new HashMap<>();
        int n = names.length;
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            String name = names[i];
            if (!index.containsKey(name)) {
                res[i] = name;
                index.put(name, 1);
            } else {
                int k = index.get(name);
                while (index.containsKey(addSuffix(name, k))) {
                    k++;
                }
                res[i] = addSuffix(name, k);
                index.put(name, k + 1);
                index.put(addSuffix(name, k), 1);
            }
        }
        return res;
    }
    
    public String addSuffix(String name, int k) {
        return name + "(" + k + ")";
    }
    
    public String[] getFolderNames1(String[] names) {
        Set<String> set = new HashSet<>(names.length);
        for (int i = 0; i < names.length; i++) {
            String s = names[i];
            if (set.contains(s)) {
                //拼装下一个key
                String next = getNext(s);
                while (set.contains(next)) {
                    next = getNext(next);
                }
                names[i] = next;
                set.add(next);
            } else {
                set.add(s);
            }
        }
        return names;
    }
    
    private String getNext(String s) {
        String next = "";
        int parseInt = 0;
        int head = s.indexOf("(");
        int tail = s.indexOf(")");
        if (head != -1) {
            parseInt = Integer.parseInt(s.substring(head + 1, tail));
        }
        if (parseInt == 0) {
            parseInt++;
            next = s + "(" + parseInt + ")";
        } else {
            int newInt = parseInt + 1;
            next = s.replace(parseInt + "", newInt + "");
        }
        return next;
    }
}
