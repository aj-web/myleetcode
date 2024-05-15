import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : chezj
 * @date : 2024/3/18 12:51
 */
public class Test3 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Test3 p = new Test3();
        //        p.bubbleSorting(new int[] {3, 5, 6, 7, 1, 2});
        //        p.selectSorting(new int[] {3, 5, 6, 7, 1, 2});
        //        System.out.println(p.Recursion(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15), 0,
        //        7));
        //        System.out.println(p.recursion(10, 0));
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(1);
        System.out.println(p.recursion(arrayList, 3));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    
    public void bubbleSorting(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        System.out.println("success");
    }
    
    
    public void selectSorting(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int index = i;
            
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    index = j;
                }
            }
            
            int temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
        }
        System.out.println("success");
    }
    
    
    public int Recursion(List<Integer> monkeys, int start, int target) {
        if (monkeys.size() == 1) {
            return monkeys.get(0);
        }
        
        // 计算要移除的猴子的索引
        int removeIndex = (start + target - 1) % monkeys.size();
        monkeys.remove(removeIndex);
        
        // 计算下一次开始的索引，即当前移除索引的位置，因为列表已缩减一个元素
        start = removeIndex % monkeys.size();
        
        // 递归调用
        return Recursion(monkeys, start, target);
    }
    
    //    public int recursion(int i, int total) {
    //        if (i == 0) {
    //            return total;
    //        }
    //        total = total + i;
    //        i--;
    //        return recursion(i, total);
    //    }
    
    public int recursion(ArrayList<Integer> nums, int n) {
        if (n <= 0) {
            return 0;
        }
        if (nums.size() - 2 == n) {
            return nums.get(n + 2 - 1);
        }
        nums.add(nums.get(nums.size() - 1) + nums.get(nums.size() - 2));
        
        return recursion(nums, n);
    }
}
