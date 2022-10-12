package leetcode.array.Array501_1000;

/**
 * leetcode种花问题
 */
public class Problem605 {

    public static void main(String[] args) {

        int[] p = new int[]{1, 0, 0, 0, 1, 0, 0};
        System.out.println(canPlaceFlowers(p, 2));

    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {


        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                i++;
            } else if (flowerbed[i] == 0) {
                if (i + 1 < flowerbed.length - 1) {
                    if (flowerbed[i + 1] != 1) {
                        n--;
                        i++;
                    }
                } else if (i == flowerbed.length - 1) {
                    n--;
                    i++;
                }
            }

        }
        return n <= 0;
    }
}
