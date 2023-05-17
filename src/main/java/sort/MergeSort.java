package sort;

/**
 * @author chezhijun
 * @descririon 归并排序
 * @date 2021/11/11
 */
public class MergeSort {
    
    public static void main(String[] args) {
        int[] a = new int[] {3, 1, 6, 100, 22, 33, 2, 4, 7, 99, 88, 77};
        mergeSort(a, 0, a.length - 1);
    }
    
    /**
     * 归并排序
     *
     * @param arr
     * @param start
     * @param end
     */
    public static void mergeSort(int[] arr, int start, int end) {
        if (end - start > 0) {
            mergeSort(arr, start, start + (end - start) / 2);
            mergeSort(arr, start + (end - start) / 2 + 1, end);
            int left = start;
            int right = start + (end - start) / 2 + 1;
            int index = 0;
            int[] result = new int[end - start + 1];
            while (left <= start + (end - start) / 2 && right <= end) {
                if (arr[left] <= arr[right]) {
                    result[index] = arr[left];
                    left++;
                } else {
                    result[index] = arr[right];
                    right++;
                }
                index++;
            }
            
            //把左边剩余数和右边剩余数移入数组
            while (left <= start + (end - start) / 2 || right <= end) {
                if (left <= (start + end) / 2) {
                    result[index] = arr[left];
                    left++;
                } else {
                    result[index] = arr[right];
                    right++;
                }
                index++;
            }
            
            //最后将新的数据赋值给原来的列表，并且是对应分块后的下标。
            for (int i = start; i <= end; i++) {
                arr[i] = result[i - start];
            }
        }
    }
    
    
}
