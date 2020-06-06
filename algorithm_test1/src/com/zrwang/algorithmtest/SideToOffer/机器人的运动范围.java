package com.zrwang.algorithmtest.SideToOffer;

public class 机器人的运动范围 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.movingCount(2, 2, 1);
        System.out.println(i);
    }
}
class Solution {
    /**
     本题适合使用dfs进行求解
     */
    int res = 0;
    public int movingCount(int m, int n, int k) {
        // 没有行或没有列
        if(m == 0 || n == 0 ) return 0;
        // 如果k = 0的话只有0 0 位置可以移动
        if( k == 0 ) return 1;
        boolean [][] visited = new boolean[m][n];
        // 通过深搜返回结果，需要传入行列数，同时还有i，j代表坐标移动，以及坐标的两位数之和的限制
        return dfs(m,n,0,0,k,visited);
    }
    public int dfs(int m, int n, int i , int j, int k,boolean[][] visited){
        if( i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || ( i % 10 + i / 10 + j % 10 + j / 10) > k ) return 0;
        // 用于控制访问标识，用于剪枝
        visited[i][j] = true;
        // 因为这个题是求可以走的格子数量，不用再往回上和左走，只需要向下和右走即可
        return 1 + dfs(m,n,i+1,j,k,visited) + dfs(m,n,i,j+1,k,visited);
    }
}
