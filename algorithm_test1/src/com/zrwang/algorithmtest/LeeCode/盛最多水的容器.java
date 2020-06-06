package com.zrwang.algorithmtest.LeeCode;

import java.util.*;

/**
 * leecode 11
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 */
public class 盛最多水的容器 {

    public static void main(String[] args) {

        int[] arr = {1,8,6,2,5,4,8,3,7};

        int area = maxArea(arr);
        System.out.println(area);
    }

    /**
     * 进行双指针的解法,双指针的解答思路是舍弃短板，首先从左右两边开始计算能容纳多少雨水，之后判断这两个指针指向的柱子的高度哪个最低，然后将指向较低柱子的指针进行向内移动
     * 这样就排除了这个短板，如果相等，我这里是将低位指针向前移动，这种舍弃短板的思路将所有可能的面积存在一个容器当中，最后找最大值时间较之前枚举所有的可能时间缩短n倍的一个量级
     * 时间复杂度: O(n)
     * @param arr
     * @return
     */
    private static int maxArea(int[] arr) {
        int low = 0;
        int hight = arr.length - 1;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        while (low < hight){
            int min = Math.min(arr[low], arr[hight]);
            int area = min * (hight - low);
            map.put(area,area);
            if (arr[low] > arr[hight]){
                hight -= 1;
            }else if(arr[low] < arr[hight]){
                low += 1;
            }else{
                low += 1;
            }
        }
        return map.lastKey();
    }

    /*private static int maxArea(int[] arr) {

        //考虑到使用list集合组后需要再进行排序，会导致时间增加，使用treemap进行存储尝试
//        List<Integer> list = new LinkedList<>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                int hight = Math.min(arr[i],arr[j]);
                int area = hight * (j - i);
                map.put(area,area);
            }
        }
//        Collections.sort(list);
//        return list.get(list.size()-1);
        return map.lastKey();
    }*/
}
