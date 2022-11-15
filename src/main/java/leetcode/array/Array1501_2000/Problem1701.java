package leetcode.array.Array1501_2000;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;

/**
 * @author : chezj
 * @date : 2022/11/15 22:33
 */
public class Problem1701 {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem1701 p = new Problem1701();
        System.out.println(p.maximumUnits(new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}}, 10));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }

    /**
     * @param boxTypes
     * @param truckSize
     * @return
     */
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int m = boxTypes.length;

        Arrays.sort(boxTypes, (o1, o2) -> o2[1] - o1[1]);

        int box = 0;
        int per = 0;
        int index = 0;
        while (index < m) {
            box += boxTypes[index][0];
            per += boxTypes[index][0] * boxTypes[index][1];
            if (box > truckSize) {
                per = per - boxTypes[index][0] * boxTypes[index][1];
                box = box - boxTypes[index][0];
                per += (truckSize - box) * boxTypes[index][1];
                return per;
            }
            if (box == truckSize) {
                return per;
            }
            index++;
        }


        return per;
    }

    public int maximumUnits1(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> o2[1] - o1[1]);
        int res = 0;

        for (int[] boxType : boxTypes) {
            int numberOfBoxes = boxType[0];
            int numberOfUnitsPerBox = boxType[1];
            if (numberOfBoxes < truckSize) {
                res += numberOfBoxes * numberOfUnitsPerBox;
                truckSize -= numberOfBoxes;
            } else {
                res += truckSize * numberOfUnitsPerBox;
                break;
            }
        }
        return res;
    }
}
