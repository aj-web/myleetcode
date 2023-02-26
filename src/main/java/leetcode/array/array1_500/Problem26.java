package leetcode.array.array1_500;

import org.apache.commons.lang3.time.StopWatch;

/**
 * @author chezhijun
 * @descririon 删除有序数组中的重复项
 * @date 2021/11/6
 * AC
 */
public class Problem26 {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem26 p = new Problem26();
        System.out.println(p.removeDuplicates1(new int[]{1, 1, 2}));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }


    /**
     * 快慢指针 直接秒杀
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }


    public int removeDuplicates1(int[] nums) {
        int fast = 0;
        int slow = 0;

        while (fast < nums.length) {

            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow+1;
    }

}
