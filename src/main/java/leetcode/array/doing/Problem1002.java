package leetcode.array.doing;

import org.apache.commons.lang3.time.StopWatch;

import java.util.Arrays;
import java.util.List;

/**
 * 查找共用字符
 *
 * @author : chezj
 * @date : 2022/10/16 14:40
 */
public class Problem1002 {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem1002  p = new Problem1002();
        p.commonChars(new String[]{"bella","label","roller"});
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }


    public List<String> commonChars(String[] words) {
        int[][] res = new int[words.length][26];

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (char c : word.toCharArray()) {
                int index = c - 97;
                res[i][index] += 1;
            }
        }


        return null;
    }
}
