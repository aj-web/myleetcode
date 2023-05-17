package sort;

/**
 * @author chezhijun
 * @Descririon: 冒泡排序
 * @date 2022/4/5
 */
public class BubSort {
    
    public static void main(String[] args) {
        int[] a = new int[10];
    }
    
    public static int[] BubSort(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[i];
                    nums[i] = nums[i + 1];
                    nums[i + 1] = temp;
                }
            }
        }
        return nums;
    }
}
