package leetcode.array.array1_500;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author chezhijun
 * @descririon 寻找最接近的三数之和
 * @date 2021/8/18 TODO
 */
public class Problem16 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem16 p = new Problem16();
        int[] t1 = new int[] {0, 2, 1, -3};
        int i = p.threeSumClosest1(t1, 1);
        System.out.println(i);
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    /**
     * @Author ninan
     * @Description 采用于三数之后类似的逻辑，只不过需要判断接近这一条件
     * @Date 2021/8/19
     **/
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
        int abs = 10000;
        int result = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int p1 = i + 1;
            int p2 = nums.length - 1;
            
            while (p1 < p2) {
                int tar = nums[i] + nums[p1] + nums[p2];
                if (target == tar) {
                    return tar;
                } else if (tar > target) {
                    
                    if (Math.abs(tar - target) < abs) {
                        abs = Math.abs(tar - target);
                        result = nums[i] + nums[p1] + nums[p2];
                    }
                    
                    p2--;
                } else {
                    if (Math.abs(tar - target) < abs) {
                        abs = Math.abs(tar - target);
                        result = nums[i] + nums[p1] + nums[p2];
                    }
                    p1++;
                }
                
            }
        }
        return result;
    }
    
    
    /**
     * 暴力循环 时间复杂度n3。 超出时间限制
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest1(int[] nums, int target) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int total = nums[i] + nums[j] + nums[k];
                    resultMap.put(Math.abs(total - target), total);
                }
            }
        }
        Optional<Integer> integer = resultMap.entrySet().stream().min(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue);
        return integer.orElse(-1);
    }
    
    public int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        
        return (-1);
    }
}
