package dynamicprogramming;

/**
 * * leetc509 斐波那锲数列
 */
public class Problem509 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int fib = fib2(32);
        long end = System.currentTimeMillis() - start;
        System.out.println(end);
        System.out.println(fib);
    }


    /**
     * 暴力解法 递归   时间负载度 o2n次方
     *
     * @param n
     * @return
     */
    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }


    /**
     * 递归
     * 增加一个辅助空间用于做记录
     * 从顶部到根部查找
     *
     * @param n
     * @return
     */
    public static int fib1(int n) {
        int[] memory = new int[n + 1];
        return helper(n, memory);
    }

    private static int helper(int n, int[] memo) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = helper(n - 1, memo) + helper(n - 2, memo);
        return memo[n];
    }


    /**
     * 动态规划解法
     * 状态转移方程
     *
     * @param n
     * @return
     */
    public static int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        //basic case
        dp[0] = 0;
        dp[1] = 1;
        //状态转移方程
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    /**
     * 动态规划解法
     * 优化空间复杂度
     *
     * @param n
     * @return
     */
    public static int fib3(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        //basic case
        dp[0] = 0;
        dp[1] = 1;

        int prev = 0;
        int curr = 1;
        //状态转移方程
        for (int i = 2; i <= n; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }

}
