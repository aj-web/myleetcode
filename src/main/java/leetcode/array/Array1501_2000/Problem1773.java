package leetcode.array.Array1501_2000;

import org.apache.commons.lang3.time.StopWatch;

import java.util.List;

/**
 * 统计匹配检索规则的物品数量
 *
 * @author : chezj
 * @date : 2022/10/30 17:40
 */
public class Problem1773 {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem1773 p = new Problem1773();

        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int res = 0;
        for (List<String> list : items) {
            if ("type".equals(ruleKey) && list.get(0).equals(ruleValue)) {
                res++;
            } else if ("color".equals(ruleKey) && list.get(1).equals(ruleValue)) {
                res++;
            } else if ("name".equals(ruleKey) && list.get(2).equals(ruleValue)) {
                res++;
            }
        }
        return res;
    }
}
