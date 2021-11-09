package leetcode.array;

/**
 * @author chezhijun
 * @descririon 有序数组的平方
 * @date 2021/11/9
 */
public class Problem977 {
    public static void main(String[] args) {
        int[] a = new int[]{-4,-1,0,3,10};
        int[] squares = sortedSquares1(a);
        System.out.println(squares);
    }

    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length ; i++) {
            result[i] = nums[i] * nums[i];
        }

        //插入排序
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (result[j] < result[j-1]) {
                    int temp = result[j];
                    result[j] = result[j-1];
                    result[j-1] = temp;
                } else {
                    break;
                }

            }
        }

        return result;
    }


    /**
     * 优化1 插入排序
     * @param nums  379ms  5.66%
     * @return
     */
    public static int[] sortedSquares1(int[] nums) {

        nums[0]= nums[0]*nums[0];
        //插入排序
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i]*nums[i];
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j-1]) {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                } else {
                    break;
                }

            }
        }

        return nums;
    }

    /**
     * 优化2 归并排序 6ms  9.34%
     * @param nums
     * @return
     */
    public static int[] sortedSquares2(int[] nums) {

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length ; i++) {
            result[i] = nums[i] * nums[i];
        }

        return mergeSort(result,0, result.length-1);

    }

    public static int[] mergeSort(int[] arr, int start, int end) {
        //判断拆分的不为最小单位
        if (end - start > 0) {
            //再一次拆分，知道拆成一个一个的数据
            mergeSort(arr, start, (start + end) / 2);
            mergeSort(arr, (start + end) / 2 + 1, end);
            //记录开始/结束位置
            int left = start;
            int right = (start + end) / 2 + 1;
            //记录每个小单位的排序结果
            int index = 0;
            int[] result = new int[end - start + 1];
            //如果查分后的两块数据，都还存在
            while (left <= (start + end) / 2 && right <= end) {
                //比较两块数据的大小，然后赋值，并且移动下标
                if (arr[left] <= arr[right]) {
                    result[index] = arr[left];
                    left++;
                } else {
                    result[index] = arr[right];
                    right++;
                }
                //移动单位记录的下标
                index++;
            }
            //当某一块数据不存在了时
            while (left <= (start + end) / 2 || right <= end) {
                //直接赋值到记录下标
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
        return arr;
    }
}
