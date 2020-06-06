package com.zrwang.algorithmtest.LeeCode;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 面试题 01.07
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 *
 * 不占用额外内存空间能否做到？
 * 首先按照矩阵的对角线进行对称位置数字的替换，之后进行以每一行的中心进行对称位置的替换
 */
public class 旋转矩阵 {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};

//        rotate(matrix);

        String str = "dog";

        Method m = str.getClass().getMethod("toUpperCase");

        String invoke = (String) m.invoke(str);

        System.out.println(invoke);

    }

    private static void rotate(int[][] matrix) {
        // 针对对角线进行对称位置数据的互换
        for (int j = 0; j < matrix.length; j++){
            for (int i = j ; i >= 0; i--){
                // 如果是对角线位置的数字，则直接跳过
                if (i == j)
                    continue;
                // 用临时变量先存储一个数据
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 以每一行的中心进行互换位置
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length / 2; j++ ){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 -j];
                matrix[i][matrix.length - 1 -j] = temp;
            }
        }
        for (int[] item: matrix)
            System.out.println(Arrays.toString(item));
    }
}
