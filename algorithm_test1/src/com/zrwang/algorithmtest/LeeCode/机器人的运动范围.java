package com.zrwang.algorithmtest.LeeCode;

/**
 * 面试题13 难度 中等
 */
public class 机器人的运动范围 {

    public static void main(String[] args) {

        int i = movingCount(16, 8, 4);

        System.out.println(i);
    }
    static boolean[][] visited;
    public static int movingCount(int m, int n, int k) {

        visited = new boolean[m][n];
        return dfs(0, 0, m, n, k);
    }
    private static int dfs(int x, int y, int m, int n, int k) {
        // 一旦移动的变量x或y 或者是访问元素的坐标 以及各个位数的数字相加大于k便结束递归返回之前栈中的所有方法
        if (x >= m || y >= n || visited[x][y]
                || (x % 10 + x / 10 + y % 10 + y / 10) > k) {
            return 0;
        }
        visited[x][y] = true;
        return 1 + dfs(x + 1, y, m, n, k) + dfs(x, y + 1, m, n, k);
    }
}
