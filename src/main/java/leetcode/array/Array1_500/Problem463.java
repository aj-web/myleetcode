package leetcode.array.Array1_500;

/**
 * leetcode：计算岛屿的周长
 */
public class Problem463 {

    public static void main(String[] args) {

        int[][] grid = new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(islandPerimeter(grid));
    }

    public static int islandPerimeter(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    count += 4;
                    //上
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        count--;
                    }
                    //下
                    if (i + 1 <= grid.length - 1 && grid[i + 1][j] == 1) {
                        count--;
                    }
                    //左
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        count--;
                    }
                    //右
                    if (j + 1 <= grid[i].length - 1 && grid[i][j + 1] == 1) {
                        count--;
                    }

                }
            }
        }
        return count;
    }

    /**
     * 优化版本
     *
     * @param grid
     * @return
     */
    public static int islandPerimeter2(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    count += 4;

                    if (i >= 1 && i <= grid.length - 2) {
                        //上
                        if (grid[i - 1][j] == 1) {
                            count--;
                        }
                        //下
                        if (grid[i + 1][j] == 1) {
                            count--;
                        }
                    }
                    if (j >= 1 && j <= grid[i].length - 2) {
                        //左
                        if (grid[i][j - 1] == 1) {
                            count--;
                        }
                        //右
                        if (grid[i][j + 1] == 1) {
                            count--;
                        }
                    }
                }
            }
        }
        return count;
    }
}
