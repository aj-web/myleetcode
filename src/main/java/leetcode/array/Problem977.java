package leetcode.array;

/**
 * @author chezhijun
 * @descririon 有序数组的平方
 * @date 2021/11/9
 */
public class Problem977 {
    public static void main(String[] args) {
        int[] a = new int[]{-7, -3, 2, 3, 11};
        int[] squares = sortedSquares4(a);
        System.out.println(squares);
    }


    /**
     * 优化1 插入排序
     *
     * @param nums 379ms  5.66%
     * @return
     */
    public static int[] sortedSquares1(int[] nums) {

        nums[0] = nums[0] * nums[0];
        //插入排序
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = temp;
                } else {
                    break;
                }

            }
        }

        return nums;
    }


    /**
     * 优化2 归并排序 6ms  9.34%
     *
     * @param nums
     * @return
     */
    public static int[] sortedSquares2(int[] nums) {

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] * nums[i];
        }


        return mergeSort(result, 0, result.length - 1);

    }

    /**
     * 归并排序
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    public static int[] mergeSort(int[] arr, int start, int end) {
        //判断拆分的不为最小单位
        if (end - start > 0) {
            //再一次拆分，知道拆一个一个的数据
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


    /**
     * 优化3 快速排序
     *
     * @param nums
     * @return
     */
    public static int[] sortedSquares3(int[] nums) {

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] * nums[i];
        }

        quickSort(result, 0, result.length - 1);
        return result;

    }

    /**
     * 快排
     *
     * @param arr
     * @param low
     * @param high
     */
    public static void quickSort(int[] arr, int low, int high) {
        //如果指针在同一位置(只有一个数据时)，退出
        if (high - low < 1) {
            return;
        }
        //标记，从高指针开始，还是低指针（默认高指针）
        boolean flag = true;
        //记录指针的其实位置
        int start = low;
        int end = high;
        //默认中间值为低指针的第一个值
        int midValue = arr[low];
        while (true) {
            //高指针移动
            if (flag) {
                //如果列表右方的数据大于中间值，则向左移动
                if (arr[high] > midValue) {
                    high--;
                } else if (arr[high] < midValue) {
                    //如果小于，则覆盖最开始的低指针值，并且移动低指针，标志位改成从低指针开始移动
                    arr[low] = arr[high];
                    low++;
                    flag = false;
                }
            } else {
                //如果低指针数据小于中间值，则低指针向右移动
                if (arr[low] < midValue) {
                    low++;
                } else if (arr[low] > midValue) {
                    //如果低指针的值大于中间值，则覆盖高指针停留时的数据，并向左移动高指针。切换为高指针移动
                    arr[high] = arr[low];
                    high--;
                    flag = true;
                }
            }
            //当两个指针的位置相同时，则找到了中间值的位置，并退出循环
            if (low == high) {
                arr[low] = midValue;
                break;
            }
        }
        //然后出现有，中间值左边的小于中间值。右边的大于中间值。
        //然后在对左右两边的列表在进行快速排序
        quickSort(arr, start, low - 1);
        quickSort(arr, low + 1, end);
    }


    public static int[] sortedSquares4(int[] nums) {

        int[] result = new int[nums.length];

        //如果最小的数大于等于0
        if (nums[0] >= 0) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = nums[i] * nums[i];
            }
            return nums;
        }

        //数组里面的数据都小于等于0
        if (nums[nums.length - 1] <= 0) {
            for (int i = 0; i < nums.length; i++) {
                nums[i] = nums[nums.length - 1 - i] * nums[nums.length - 1 - i];
            }
            return nums;
        }

        int flag = 0;

        int left = 0;
        int right = nums.length - 1;

        //有正有负 以0为目标，找0的数组下标位置，不存在0，就返回0的位置
        while (left<right){
            int mid = left + (right-left)/2;
            if (nums[mid]<0){
                left = mid+1;
            }else if (nums[mid]>0){
                right =mid;
            }else if (nums[mid]==0){
                flag = mid;
            }
            if (left == right ){
                if (nums[left]>0){
                    flag =  left;
                }else if(nums[left]<0){
                    flag = left+1;
                }
            }
        }


        //以返回0的位置为分界线，为整个数组排序,0到flag的位置为负数，


            return nums;

    }
}
