package DynamicProgramming;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;

/**
 * 编辑距离
 *
 * @author : chezj
 * @date : 2022/10/24 15:04
 */
public class Problem72 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem72 p = new Problem72();
        System.out.println(p.minDistance("horse", "ros"));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    int[][] memo;
    
    public int minDistance(String word1, String word2) {
        memo = new int[word1.length()][word2.length()];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(word1, word1.length() - 1, word2, word2.length() - 1);
    }
    
    /**
     * 通过递归求解，需要优化重叠子问题
     *
     * @param s1
     * @param i
     * @param s2
     * @param j
     * @return
     */
    public int dp(String s1, int i, String s2, int j) {
        //base:i 走完 s1 或 j 走完 s2，可以直接返回另一个字符串剩下的长度
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }
        
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        
        //啥都不做
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = dp(s1, i - 1, s2, j - 1);
        } else {
            memo[i][j] = Math.min(
                    //在 s1[i] 插入一个和 s2[j] 一样的字符
                    dp(s1, i, s2, j - 1) + 1,
                    //直接把 s[i] 这个字符删掉
                    Math.min(dp(s1, i - 1, s2, j) + 1,
                            //把 s1[i] 替换成 s2[j]
                            dp(s1, i - 1, s2, j - 1) + 1));
        }
        
        return memo[i][j];
    }
}
