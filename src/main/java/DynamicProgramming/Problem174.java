package DynamicProgramming;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : chezj
 * @date : 2022/9/9 14:57
 */
public class Problem174 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem174 p = new Problem174();
        System.out.println(p.calculateMinimumHP(new int[][] {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}}));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    
    public int calculateMinimumHP(int[][] dungeon) {
        
        int n = dungeon.length;
        int m = dungeon[0].length;
        
        List<Integer> list = new ArrayList<>();
        int[][] dp = new int[m][n];
        int p = dungeon[m - 1][n - 1];
        int k = dungeon[0][0];
        dp[0][0] = k;
        
        int res = 0;
        for (int i = 0; true; i++) {
            for (int j = 0; j < m; j++) {
                if (i + 1 < n - 1 && j + 1 <= m - 1) {
                    res += Math.max(dungeon[i + 1][j], dungeon[i][j + 1]);
                } else if (i + 1 <= n - 1) {
                    res += dungeon[i + 1][j];
                } else if (j + 1 <= m - 1) {
                    res += dungeon[i][j + 1];
                } else {
                    res += dungeon[i][j];
                }
            }
            break;
        }
        
        return 1-res+p+k;
    }
    
}
