package leetcode.array.Array1_500;

/**
 * @author : chezj
 * @date : 2022/8/17 0:04
 */
public class Problem1281 {

    public static void main(String[] args) {
        subtractProductAndSum(1234);
    }

    public static int subtractProductAndSum(int n) {

        int mul = 1;
        int sum = 0;
        while (n > 0) {
            int dig = n % 10;
            n/=10;
            mul *=dig;
            sum+=dig;
        }

        return mul - sum;
    }
}
