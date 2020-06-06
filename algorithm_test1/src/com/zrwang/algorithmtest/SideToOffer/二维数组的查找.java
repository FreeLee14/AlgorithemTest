package com.zrwang.algorithmtest.SideToOffer;

public class 二维数组的查找 {
    public static void main(String[] args) {

        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        boolean numberIn2DArray = findNumberIn2DArray(matrix, 20);
        System.out.println(numberIn2DArray);

    }

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        //二维数组的二分查找
        for(int i = 0; i < matrix.length; i++){
            int low = 0;
            int high = matrix[i].length - 1;
            while(low <= high){
                int mid = (low + high) / 2;
                if (target == matrix[i][mid]){
                    return true;
                }
                if (target > matrix[i][mid]){
                    low = mid + 1;
                }
                if (target < matrix[i][mid]){
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}
