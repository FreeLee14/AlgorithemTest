package com.zrwang.algorithmtest.LeeCode;

import java.util.ArrayList;
import java.util.List;

public class 优美子数组 {
    // 这道题的规律是从符合条件的边界奇数位开始左边界到第一个位置的距离+1 以及右边界到最后位置的距离+1 的乘积
    //1,1,2,1,1 k = 3 前四位 1 1 2 1属于第一次达到条件的连续子数组，这时从 左边的1 的索引（0） - 数组左边索引（0） + 1   * 数组长度 -  右边边界的1的索引 + 1 就是最后要计算的一共有多少个优美子数组

    public static void main(String[] args) {
        int [] nums = {1,1,2,1,1,1};
        int i = numberOfSubarrays(nums, 2);
        System.out.println(i);
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        List<Integer> loc = new ArrayList<>();
        int ans = 0;

        loc.add(-1);
        for(int i=0; i<nums.length; i++) {
            if(nums[i] % 2 == 1) {
                loc.add(i);//区间下标
            }
        }
        loc.add(nums.length);

        for(int i=k; i<loc.size()-1; i++) {
            int left = loc.get(i-k+1) - loc.get(i-k);//前缀区间数目
            int right = loc.get(i+1) - loc.get(i);//后缀区间数目
            ans += left * right;
        }

        return ans;
    }
}
