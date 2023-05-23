package leetcode.array.array501_1000;

import org.apache.commons.lang3.time.StopWatch;

/**
 * @author : chezj
 * @date : 2023/5/23 23:00
 */
public class Problem981 {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem981 p = new Problem981();

        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }


}

class TimeMap {

    String key;
    String value;
    Integer timestamp;

    public TimeMap() {

    }

    public void set(String key, String value, int timestamp) {
        this.key = key;
        this.value = value;
        this.timestamp = timestamp;
    }

    public String get(String key, int timestamp) {

    }
}
