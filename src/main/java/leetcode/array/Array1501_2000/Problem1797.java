package leetcode.array.Array1501_2000;

import org.apache.commons.lang3.time.StopWatch;

import java.util.HashMap;
import java.util.Map;

/**
 * 设计一个验证系统
 *
 * @author : chezj
 * @date : 2023/2/9 14:46
 */
public class Problem1797 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem1797 p = new Problem1797();
        
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    
}

class AuthenticationManager {
    
    int timeToLive;
    
    Map<String, Integer> map;
    
    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.map = new HashMap<>();
    }
    
    /**
     * 创建token，直接put就好。
     *
     * @param tokenId
     * @param currentTime
     */
    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime + timeToLive);
    }
    
    /**
     * 刷新toke时间，在存在此token且未过期时才刷新，否者直接删除即可。
     *
     * @param tokenId
     * @param currentTime
     */
    public void renew(String tokenId, int currentTime) {
        map.computeIfPresent(tokenId, (k, v) -> (v > currentTime ? currentTime + timeToLive : null));
    }
    
    /**
     * 获取某一时刻的有效token数量，迭代将过期token移除，返回map数量即可。
     *
     * @param currentTime
     * @return
     */
    public int countUnexpiredTokens(int currentTime) {
        map.values().removeIf(time -> time <= currentTime);
        return map.size();
    }
}
