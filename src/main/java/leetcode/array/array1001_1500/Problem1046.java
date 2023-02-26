package leetcode.array.array1001_1500;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 最后一块石头的重量
 *
 * @author : chezj
 * @date : 2022/10/27 14:37
 */
public class Problem1046 {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem1046 p = new Problem1046();
        p.lastStoneWeight(new int[]{1, 1});
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }

    public int lastStoneWeight(int[] stones) {
        if (stones.length == 1) {
            return stones[0];
        }
        int[] ints = lastStone(stones);
        return ints[0];
    }

    public int[] lastStone(int[] ints) {
        Arrays.sort(ints);
        if (ints.length < 2) {
            return ints;
        }
        ints[ints.length - 2] = ints[ints.length - 1] - ints[ints.length - 2];
        int[] temp = new int[ints.length - 1];
        System.arraycopy(ints, 0, temp, 0, ints.length - 1);
        return lastStone(temp);
    }

    /**
     * 使用堆排序
     *
     * @param stones
     * @return
     */
    public int lastStoneWeight1(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int stone : stones) {
            pq.offer(stone);
        }
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a > b) {
                pq.offer(a - b);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
