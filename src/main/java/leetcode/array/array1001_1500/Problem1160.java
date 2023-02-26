package leetcode.array.array1001_1500;

import org.apache.commons.lang3.time.StopWatch;

/**
 * 拼写单词
 *
 * @author : chezj
 * @date : 2022/10/27 15:55
 */
public class Problem1160 {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem1160 p = new Problem1160();
        System.out.println(p.countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }

    /**
     * 暴力解法
     *
     * @param words
     * @param chars
     * @return
     */
    public int countCharacters(String[] words, String chars) {
        int[] charsInt = new int[26];
        for (char c : chars.toCharArray()) {
            charsInt[c - 'a']++;
        }
        int[] temp = new int[26];

        int count = 0;
        for (String word : words) {
            System.arraycopy(charsInt, 0, temp, 0, 26);
            count += word.length();
            for (char c : word.toCharArray()) {
                if (temp[c - 'a'] < 1) {
                    count -= word.length();
                    break;
                }
                temp[c - 'a']--;
            }
        }
        return count;
    }


}
