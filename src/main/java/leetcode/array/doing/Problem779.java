package leetcode.array.doing;

import org.apache.commons.lang3.time.StopWatch;

/**
 * 第K个语法符号:递归
 * 0
 * 01
 * 0110
 * 01101001
 *
 * @author : chezj
 * @date : 2022/10/20 14:56
 */
public class Problem779 {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem779 p = new Problem779();
        System.out.println(p.kthGrammar(20, 2));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }

    public int kthGrammar(int n, int k) {
        return dfs(n, k, 1) == 0 ? 1 : 0;
    }

    public int dfs(int r, int c, int cur) {
        if (r==1){
            return cur;
        }
        if ((c % 2 == 0 && cur == 0) || (c % 2 == 1 && cur == 1)) {
            return dfs(r - 1, (c - 1) / 2 + 1, 1);
        } else {
            return dfs(r - 1, (c - 1) / 2 + 1, 0);
        }
    }


}
