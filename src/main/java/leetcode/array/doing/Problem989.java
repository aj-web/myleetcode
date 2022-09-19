package leetcode.array.doing;

import org.apache.commons.lang3.time.StopWatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 数组形式的整数加法
 *
 * @author : chezj
 * @date : 2022/9/15 18:06
 */
public class Problem989 {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem989 p = new Problem989();
        System.out.println(p.addToArrayForm1(new int[]{2, 7, 4, 2, 9}, 181));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }

    /**
     * 数字长度过大
     *
     * @param num
     * @param k
     * @return
     */
    public List<Integer> addToArrayForm(int[] num, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i : num) {
            sb.append(i);
        }
        Long i = Long.parseLong(sb.toString()) + k;
        String s = i + "";
        List<Integer> ans = new ArrayList<>();
        for (int j = 0; j < s.length(); j++) {
            ans.add(s.charAt(j) - '0');
        }
        return ans;
    }


    public List<Integer> addToArrayForm1(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();

        for (int length = num.length - 1; length >= 0; length--) {
            int sum = num[length] + k % 10;
            k /= 10;
            if (sum > 9) {
                k++;
                sum -= 10;
            }
            ans.add(sum);

        }

        for (; k > 0; k /= 10) {
            ans.add(k % 10);
        }
        Collections.reverse(ans);
        return ans;
    }

}
