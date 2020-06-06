package com.zrwang.algorithmtest.SideToOffer;

import java.util.Arrays;

public class 调整数组顺序使奇数位于偶数前面 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        int[] exchange = exchange(nums);
        System.out.println(Arrays.toString(exchange));
    }

    public static int[] exchange(int[] nums) {
        if(nums.length == 0) return null;
        int length = nums.length;
        int[] res = new int[length];
        // 使用双指针
        int odd = 0;
        int even = length - 1;
        int index = 0;

        while(index < length){
            if (nums[index] % 2 != 0){
                res[odd] = nums[index];
                index++;
                odd++;
            }else{
                res[even] = nums[index];
                index++;
                even--;
            }
        }

        return res;
    }
}
