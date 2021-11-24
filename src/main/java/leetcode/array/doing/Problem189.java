package leetcode.array.doing;

/**
 * @author chezhijun
 * @descririon 轮转数组
 * @date 2021/11/12
 */
public class Problem189 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(a, 3);
        System.out.println("OK");
    }

    public static void rotate(int[] nums, int k) {

        k%=nums.length;

        reverse(nums, 0, nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k, nums.length-1);

    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }

    /**
     * 实现想法有缺陷 [1,2] 3实现较为麻烦
     * 看了答案，返现如果k大于数组长度 那么直接取余即可，妙
     *
     * @param nums
     * @param k
     */
    public static void rotate1(int[] nums, int k) {

        k%= nums.length;

        int p1 = 0;
        int p2 = nums.length - 1;
        int[] result = new int[nums.length];
        int index = k - 1;
        int index1 = k;
        while (p1 < nums.length - k || p2 >= nums.length - k) {
            if (p2 >= nums.length - k) {
                result[index] = nums[p2];
                p2--;
                index--;
            } else if (p1 < nums.length - k) {
                result[index1] = nums[p1];
                p1++;
                index1++;
            }

        }
        System.arraycopy(result, 0, nums, 0, result.length);

    }
}
