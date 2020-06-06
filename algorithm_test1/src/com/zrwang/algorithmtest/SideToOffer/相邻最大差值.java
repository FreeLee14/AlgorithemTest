package com.zrwang.algorithmtest.SideToOffer;

import java.util.Arrays;

public class 相邻最大差值 {
    public static void main(String[] args) {
        int[] A = new int[]{1,10,4,57,9,11};
        int n;
        int maxDivision = findMaxDivision(A, 6);
        System.out.println(maxDivision);
    }
    public static int findMaxDivision(int[] A, int n) {
        if (n == 0) return 0;
        Arrays.sort(A);
        int maxDiv = 0;
        int left = 0;
        int right = 1;
        while (right < n){
            int div = A[right] - A[left];
            maxDiv = Math.max(div,maxDiv);
            left++;
            right++;
        }
        return maxDiv;
    }
}
