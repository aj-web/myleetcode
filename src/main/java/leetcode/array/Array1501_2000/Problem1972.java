package leetcode.array.Array1501_2000;

import org.apache.commons.lang3.time.StopWatch;

import java.util.PriorityQueue;

/**
 * @author : chezj 最大平均通过率
 * @date : 2023/2/20 14:41
 */
public class Problem1972 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem1972 p = new Problem1972();
        
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    /**
     * 使用优先队列 计算最大平均通过率也就是，求每个班级的平均通过提升率从大到小排序
     *
     * @param classes
     * @param extraStudents
     * @return
     */
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> {
            double res1 = (a[0] + 1) / (a[1] + 1) - a[0] / a[1];
            double res2 = (b[0] + 1) / (b[1] + 1) - b[0] / b[1];
            return Double.compare(res2, res1);
        });
        
        for (int[] ints : classes) {
            pq.offer(new double[] {ints[0], ints[1]});
        }
        
        while (extraStudents-- > 0) {
            double[] poll = pq.poll();
            pq.offer(new double[] {poll[0] + 1, poll[1] + 1});
        }
        
        double ans = 0;
        while (!pq.isEmpty()) {
            double[] doubles = pq.poll();
            ans += doubles[0] / doubles[1];
        }
        return ans / classes.length;
    }
}
