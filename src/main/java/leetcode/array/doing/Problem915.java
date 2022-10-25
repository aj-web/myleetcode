package leetcode.array.doing;

import org.apache.commons.lang3.time.StopWatch;

/**
 * 分割数组
 *
 * @author : chezj
 * @date : 2022/10/24 13:51
 */
public class Problem915 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem915 p = new Problem915();
        System.out.println(p.partitionDisjoint(new int[] {24, 11, 49, 80, 63, 8, 61, 22, 73, 85}));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    /**
     * 1.从左往右遍历，维护一个最大值，遍历过程中发现有比最大值大的数
     * 2.则从当前最大值进行第二次遍历，[max,num.length-1] 如果这个范围有数比上一个最大值temp小，则从当前i继续往下遍历
     * 3.否则返回i
     *
     * @param nums
     * @return
     */
    public int partitionDisjoint(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            if (nums[i] >= max) {
                max = nums[i];
                if (i + 1 == nums.length) {
                    return i;
                }
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] < temp) {
                        break;
                    }
                    if (j == nums.length - 1) {
                        return i;
                    }
                }
                
            }
            
        }
        return -1;
    }
    
    
}
