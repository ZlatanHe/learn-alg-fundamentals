package array;

/**
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。
 * 你可以假设二维矩阵的四个边缘都被水包围着。
 *
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 *
 * Created by Zlatan on 19/3/11.
 */
class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int area = widthFirstSearch(grid, i, j);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    private int widthFirstSearch(int[][] grid, int row, int col) {
        if (row < 0 || row == grid.length) {
            return 0;
        }
        if (col < 0 || col == grid[row].length) {
            return 0;
        }
        if (grid[row][col] != 1) {
            return 0;
        }
        grid[row][col] = 2;
        return 1
                + widthFirstSearch(grid, row + 1, col)
                + widthFirstSearch(grid, row - 1, col)
                + widthFirstSearch(grid, row, col + 1)
                + widthFirstSearch(grid, row, col - 1);
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        System.out.println(new MaxAreaOfIsland().maxAreaOfIsland(grid));
    }
}