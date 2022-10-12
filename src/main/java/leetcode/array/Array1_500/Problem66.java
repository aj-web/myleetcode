package leetcode.array.Array1_500;

/**
 * LeetCode66：加一
 */
public class Problem66 {

    public static void main(String[] args) {
        int[] ints = {9, 9, 9, 9, 9, 9, 9};
        plusOne(ints);
    }


    public static int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return digits;
        }
        int digit = digits[digits.length - 1];
        int point = digits.length - 1;

        if (digit != 9) {
            digits[digits.length - 1] = digit + 1;
            return digits;
        }


        for (; point >= 0; point--) {
            if (digits[point] != 9) {
                break;
            }
        }
        if (point != -1) {
            digits[point] = digits[point] + 1;
            for (int i = point + 1; i < digits.length; i++) {
                digits[i] = 0;
            }
            return digits;
        } else {
            int[] ints = new int[digits.length + 1];
            ints[0] = 1;
            return ints;
        }


    }
}
