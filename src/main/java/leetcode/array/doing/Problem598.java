package leetcode.array.doing;

/**
 * 范围求和
 */
public class Problem598 {
    public static void main(String[] args) {

    }

    public int maxCount(int m, int n, int[][] ops) {
        for (int[] op : ops) {
            m = Math.min(m, op[0]);
            n = Math.min(n, op[1]);
        }

        return m * n;
    }
}
