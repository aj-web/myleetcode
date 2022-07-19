package leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * LeetCode354:俄罗斯套娃信问题
 * 数组
 * 涉及二分查找和动态规划
 */
public class Problem354 {

    public static void main(String[] args) {
        int[][] a = new int[][]{{5,4},{6,4},{6,7},{1,1}};
        int i = maxEnvelopesViolent(a);
        System.out.println("end");
    }


    public static int maxEnvelopesViolent(int[][] envelopes) {
        if(envelopes.length==1){
            return 1;
        }
        int maxResult = 0;
        int Result = 0;
        for (int i = 0; i < envelopes.length; i++) {
            Arrays.sort(envelopes, (a, b) -> a[0] == b[0]? a[1]-b[1]:a[0]-b[0]);


            maxResult = Math.max(Result,maxResult);
        }

        return maxResult;
    }
}
