package leetcode.array.array501_1000;

import org.apache.commons.lang3.time.StopWatch;

import java.util.HashSet;

/**
 * @author : chezj
 * @date : 2022/9/8 17:46
 */
public class Problem961 {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem961 p = new Problem961();
        System.out.println(p.repeatedNTimes(new int[]{1, 2, 3, 2}));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }


    public int repeatedNTimes(int[] nums) {
        HashSet<Integer> set = new HashSet<>(nums.length / 2 + 2);
        for (int i = 0; i < nums.length; i++) {
            while (!set.contains(nums[i])) {
                set.add(nums[i]);
                i++;
            }
            return nums[i];
        }
        return -1;
    }
}
