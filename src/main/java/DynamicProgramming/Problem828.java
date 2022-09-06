package DynamicProgramming;

import org.apache.commons.lang3.time.StopWatch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
}
