package leetcode.array.array1_500;

import java.util.Arrays;

/**
 * @author chezhijun
 * @descririon 寻找最接近的三数之和
 * @date 2021/8/18 TODO
 */
public class Problem16 {
    
    public static void main(String[] args) {
        int[] t1 = new int[] {0, 2, 1, -3};
        System.out.println(threeSumClosest(t1, 1));
    }
    
    /**
     * @Author ninan
     * @Description 采用于三数之后类似的逻辑，只不过需要判断接近这一条件
     * @Date 2021/8/19
     **/
    public static int threeSumClosest(int[] nums, int target) {
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
}
