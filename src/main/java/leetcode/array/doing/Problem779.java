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
        
        if (n==0){
            return 1;
        }
        return kthGrammar(n-1,k);
    }
    
    
}
