package sort;

/**
 * @author chezhijun
 * @descririon 冒泡排序
 * @date 2022/4/1
 */
public class bubbleSort {
    
    public static void main(String[] args) {
        int[] a = new int[] {1, 3, 5, 6, 7, 4, 22, 104, 33, 35};
        int[] bubbleSort = bubbleSort(a);
        System.out.println(bubbleSort);
    }
    
    
    /**
     * 冒泡排序
     *
     * @param target
     * @return
     */
    public static int[] bubbleSort(int[] target) {
        for (int i = 0; i < target.length - 1; i++) {
            for (int j = 0; j < target.length - 1 - i; j++) {
                if (target[j] > target[j + 1]) {
                    int temp = target[j];
                    target[j] = target[j + 1];
                    target[j + 1] = temp;
                }
            }
        }
        return target;
    }
}
