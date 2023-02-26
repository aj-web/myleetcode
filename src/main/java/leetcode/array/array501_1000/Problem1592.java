package leetcode.array.array501_1000;

import org.apache.commons.lang3.time.StopWatch;

/**
 * 重新排列单词间的空格
 *
 * @author : chezj
 * @date : 2022/9/7 17:16
 */
public class Problem1592 {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem1592 p = new Problem1592();
        System.out.println(p.reorderSpaces("  this   is  a sentence "));

        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }


    public String reorderSpaces(String text) {
        int length = text.length();
        String[] split = text.trim().split("\\s+");

        int temp = length;
        for (String s : split) {
            temp -= s.length();
        }

        StringBuilder sb = new StringBuilder();
        if (split.length == 1) {
            sb.append(split[0]);
            for (int i = 0; i < temp; i++) {
                sb.append(' ');
            }
            return sb.toString();
        }

        int perSpace = temp / (split.length - 1);
        int restSpace = temp % (split.length - 1);

        for (int i = 0; i < split.length; i++) {
            if (i > 0) {
                for (int j = 0; j < perSpace; j++) {
                    sb.append(' ');
                }
            }
            sb.append(split[i]);
        }
        for (int i = 0; i < restSpace; i++) {
            sb.append(' ');
        }

        return sb.toString();
    }
}
