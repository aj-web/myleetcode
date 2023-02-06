package leetcode.array.Array1001_1500;

import org.apache.commons.lang3.time.StopWatch;

import java.util.List;

/**
 * 可被 5 整除的二进制前缀
 *
 * @author : chezj
 * @TODO
 * @date : 2023/2/5 13:15
 */
public class Problem1018 {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem1018 p = new Problem1018();

        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }


    public List<Boolean> prefixesDivBy5(int[] nums) {

        int length = nums.length;

        for (int i = length - 1; i >= 0; i--) {
            int temp = nums[i] * 2;
        }

        return null;
    }

}
