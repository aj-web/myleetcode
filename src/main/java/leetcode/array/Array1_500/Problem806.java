package leetcode.array.Array1_500;

import java.util.Arrays;

/**
 * @author : chezj
 * @date : 2022/8/29 16:35
 */
public class Problem806 {
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(numberOfLines(
                new int[] {4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
                        10, 10, 10}, "bbbcccdddaaa")));
    }
    
    public static int[] numberOfLines(int[] widths, String s) {
        int line = 1;
        int index = 0;
        for (char c : s.toCharArray()) {
            int width = widths[c - 'a'];
            if (index + width > 100) {
                line++;
                index = width;
            } else {
                index += width;
            }
        }
        return new int[] {line, index};
    }
    
}
