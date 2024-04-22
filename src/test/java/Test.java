import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : chezj
 * @date : 2024/3/15 9:50
 */
public class Test {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Test p = new Test();

        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }


    public int[] LIS(int[] arr) {
        // write code here
        int[] res = new int[0];

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.add(temp);
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] > arrayList.get(arrayList.size() - 1)) {
                    arrayList.add(arr[j]);
                }
            }
            list.add(arrayList);
        }

        int max = 0;
        for (List<Integer> integers : list) {
            if (integers.size() > max) {
                max = integers.size();
            }
        }


        for (List<Integer> integers : list) {
            if (integers.size() == max) {
                res = new int[integers.size()];
                for (int i = 0; i < integers.size(); i++) {
                    res[i] = integers.get(i);
                }
                return res;
            }
        }

        return res;
    }

}
