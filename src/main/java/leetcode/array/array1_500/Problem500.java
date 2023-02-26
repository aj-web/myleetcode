package leetcode.array.array1_500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem500 {
    public static void main(String[] args) {
        String[] a = new String[]{"Hello", "Alaska", "Dad", "Peace"};
        System.out.println(Arrays.toString(findWords(a)));
    }


    public static String[] findWords(String[] words) {

        String s1 = "qwertyuiopQWERTYUIOP";
        String s2 = "asdfghjklASDFGHJKL";
        String s3 = "zxcvbnmZXCVBNM";
        List<String> res = new ArrayList<>();

        for (String word : words) {
            point1:
            if (s1.contains(String.valueOf(word.charAt(0)))) {
                for (int i = 0; i < word.length(); i++) {
                    if (!s1.contains(String.valueOf(word.charAt(i)))) {
                        break point1;
                    }
                }
                res.add(word);
            }
            point2:
            if (s2.contains(String.valueOf(word.charAt(0)))) {
                for (int i = 0; i < word.length(); i++) {
                    if (!s2.contains(String.valueOf(word.charAt(i)))) {
                        break point2;
                    }
                }
                res.add(word);
            }
            point3:
            if (s3.contains(String.valueOf(word.charAt(0)))) {
                for (int i = 0; i < word.length(); i++) {
                    if (!s3.contains(String.valueOf(word.charAt(i)))) {
                        break point3;
                    }
                }
                res.add(word);
            }

        }
        return res.toArray(new String[res.size()]);
    }

}
