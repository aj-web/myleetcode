package leetcode.array.Array501_1000;

/**有效的山脉数组
 * @author : chezj
 * @date : 2022/9/4 16:45
 */
public class Problem941 {
    public static void main(String[] args) {

        System.out.println(validMountainArray(new int[]{0,3,2,1}));
    }


    public static boolean validMountainArray(int[] arr) {
        if (arr.length <= 2) {
            return false;
        }
        int temp = 0;
        int index = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                temp++;
                index = i;
            }
        }
        //检查单调性
        for (int i = 0; i < index; i++) {
            if (arr[i+1]<=arr[i]){
                return false;
            }
        }
        for (; index < arr.length-1; index++) {
            if (arr[index+1]>=arr[index]){
                return false;
            }
        }
        return temp == 1;
    }
}
