package com.zrwang.algorithmtest.LeeCode.DFS;

/**
 * 200 难度： 中等
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 * {'1','1','0'}
 * {'1','1','0'}
 * {'0','0','1'}
 * 例如上图岛屿的数量为2
 *
 */
public class 岛屿数量 {
    // 初始化行列的长度
    private static int col;
    private static int row;
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0'},
                {'1','1','0'},
                {'0','0','1'}
        };
        int i = numIslands(grid);
        System.out.println(i);
    }

    public static int numIslands(char[][] grid) {
        int result = 0;
        row = grid.length;
        col = grid[0].length;
        for (int i = 0; i < row; i ++){
            for (int j = 0; j < col; j++){
                if (grid[i][j] == '0') continue;
                // 如果走的时候遇到了1，那么给将这个1附近的所有连通的1都全部置0，这里使用DFS进行置0
                dfs(grid,i,j);
                //以上的dfs操作可以理解为我们将岛屿摧毁了，之后纪念一下我们成功摧毁了一个岛屿，res累加1
                result ++;
            }
        }
        return result;
    }

    private static void dfs(char[][] grid, int i, int j) {
        // 如果超出了边界开始回退
        if (i < 0 || j >= col || j < 0 || i >= row) return;
        // 如果我们访问到的点已经是0也要开始回退
        if (grid[i][j] == '0') return;
        // 给符合条件的位置 置0
        grid[i][j] = '0';
        // 之后开始深度优先搜索遍历置0
        dfs(grid,i + 1,j);
        dfs(grid,i - 1,j);
        dfs(grid,i,j + 1);
        dfs(grid,i,j - 1);
    }
}
