package leetcode.array;

/**
 * @author chezhijun
 * @descririon
 * @date 2021/8/16
 */
public class Problem11 {

    public static void main(String[] args) {
        int[] t = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(findWaterMax(t));
    }

    /**
     * 核心就是求面积，那么就转化为长乘宽的问题；
     *
     * @Author ninan
     * @Description 超出时间限制
     * @Date 2021/8/16
     **/
    public static int findWaterMax(int[] height) {
        int maxArea = 0;
        int y = 0;
        int x = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                y = height[i] < height[j] ? height[i] : height[j];
                x = j - i;
                maxArea = x * y > maxArea ? x * y : maxArea;
            }
        }
        return maxArea;
    }

    /**
     * 对上面的方式进行优化，第二个for循环从数组尾部开始，这样可以跳过一些情况 跳过on情况
     *
     * @param height
     * @return
     */
    public static int findWaterMax1(int[] height) {
        int maxArea = 0;
        int y = 0;
        int x = 0;
        for (int i = 0; i < height.length - 1; i++) {
            if (height[i] == 0) {
                continue;
            }
            for (int j = height.length - 1; j > 0; j--) {
                if (j != height.length - 1 && height[j] < height[j + 1]) {
                    continue;
                }
                y = height[i] < height[j] ? height[i] : height[j];
                x = j - i;
                maxArea = x * y > maxArea ? x * y : maxArea;
            }
        }
        return maxArea;

    }


    /**
     * 再次优化那么在第一个for循环的时候就反向遍历 直接可以跳过 on2钟情况
     * @param height
     * @return
     */
    public static int findWaterMax2(int[] height) {
        int maxArea = 0;
        int y = 0;
        int x = 0;

        for (int i = height.length - 1; i > 0; i--) {
            if (i != height.length-1 && height[i] < height[i + 1]) {
                continue;
            }
            for (int j = 0; j < i; j++) {
                if (height[j] == 0) {
                    continue;
                }
                y = Math.min(height[i], height[j]);
                x = i - j;
                maxArea = x * y > maxArea ? x * y : maxArea;
            }
        }
        return maxArea;
    }

    /**
     * 思想很重要 面积=两个指针指向的数字中较小值∗指针之间的距离
     * 那么我们直接把距离拉到最大，跳过“两个指针指向的数字中较小值”，采用双指针跳过左右中小的，因为水桶效应，
     * 最小的数影响最大，所以跳过，
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int p1 = 0;
        int p2 = height.length - 1;
        int tar = 0;

        while (p1 != p2) {
            if (height[p1] < height[p2]) {
                if ((p2 - p1) * height[p1] > tar) {
                    tar = (p2 - p1) * height[p1];
                }
                p1++;
            } else {
                if ((p2 - p1) * height[p2] > tar) {
                    tar = (p2 - p1) * height[p2];
                }
                p2--;
            }
        }

        return tar;
    }


}
