package leetcode.array.array1_500;

import java.util.Arrays;

/**
 * 反转图像
 *
 * @author : chezj
 * @date : 2022/8/30 11:29
 */
public class Problem832 {
    
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(
                flipAndInvertImage(new int[][] {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}})));
    }
    
    public static int[][] flipAndInvertImage(int[][] image) {
        for (int k = 0; k < image.length; k++) {
            int[] temp = new int[image[k].length];
            for (int i = image[k].length - 1, j = 0; i >= 0; i--) {
                temp[j] = image[k][i] == 1 ? 0 : 1;
                j++;
            }
            image[k] = temp;
        }
        return image;
    }
    
    
}
