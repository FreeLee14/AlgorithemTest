package com.zrwang.algorithmtest.SideToOffer;

public class 割绳子二 {
    public static void main(String[] args) {
        int i = cuttingRope(120);
        System.out.println(i);

    }
    public static int cuttingRope(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n == 4) return 4;
        int mod = 1000000007;
        long res = 1;
        while (n > 4){
            res *= 3;
            res %= mod;
            n -= 3;
        }
        return (int) (res * n % mod);
    }
}

