package leetcode.array.array501_1000;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : chezj
 * @date : 2022/11/7 21:25
 */
public class Problem816 {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem816 p = new Problem816();
        System.out.println(p.ambiguousCoordinates1("(123)"));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }


    /**
     * if (len <= 1) {
     * return Collections.singletonList("s");
     * }
     * 题目保证s.len>=4;
     *
     * @param s
     * @return
     */
    public List<String> ambiguousCoordinates(String s) {
        int len = s.length();
        String str = ", ";
        List<String> res = new ArrayList<>();
        int left = 0;
        int right = 0;
        //从左右第一个非0的数开始
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != '0') {
                left = i;
                break;
            }
        }
        int count = 0;
        //从右玩往左连续的第二个零
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                right = i;
                break;
            }
            if (s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == '0') {
                count++;
            }
            if (count == 2) {
                right = i;
                break;
            }
        }

        //00010003
        for (int i = left + 1; i < right; i++) {
            if (s.charAt(i) == s.charAt(i - 1) && i > 1 && s.charAt(i) == '0') {
                continue;
            }
            StringBuilder sb = new StringBuilder(s);
            sb.insert(i, str);
            res.add(sb.toString());
        }

        return res;
    }

    /**
     * 获得x轴，然后使用“小数点”分割出【n种】可能的合法数字
     * 获得y轴，然后使用“小数点”分割出【m种】可能的合法数字
     * 拼装在最终结果【n*m种】
     *
     * @param s
     * @return
     */
    public List<String> ambiguousCoordinates1(String s) {
        List<String> result = new ArrayList();
        s = s.substring(1, s.length() - 1);
        for (int i = 1; i < s.length(); i++) {
            for (String x : getNums(s.substring(0, i))) {
                for (String y : getNums(s.substring(i))) {
                    result.add("(" + x + ", " + y + ")");
                }
            }
        }
        return result;
    }

    /**
     * 将num用小数点分割
     */
    private List<String> getNums(String num) {
        List<String> list = new ArrayList();
        int i = 1;
        String left, right;
        while (i <= num.length()) {
            left = num.substring(0, i);
            right = num.substring(i++);
            if ((!"0".equals(left) && left.charAt(0) == '0')) {
                continue;
            }
            if ((!right.isEmpty() && right.charAt(right.length() - 1) == '0')) {
                continue;
            }
            if (right.isEmpty()) {
                list.add(left);
            } else {
                list.add(left + "." + right);
            }
        }
        return list;
    }


}
