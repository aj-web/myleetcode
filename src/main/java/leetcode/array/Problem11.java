package leetcode.array;

/**
 * @author chezhijun
 * @descririon
 * @date 2021/8/16
 */
public class Problem11 {

    public static void main(String[] args) {
          int[] t = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea1(t));
    }

    /**
     * @Author ninan
     * @Description 效率很低，数组长度过大时不推荐
     * @Date  2021/8/16
     **/
    public static int maxArea(int[] height) {

        int cur = 0;
        int tar = -1;
        for (int i = 0; i < height.length; i++) {
            for (int j = i+1; j < height.length ; j++) {

                if (height[i] < height[j]){
                    cur = height[i];
                }else {
                    cur = height[j];
                }

                if (tar < (j-i) * cur){
                    tar = (j-i) * cur;
                }
            }
        }

        return tar;
    }


    public static int maxArea1(int[] height){
        int p1 = 0;
        int p2 = height.length -1;
        int tar = 0;

        while (p1 != p2){
            if (height[p1] < height[p2]){
                if ((p2 - p1 )*height[p1]>tar){
                    tar = (p2 - p1 )*height[p1];
                }
                p1++;
            }else {
                if ((p2 -p1 ) *height[p2] >tar){
                    tar = (p2 -p1 ) *height[p2];
                }
                p2--;
            }
        }

        return tar;
    }


}
