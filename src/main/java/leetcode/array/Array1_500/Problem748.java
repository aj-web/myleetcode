package leetcode.array.Array1_500;

/**
 * @author : chezj
 * @date : 2022/8/26 13:58
 */
public class Problem748 {

    public static void main(String[] args) {

    }


    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] cnt = getCnt(licensePlate);
        String ans = null;
        for (String s : words) {
            int[] cur = getCnt(s);
            boolean ok = true;
            for (int i = 0; i < 26 && ok; i++) {
                if (cnt[i] > cur[i]) {
                    ok = false;
                }
            }
            if (ok && (ans == null || ans.length() > s.length())) {
                ans = s;
            }
        }
        return ans;
    }


    int[] getCnt(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                cnt[Character.toLowerCase(c) - 'a']++;
            }
        }
        return cnt;
    }

}
