package leetcode.array.Array1_500;

/**
 * 位1的数
 * @author : chezj
 * @date : 2022/8/16 23:50
 */
public class Problem191 {

    public static void main(String[] args) {
        int l = 00000000000000000000000000001011;
        System.out.println(hammingWeight(l));
    }

    public static int hammingWeight(int n) {

        int count = 0;
        while (n!=0){
            count++;
            n&=n-1;
        }

        return count;
    }
}
