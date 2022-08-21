package DynamicProgramming;

/**使用最小花费爬楼梯
 *
 * 动态规划
 * @author : chezj
 * @date : 2022/8/20 16:40
 */
public class Problem746 {


    /**
     * 动态规划
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {

        int[] dp = new int[cost.length+1];
        dp[0] = dp[1]=0;
        for (int i = 2; i <= cost.length; i++) {
            dp[i] = Math.min(dp[i-2]+cost[i-2],dp[i-1]+cost[i-1]);
        }
        return dp[cost.length];
    }

    /**
     * 优化空间复杂度
     * @param cost
     * @return
     */
    public int minCostClimbingStairs1(int[] cost) {
        int pre = 0;
        int curr = 0;
        for (int i = 2; i <= cost.length; i++) {
            int sum =  Math.min(curr+cost[i-1],pre+cost[i-2]);
            pre =curr;
            curr = sum;

        }
        return curr;
    }


}
