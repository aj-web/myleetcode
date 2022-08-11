package leetcode.array.Array1_500;

import java.util.HashSet;
import java.util.Set;

/**
 * leetcode分糖果
 */
public class Problem575 {

    public static void main(String[] args) {
        int[] p = new int[]{1,1,2,3};
        System.out.println(distributeCandies1(p));
    }


    public static int distributeCandies(int[] candyType) {

        int n = candyType.length/2;
        Set<Integer> temp = new HashSet<>(candyType.length);
        for (int i : candyType) {
            temp.add(i);
        }
        if (n>=temp.size()){
            return temp.size();
        }else {
            return n;
        }
    }


    /**
     * 有序数组才能使用双指针
     * @param candyType
     * @return
     */
    public static int distributeCandies1(int[] candyType) {

        int slow = 0;
        int fast = 0;
        int target = candyType.length/2;
        while (fast<candyType.length){
            if (candyType[fast]!=candyType[slow]){
                slow++;
                candyType[slow] = candyType[fast];
            }
            fast++;
            if (slow+1>=target){
                return slow+1;
            }
        }
        return slow+1;

    }
}
