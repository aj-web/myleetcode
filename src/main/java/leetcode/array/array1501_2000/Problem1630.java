package leetcode.array.array1501_2000;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 等差子数组
 *
 * @author : chezj
 * @date : 2023/3/23 14:21
 */
public class Problem1630 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem1630 p = new Problem1630();
        System.out.println(
                p.checkArithmeticSubarrays(new int[] {4, 6, 5, 9, 3, 7}, new int[] {0, 0, 2}, new int[] {2, 3, 5}));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    //添加缓存 [a,b]为true，则[c,d]是子集必是true
    
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = l.length;
        List<Boolean> ans = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int left = l[i];
            int right = r[i];
            int[] temp = new int[right - left + 1];
            for (int k = left; k <= right; k++) {
                temp[k - left] = nums[k];
            }
            ans.add(arrayJudge(temp));
        }
        
        return ans;
    }
    
    private Boolean arrayJudge(int[] temp) {
        Arrays.sort(temp);
        int m = temp.length;
        int val = temp[m - 1] - temp[m - 2];
        for (int i = 0; i < m - 1; i++) {
            if (temp[i] + val != temp[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
