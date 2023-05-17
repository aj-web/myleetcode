package dynamicprogramming;

/**
 * leet322 零钱兑换
 */
public class Problem322 {
    
    
    public int coinChange(int[] coins, int amount) {
        
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int result = coinChange(coins, amount - coin);
            if (result == -1) {
                continue;
            }
            res = Math.min(result + 1, res);
        }
        
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    
}
