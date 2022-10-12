package leetcode.array.Array501_1000;

/**
 * 寻找比目标字母大的最小字母
 *
 * @author : chezj
 * @date : 2022/8/20 16:13
 */
public class Problem744 {

    public static void main(String[] args) {
        char[] c = new char[]{'c', 'f', 'j'};

        System.out.println(nextGreatestLetter(c, 'j'));
    }


    public static char nextGreatestLetter(char[] letters, char target) {
        if (target == 'z') {
            return letters[0];
        }


        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > target) {
                return letters[i];
            }
        }

        return letters[0];
    }

}
