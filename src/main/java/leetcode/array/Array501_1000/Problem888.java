package leetcode.array.Array501_1000;

import java.util.HashSet;
import java.util.Set;

/**
 * 公平的糖果交换
 *
 * @author : chezj
 * @date : 2022/8/30 22:15
 */
public class Problem888 {

    public static void main(String[] args) {

    }

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int countA = 0;
        for (int aliceSize : aliceSizes) {
            countA+=aliceSize;
        }

        int countB = 0;
        for (int bobSize : bobSizes) {
            countB+=bobSize;
        }

        int half = (countA-countB)/2;

        Set<Integer> set = new HashSet<>();
        for (int aliceSize : aliceSizes) {
            set.add(aliceSize);
        }

        for (int bobSize : bobSizes) {
            if (set.contains(bobSize+half)){
                return new int[]{bobSize+half,bobSize};
            }
        }

        return null;
    }
}
