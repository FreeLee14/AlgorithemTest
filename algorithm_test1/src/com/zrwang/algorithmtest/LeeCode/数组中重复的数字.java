package com.zrwang.algorithmtest.LeeCode;

import java.util.Arrays;

/**
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 *
 */
public class 数组中重复的数字 {

    public static void main(String[] args) {

        int [] nums = new int[]{0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        int result = findRepeatNumber(nums);

        System.out.println(result);

    }

    /**
     * 为了降低时间复杂度，采用二分查找法进行对比数据
     * @param nums
     * @return
     */

    public static int findRepeatNumber(int[] nums) {

        int result = -1;

        Arrays.sort(nums);

        if(nums != null || nums.length > 0){


            for (int i = 0; i < nums.length; i++){
                //外层循环获取当前要去数组中对比的数值
                int compare = nums[i];
                //我们先将获取到的值的位置进行更改为整型的最大值
                nums[i] = Integer.MAX_VALUE;
                // 这里我们利用数组工具类中的二分查找法进行获取要比较的数字是否还存在其他的数组下标。
                int index = Arrays.binarySearch(nums, compare);

                if(index < 0){
                    // 如果没有对应的重复的值，我们将原来的数据恢复
                    nums[i] = compare;

                }else{

                    result = nums[index];
                    System.out.println(index);
                    nums[i] = compare;
                    break;

                }

            }

        }

        return result;

    }

}
