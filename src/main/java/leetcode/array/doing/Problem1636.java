package leetcode.array.doing;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/**按照频率将数组升序排序
 * @author : chezj
 * @date : 2022/9/19 17:43
 */
public class Problem1636 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem1636 p = new Problem1636();
        System.out.println(Arrays.toString(p.frequencySort(new int[] {1, 1, 2, 2, 2, 3,3,3})));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    
    public int[] frequencySort(int[] nums) {
        
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i : nums) {
            list.add(i);
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        //重写比较器，比较器结果为0，则不交换，如果为负数则不交换，如果为正数，则需要交换
        list.sort((o1, o2) -> {
            int i1 = map.get(o1);
            int i2 = map.get(o2);
            if (i1 == i2) {
                return o2 - o1;
            }
            return i1 - i2;
        });
        
        return list.stream().mapToInt(Integer::intValue).toArray();
        
    }
    
    
    /*public int[] InsertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            //外层循环，从第二个开始比较
            for (int j = i; j > 0; j--) {
                //内存循环，与前面排好序的数据比较，如果后面的数据小于前面的则交换
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                } else {
                    //如果不小于，说明插入完毕，退出内层循环
                    break;
                }
            }
        }
        return arr;
    }*/
    
}
