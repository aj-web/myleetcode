package leetcode.array.doing;

import org.apache.commons.lang3.time.StopWatch;

import java.util.List;

/**
 * @author : chezj
 * @date : 2022/9/15 18:06
 */
public class Problem989 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem989  p = new Problem989();
        
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    
    public List<Integer> addToArrayForm(int[] num, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i : num) {
            sb.append(i);
        }
    
        int i = Integer.parseInt(sb.toString());
        
        String s = i+"";
        int[] ans = new int[s.length()];
        char[] chars = s.toCharArray();
        for (int c = 0; c < chars.length; c++) {
            ans[c] = chars[c];
        }
        
        return ans;
    }
    
}
