package leetcode.array.doing;

import org.apache.commons.lang3.time.StopWatch;

/**
 * 无法吃午餐的学生的数量
 *
 * @author : chezj
 * @date : 2022/10/19 22:28
 */
public class Problem1700 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem1700 p = new Problem1700();
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    
    public int countStudents(int[] students, int[] sandwiches) {
        int[] count = new int[2];
        for (int i = 0; i < students.length; i++) {
            count[students[i]]++;
        }
        for (int sandwich : sandwiches) {
            if (count[sandwich] == 0) {
                return count[0] + count[1];
            }
            count[sandwich]--;
        }
        return 0;
    }
}
