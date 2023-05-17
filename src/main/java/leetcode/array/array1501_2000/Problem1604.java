package leetcode.array.array1501_2000;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : chezj
 * @date : 2023/2/10 16:06
 */
public class Problem1604 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem1604 p = new Problem1604();
        System.out.println(p.alertNames(new String[] {"alice", "alice", "alice", "bob", "bob", "bob", "bob"},
                new String[] {"12:01", "12:00", "18:00", "21:00", "21:20", "21:30", "23:00"}));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> result = new ArrayList<>();
        Map<String, List<Integer>> tempMap = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            tempMap.putIfAbsent(name, new ArrayList<>());
            int hour = (time.charAt(0) - '0') * 10 + (time.charAt(1) - '0');
            int min = (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
            tempMap.get(name).add(hour * 60 + min);
        }
        for (String key : tempMap.keySet()) {
            List<Integer> list = tempMap.get(key);
            int size = list.size();
            Collections.sort(list);
            for (int i = 2; i < size; i++) {
                int time1 = list.get(i - 2);
                int time2 = list.get(i);
                int difference = time2 - time1;
                if (difference <= 60) {
                    result.add(key);
                    break;
                }
            }
        }
        Collections.sort(result);
        return result;
    }
}
