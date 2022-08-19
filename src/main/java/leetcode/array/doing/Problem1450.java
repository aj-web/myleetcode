package leetcode.array.doing;

/**
 * @author : chezj
 * @date : 2022/8/19 17:13
 */
public class Problem1450 {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int n = endTime.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (endTime[i]>= queryTime && startTime[i]<=queryTime){
                    count++;
            }
        }
        return count;
    }
}
