package leetcode.array;

/**
 * @author chezhijun
 * @descririon 移除元素
 * @date 2021/11/7
 * AC
 */
public class Problem27 {
    public static void main(String[] args) {
        int a[] = new int[]{3, 2, 2,3};
        int removeElement = removeElement(a, 3);
        System.out.println(removeElement);
    }


    /**
     * 使用快慢指针
     * nums[slow] = nums[fast];slow++;  通过这两行代码的顺序可以控制数组第一个元素是否保留
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int fast = 0;
        int slow = 0;
        while(fast<nums.length){
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
