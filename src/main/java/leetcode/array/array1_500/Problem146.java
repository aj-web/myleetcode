package leetcode.array.array1_500;

import org.apache.commons.lang3.time.StopWatch;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU缓存
 *
 * @author : chezj
 * @date : 2023/2/9 16:46
 */
public class Problem146 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem146 p = new Problem146();
        
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    
}


class LRUCache {
    
    int cap;
    
    Map<Integer, Integer> map;
    
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.map = new LinkedHashMap<>(capacity);
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return map.get(key);
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.put(key, value);
            makeRecently(key);
            return;
        }
        
        if (map.size() >= cap) {
            Integer head = map.keySet().iterator().next();
            map.remove(head);
        }
        map.put(key, value);
        
    }
    
    //队尾
    public void makeRecently(Integer key) {
        Integer val = map.get(key);
        map.remove(key);
        map.put(key, val);
    }
}
