package leetcode.array.Array501_1000;

import org.apache.commons.lang3.time.StopWatch;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 删列造序
 *
 * @author : chezj
 * @date : 2022/9/5 14:29
 */
public class Problem944 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println(minDeletionSize(new String[] {"zyx", "wvu", "tsr"}));
        stopWatch.stop();
        System.out.println(stopWatch.getTime(TimeUnit.MICROSECONDS) + "毫秒");
    }
    
    
    public static int minDeletionSize(String[] strs) {
        int m = strs.length;
        int n = strs[0].length();
        Set<Integer> ans = new HashSet<>();
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                if (ans.contains(j)) {
                    continue;
                }
                if (strs[i].charAt(j) > strs[i + 1].charAt(j)) {
                    ans.add(j);
                }
            }
        }
        return ans.size();
    }
    
    
    /**
     * 换一种遍历方法
     *
     * @param strs
     * @return
     */
    public static int minDeletionSize1(String[] strs) {
        int m = strs.length;
        int n = strs[0].length();
        int res = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (strs[j].charAt(i) < strs[j - 1].charAt(i)) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}
