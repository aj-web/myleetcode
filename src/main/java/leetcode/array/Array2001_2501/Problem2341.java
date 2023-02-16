package leetcode.array.Array2001_2501;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 14411
 *
 * @author : chezj
 * @date : 2023/2/16 11:33
 */
public class Problem2341 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem2341 p = new Problem2341();
        System.out.println(Arrays.toString(p.numberOfPairs(new int[] {1, 3, 2, 1, 3, 2, 2})));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    /**
     * 写的有些复杂了 不用在乎数量直接用奇偶判断即可 也就是 Map<Integer,Boolean>
     *
     * @param nums
     * @return
     */
    public int[] numberOfPairs(int[] nums) {
        int[] ans = new int[] {0, 1};
        int length = nums.length;
        if (length == 1) {
            return ans;
        }
        HashMap<Integer, ArrayList<Integer>> map = new HashMap(length);
        for (int i = 0; i < length; i++) {
            if (!map.containsKey(nums[i])) {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(nums[i], temp);
            } else {
                map.get(nums[i]).add(i);
            }
        }
        ans[1] = 0;
        map.values().forEach(e -> {
            int i = e.size() / 2;
            int j = e.size() % 2;
            if (j == 0) {
                ans[0] += i;
            } else {
                ans[0] += i;
                ans[1] += 1;
            }
            
        });
        
        return ans;
    }
    
    public int[] numberOfPairs1(int[] nums) {
        Map<Integer, Boolean> cnt = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            cnt.put(num, !cnt.getOrDefault(num, false));
            if (!cnt.get(num)) {
                res++;
            }
        }
        return new int[] {res, nums.length - 2 * res};
    }
    
}
