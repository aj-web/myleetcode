package leetcode.array.doing;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
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
        int[] minfreq = new int[26];
        Arrays.fill(minfreq, Integer.MAX_VALUE);
        for (String word : words) {
            int [] temp = new int[26];
            int len = word.length();
            for (int i = 0; i < len; i++) {
                temp[word.charAt(i)-'a']++;
            }
            for (int i = 0; i < 26; ++i) {
                minfreq[i] = Math.min(minfreq[i], temp[i]);
            }
        }
        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < minfreq[i]; ++j) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }
}
