package com.zrwang.algorithmtest.LeeCode;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums，请你将该数组升序排列。
 *  使用时间复杂度较低的排序方法进行实现，不采用JavaAPI内部提供的接口
 */
public class 排序数组 {

    public static void main(String[] args) {

        int[] nums = new int[]{5,1,1,2,0,0};

        int[] arr = quickSort(nums);

        System.out.println(Arrays.toString(arr));
    }

    private static int[] quickSort(int[] nums) {

        int[] arr = new int[nums.length];
        // 如果数组长度为0或者数组本身为空则直接返回一个空数组
        if (nums.length == 0 || nums == null){

            return arr;

        }
        int start = 0;
        int end = nums.length-1;
        arr = quickSortRecursive(nums,start,end);

        return arr;
    }

    private static int[] quickSortRecursive(int[] nums, int start, int end) {

        // 基线条件，当开始位置小于结束位置时就不再进行递归
        if (start < end){

            int low = start;
            int height = end;
            // 默认将开始位置作为标准数
            int standerd = nums[start];
            // 开始进行快排
            while (low < height) {
                // 先从高位开始对比,如果地位坐标小于高位坐标，标准数小于等于从高位递减坐标的数，则持续将高位索引递减
                while (low < height && standerd <= nums[height]){
                    height--;
                }
                // 直到跳出循环时说明高位的数字比标准数要小，这时低位索引的值要被赋值为这个值
                nums[low] = nums[height];
                // 开始从低位向高位开始遍历对比标准数，直到大于标准数的数字出现
                while (low < height && standerd >= nums[low]){
                    low++;
                }
                // 从低位开始增量遍历时如果出现大于标准数的数字，则将这个数字赋值给高位
                nums[height] = nums[low];

            }
            // 直到最后low和height相等则跳出了循环，将标准数赋值到这个位置
            nums[low] = standerd;
            // 递归调用自身方法，开始分别进行以标准数为分界线的左半部分和右半部分的排序
            // 左边
            quickSortRecursive(nums,start,low);
            quickSortRecursive(nums,low+1,end);

        }

        return nums;
    }
}
