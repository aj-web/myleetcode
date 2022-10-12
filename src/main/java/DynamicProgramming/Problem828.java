package DynamicProgramming;

import org.apache.commons.lang3.time.StopWatch;

import java.util.*;

/**
 * @author : chezj
 * @date : 2022/9/6 10:10
 */
public class Problem828 {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Problem828 p = new Problem828();
        System.out.println(p.uniqueLetterString("DELQGVWNZKIJJPSXOVWWIZUXCEGWSQLESNSRBMKZARFPAXSVWQEZDENDAHNNIBHGHTFDLPGDLFXMIYRFNLMXHNPIFUAXINXPXLCTTJNLGGMKJIOEWBECNOFQPVCIKIAZMNGHEHFMCPWSMJTMGVSXTOGCGUYKFMNCGLCBRAFJLJVPIVDOLJBURULPGXBVDCEWXXXLTRMSHPKSPFDGNVOCZWDXJUWVNAREDOKTZMIUDKDQWWWSAEUUDBHMWZELOSBIHMAYJEMGZPMDOOGSCKLVHTGMETHUISCLJKDOQEWGVBULEMUXGTRKGXYFDIZTZWMLOFTCANBGUARNWQEQWGMIKMORVQUZANJNRNPMJWYLVHWKDFLDDBBMILAKGFROEQAMEVONUVHOHGPKLBPNYZFPLXNBCIFENCGIMIDCXIIQJWPVVCOCJTSKSHVMQJNLHSQTEZQTTMOXUSKBMUJEJDBJQNXECJGSZUDENJCPTTSREKHPRIISXMWBUGMTOVOTRKQCFSDOTEFPSVQINYLHXYVZTVAMWGPNKIDLOPGAMWSKDXEPLPPTKUHEKBQAWEBMORRZHBLOGIYLTPMUVBPGOOOIEBJEGTKQKOUURHSEJCMWMGHXYIAOGKJXFAMRLGTPNSLERNOHSDFSSFASUJTFHBDMGBQOKZRBRAZEQQVWFRNUNHBGKRFNBETEDJIWCTUBJDPFRRVNZENGRANELPHSDJLKVHWXAXUTMPWHUQPLTLYQAATEFXHZARFAUDLIUDEHEGGNIYICVARQNRJJKQSLXKZZTFPVJMOXADCIGKUXCVMLPFJGVXMMBEKQXFNXNUWOHCSZSEZWZHDCXPGLROYPMUOBDFLQMTTERGSSGVGOURDWDSEXONCKWHDUOVDHDESNINELLCTURJHGCJWVIPNSISHRWTFSFNRAHJAJNNXKKEMESDWGIYIQQRLUUADAXOUEYURQRVZBCSHXXFLYWFHDZKPHAGYOCTYGZNPALAUZSTOU"));
        stopWatch.stop();
        System.out.println(stopWatch.getTime() + "毫秒");
    }


    /**
     * DP求解超时
     *
     * @param s
     * @return
     */
    public int uniqueLetterString(String s) {

        if (s.length() <= 1) {
            return s.length();
        }
        int[] dp = new int[s.length()];
        //base_case
        dp[0] = 1;
        Map<String, Integer> memo = new HashMap<>();

        //memo预处理
        for (char c : s.toCharArray()) {
            memo.put(String.valueOf(c), 1);
        }
        for (int i = 1; i < s.length(); i++) {
            int temp = 0;
            for (int j = 0; j < i + 1; j++) {
                String substring = s.substring(j, i + 1);
                if (!(memo.containsKey(substring))) {
                    int uns = countUniqueChars1(substring);
                    temp += uns;
                    memo.put(substring, uns);
                } else {
                    temp += memo.get(substring);
                }
            }
            dp[i] = dp[i - 1] + temp;
        }
        return dp[s.length() - 1];
    }

    /**
     * 字符串去重
     *
     * @param s
     * @return
     */
    public int countUniqueChars1(String s) {
        Set<Character> set = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (set2.contains(c)) {
                set2.remove(c);
                set.add(c);
            } else {
                if (set.contains(c)) {
                    continue;
                }
                set2.add(c);
            }
        }
        return set2.size();
    }


    /**
     * @param s
     * @return
     */
    public int uniqueLetterString2(String s) {
        Map<Character, List<Integer>> index = new HashMap<Character, List<Integer>>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!index.containsKey(c)) {
                index.put(c, new ArrayList<Integer>());
                index.get(c).add(-1);
            }
            index.get(c).add(i);
        }
        int res = 0;
        for (Map.Entry<Character, List<Integer>> entry : index.entrySet()) {
            List<Integer> arr = entry.getValue();
            arr.add(s.length());
            for (int i = 1; i < arr.size() - 1; i++) {
                res += (arr.get(i) - arr.get(i - 1)) * (arr.get(i + 1) - arr.get(i));
            }
        }
        return res;
    }
}
