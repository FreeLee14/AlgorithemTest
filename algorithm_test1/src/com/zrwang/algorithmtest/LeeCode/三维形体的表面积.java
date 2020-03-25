package com.zrwang.algorithmtest.LeeCode;

/** 892
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 *
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 *
 * 请你返回最终形体的表面积。
 * 测试用例
 *  输入：[[2]]
 *  输出：10
 *
 *  输入：[[1,2],[3,4]]
 *  输出：34
 *
 *  输入：[[1,0],[0,2]]
 *  输出：16
 *
 *  输入：[[1,1,1],[1,0,1],[1,1,1]]
 *  输出：32
 *
 *  输入：[[2,2,2],[2,1,2],[2,2,2]]
 *  输出：46
 * 首先要好好理解一下本题，该题采用数学的思维进行画图推导公式即可
 */
public class 三维形体的表面积 {

    public static void main(String[] args) {

        int[][] grid = new int[][]{{1,0}, {0,2}};

        int result = surfaceArea(grid);

        System.out.println(result);
    }

    private static int surfaceArea(int[][] grid) {
        //如果数组长度超过 50或着是空数组返回0
        if (grid.length > 50 || grid.length < 1){

            return 0;

        }
        //初始化一个格子上的多面体的表面积
        int singleArea = 0;
        //初始化最终形成的多面体的表面积
        int sumArea = 0;

        for (int i = 0; i < grid.length; i ++){

            for (int j =0; j < grid[i].length; j++){
                //如果每个格子的个数超过50 或是负数则忽略计算进行下一个格子的判断
                if (grid[i][j] > 50 || grid[i][j] < 0){

                    continue;

                }
                // 一个单元格中对应的立方体个数的总的表面积，当个数不为0时才进行后续一系列公式的计算
                if (grid[i][j] != 0){

                    singleArea = 6 * grid[i][j] - 2 * (grid[i][j] - 1);

                    sumArea += singleArea;

                    int row = 0;
                    int column = 0;

                    //求出同一行与同一列相邻个数的最小个数值，按照这个个数计算需要减去的相邻立方体之间覆盖的面积总和
                    // 与相邻行的差值
                    if (j + 1 < grid[i].length){

                        row = Math.min(grid[i][j], grid[i][j+1]);

                    }else {

                        row = 0;

                    }
                    // 与相邻列的差值
                    if (i + 1 < grid.length){

                        column = Math.min(grid[i][j], grid[i+1][j]);

                    }else {

                        column = 0;

                    }
                    //再让总面积减去这个相邻覆盖面积和
                    sumArea -= 2 * (row + column);

                }

            }

        }

        return sumArea;
    }
}
