package sort;

/**
 * @author chezhijun
 * @descririon 插入排序
 * @date 2022/3/14
 */
public class InsertSort {
    
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int[] nums = new int[] {1, 3, 2, 4, 5, 67, 4, 6, 3, 5, 34, 4};
        insertionSort2(nums);
        long costTime = System.nanoTime() - startTime;
        System.out.println(costTime);
    }
    
    public static int[] insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
    
    public static int[] insertionSort2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            int temp = nums[i];
            while (j > 0 && nums[j] < nums[j - 1]) {
                nums[j] = nums[j - 1];
                j--;
            }
            if (j != i) {
                nums[j] = temp;
            }
        }
        return nums;
    }
}
