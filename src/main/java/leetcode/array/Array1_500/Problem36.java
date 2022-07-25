package leetcode.array.Array1_500;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode36：有效的数独
 */
public class Problem36 {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        boolean validSudoku = isValidSudoku(board);
    }

    public static boolean isValidSudoku(char[][] board) {
        if (board.length != 9 || board[0].length != 9) {
            return false;
        }
        //横向Map
        Map<Character, Integer> horizontalline0 = new HashMap<>();
        Map<Character, Integer> horizontalline1 = new HashMap<>();
        Map<Character, Integer> horizontalline2 = new HashMap<>();
        Map<Character, Integer> horizontalline3 = new HashMap<>();
        Map<Character, Integer> horizontalline4 = new HashMap<>();
        Map<Character, Integer> horizontalline5 = new HashMap<>();
        Map<Character, Integer> horizontalline6 = new HashMap<>();
        Map<Character, Integer> horizontalline7 = new HashMap<>();
        Map<Character, Integer> horizontalline8 = new HashMap<>();
        //索引Map
        Map<Integer, Map<Character, Integer>> indexHorizontal = new HashMap<>();
        indexHorizontal.put(0, horizontalline0);
        indexHorizontal.put(1, horizontalline1);
        indexHorizontal.put(2, horizontalline2);
        indexHorizontal.put(3, horizontalline3);
        indexHorizontal.put(4, horizontalline4);
        indexHorizontal.put(5, horizontalline5);
        indexHorizontal.put(6, horizontalline6);
        indexHorizontal.put(7, horizontalline7);
        indexHorizontal.put(8, horizontalline8);


        //纵向MAP
        Map<Character, Integer> verticalLine0 = new HashMap<>();
        Map<Character, Integer> verticalLine1 = new HashMap<>();
        Map<Character, Integer> verticalLine2 = new HashMap<>();
        Map<Character, Integer> verticalLine3 = new HashMap<>();
        Map<Character, Integer> verticalLine4 = new HashMap<>();
        Map<Character, Integer> verticalLine5 = new HashMap<>();
        Map<Character, Integer> verticalLine6 = new HashMap<>();
        Map<Character, Integer> verticalLine7 = new HashMap<>();
        Map<Character, Integer> verticalLine8 = new HashMap<>();
        //索引Map
        Map<Integer, Map<Character, Integer>> indexVertical = new HashMap<>();
        indexVertical.put(0, verticalLine0);
        indexVertical.put(1, verticalLine1);
        indexVertical.put(2, verticalLine2);
        indexVertical.put(3, verticalLine3);
        indexVertical.put(4, verticalLine4);
        indexVertical.put(5, verticalLine5);
        indexVertical.put(6, verticalLine6);
        indexVertical.put(7, verticalLine7);
        indexVertical.put(8, verticalLine8);

        for (int i1 = 0; i1 < board.length; i1++) {
            char[] chars = board[i1];
            for (int i2 = 0; i2 < chars.length; i2++) {
                //横向判断
                if (indexHorizontal.get(i2).containsKey(chars[i2])) {
                    return false;
                } else {
                    indexHorizontal.get(i2).put(chars[i2], i2);
                }
                //纵向判断
                if (indexVertical.get(i2).containsKey(chars[i2])) {
                    return false;
                } else {
                    indexVertical.get(i2).put(chars[i2], i2);
                }
                //九宫格判断
                if (i2 + 1 % 3 == 0 && i1 + 1 % 3 == 0) {
                    if (i2 < 3 && i1<3) {

                    } else if (i2 < 6 && i1<6) {

                    } else if (i2 < 9 && i1<9) {

                    }
                }
            }
        }
        return false;
    }
}
