package DynamicProgramming;

import java.util.Arrays;

/**
 * @author : chezj
 * @date : 2022/9/3 16:09
 */
public class Problem115 {
    public static void main(String[] args) {
        System.out.println(numDistinct("rabbbit", "rabbit"));
    }


    public static  int numDistinct(String s, String t) {

        int len = s.length();
        int[][] dp = new int[len+1][len+1];
        for (int i = 1; i < s.length(); i++) {
            innerCycel:
            for (int j = 1; j <= i; j++) {
                String sub = s.substring(j-1, i);
                for (char c : t.toCharArray()) {
                    if (!sub.contains(String.valueOf(c))) {
                        dp[j][i] = dp[j-1][i];
                        break innerCycel;
                    }
                }
                dp[j][i] = dp[j][i] + 1;
            }
        }


        return dp.length;
    }
}
