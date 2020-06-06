package com.zrwang.algorithmtest.LeeCode;

import sun.java2d.pipe.RegionIterator;

import java.util.Stack;

/**
 * 42 难度：困难 详细题目见lc第42题
 */
public class 接雨水 {

    public static void main(String[] args) {

        int[] height = new int[]{4, 3, 1, 0, 1, 2, 4};

        int cap = trap(height);

        System.out.println(cap);

    }

    /**
     * 采用双指针的方式进行求解
     */
    private static int trap(int[] height) {
        int ltemp = 0;
        int rtemp = 0;
        int left= 0;
        int right = height.length - 1;
        int ans = 0;
        while (left <= right){
            // 对比两边的挡板
            if (ltemp < rtemp){
                // 如果左边的挡板较低的话，就以左边挡板为基准进行计算
                ans += ltemp - height[left] > 0 ? ltemp - height[left] : 0;
                ltemp = Math.max(ltemp, height[left]);
                left += 1;
            }else {
                // 如果是右边挡板较低的话，就以右边挡板为基准进行计算
                ans += rtemp - height[right] > 0 ? rtemp - height[right] : 0;
                //更新我们右边的挡板高度
                rtemp = Math.max(rtemp,height[right]);
                right -= 1;
            }

        }
        return ans;
    }

    /**
     * 采用单调栈的思想计算接雨量
     * @param height
     * @return
     */
    /*private static int trap(int[] height) {

        Stack<Integer> stack = new Stack<>();
        // 初始化面积
        int ans = 0;
        // 初始化高度差
        int dis = 0;
        // 记录上一个索引值
        int preIndex = 0;

        for (int i = 0; i < height.length; i++){
            // 如果栈不为null并且栈顶索引对应数值小于当前值则进行循环，否则直接进栈
            while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                // 先弹出栈顶元素并记录这个元素的索引
                preIndex = stack.pop();
                // 如果后续的栈顶索引对应值等于当前值则都弹出
                while (!stack.isEmpty() && height[preIndex] == height[stack.peek()]){

                    stack.pop();

                }
                // 当栈不为空时进行接雨量的计算
                if (!stack.isEmpty()){

                    dis = i - stack.peek() - 1;

                    ans += (Math.min(height[i],height[stack.peek()]) - height[preIndex]) * dis;

                }

            }

            stack.push(i);
        }

        return ans;

    }*/




}
