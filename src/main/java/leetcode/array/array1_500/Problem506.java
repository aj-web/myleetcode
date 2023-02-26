package leetcode.array.array1_500;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 相对名次
 */
public class Problem506 {
    public static void main(String[] args) {
        int[] num = new int[]{5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(findRelativeRanks1(num)));
    }


    /**
     * 暴力解法 167ms
     *
     * @param score
     * @return
     */
    public static String[] findRelativeRanks(int[] score) {
        String[] answer = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            int index = score.length;
            for (int j = 0; j < score.length; j++) {
                if (score[j] < score[i]) {
                    index--;
                }
            }
            //退出循环
            if (index == 1) {
                answer[i] = "Gold Medal";
            } else if (index == 2) {
                answer[i] = "Silver Medal";
            } else if (index == 3) {
                answer[i] = "Bronze Medal";
            } else {
                answer[i] = index + "";
            }
        }
        return answer;
    }


    /**
     * 排序解法
     *
     * @param score
     * @return
     */
    public static String[] findRelativeRanks1(int[] score) {
        String[] answer = new String[score.length];
        Map<Integer, Integer> dict = new HashMap<>(score.length);
        int[] clone = score.clone();
        Arrays.sort(clone);
        for (int i = clone.length - 1; i >= 0; i--) {
            dict.put(clone[i], clone.length - i);
        }
        for (int i = 0; i < score.length; i++) {
            if (dict.get(score[i]) == 1) {
                answer[i] = "Gold Medal";
            } else if (dict.get(score[i]) == 2) {
                answer[i] = "Silver Medal";
            } else if (dict.get(score[i]) == 3) {
                answer[i] = "Bronze Medal";
            } else {
                answer[i] = dict.get(score[i]) + "";
            }
        }
        return answer;
    }
}
