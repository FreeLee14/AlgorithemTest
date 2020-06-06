package com.zrwang.algorithmtest.LeeCode.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**56 难度：中等
 * 给出一个区间的集合，请合并所有重叠的区间。给出一个区间的集合，请合并所有重叠的区间。
 * 我的思想：依次对比前一个数组的最后一位和邻接后一个数组的第一位，如果前一个数组的last大于后一个数组的head，那么将前一个数组的head直接赋值给后一个数组的head，然后用这个结果去进行下一次的对比
 */
public class 合并区间 {

    public static void main(String[] args) {

        int[][] intervals = new int[][]{{1,4},{0,1},{8,10},{15,18}};
        Arrays.parallelSort(intervals,Comparator.comparingInt(x -> x[0]));
        int[][] merge = merge(intervals);
        for (int[] item: merge)
            System.out.println(Arrays.toString(item));
    }

    public static int[][] merge(int[][] intervals) {

        int last = 0;
        int head = 0;
        int index = 0;
        int counts = 0;

        Arrays.parallelSort(intervals,Comparator.comparingInt(x -> x[0]));

        while(index + 1 < intervals.length){
            last = intervals[index][1];
            head = intervals[index+1][0];
            if (last >= head){

                int min = Math.min(intervals[index][0], intervals[index + 1][0]);
                intervals[index+1][0] = min;
                int max = Math.max(intervals[index][1], intervals[index + 1][1]);
                intervals[index+1][1] = max;

                intervals[index] = null;
            }
            index ++;
        }

        for (int[] item: intervals){
            if (item != null){
                counts++;
            }
        }
        int[][] result = new int[counts][2];
        counts = 0;
        for (int i = 0 ; i < intervals.length; i++){

            if (intervals[i]!= null){
                result[counts][0] = intervals[i][0];
                result[counts][1] = intervals[i][1];
                counts++;
            }

        }
        return result;

    }


}
