package leetcode.array.Array1001_1500;

import org.apache.commons.lang3.time.StopWatch;

/**
 * 将数组分成和相等的三个部分 遇到数据求和可以考虑前缀和
 *
 * @author : chezj
 * @date : 2022/10/27 10:53
 */
public class Problem1013 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem1013 p = new Problem1013();
        
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    public boolean canThreePartsEqualSum(int[] arr) {
        int len = arr.length;
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        if (sum % 3 != 0) {
            return false;
        }
        int[] fSum = new int[len];
        fSum[0] = arr[0];
        for (int i = 1; i < len; i++) {
            fSum[i] = fSum[i - 1] + arr[i];
        }
        for (int i = 0; i < len; i++) {
            if (fSum[i] == sum / 3) {
                for (int j = i + 1; j < len - 1; j++) {
                    if (fSum[j] == sum / 3 * 2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
}
