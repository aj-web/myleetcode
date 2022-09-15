package leetcode.array.doing;

import org.apache.commons.lang3.time.StopWatch;

/**
 * @author : chezj
 * @date : 2022/9/15 16:56
 */
public class Problem672 {
    
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem672 p = new Problem672();
        System.out.println(p.flipLights(7, 6));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }
    
    /**
     * 找规律
     * @TODO CV
     * @param n
     * @param presses
     * @return
     */
    public int flipLights(int n, int presses) {
        //不按开关
        if (presses == 0) {
            return 1;
        }
        //特殊情况处理
        if (n == 1) {
            return 2;
        } else if (n == 2) {
            //特殊情况
            return presses == 1 ? 3 : 4;
        } else {
            //n >= 3
            return presses == 1 ? 4 : presses == 2 ? 7 : 8;
        }
    }
    
}
