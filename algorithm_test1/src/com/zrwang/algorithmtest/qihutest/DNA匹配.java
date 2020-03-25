package com.zrwang.algorithmtest.qihutest;

import java.util.Scanner;

/**
 * 有一种特殊的DNA，仅仅由核酸A和T组成，长度为n，顺次连接
 *
 * 科学家有一种新的手段，可以改变这种DNA。每一次，科学家可以交换该DNA上两个核酸的位置，也可以将某个特定位置的核酸修改为另一种核酸。
 *
 * 现在有一个DNA，科学家希望将其改造成另一种DNA，希望你计算最少的操作次数。这个题主要是找规律
 */
public class DNA匹配 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入第一个DNA序列");
        String s = scanner.nextLine();
        System.out.println("请输入目标DNA序列");
        String o = scanner.nextLine();

        int counts = dnaMatch(s , o);

        System.out.println(counts);


    }

    private static int dnaMatch(String s, String o) {

        int counts = 0;
        int sNum = 0 , oNum = 0;
        //开始遍历字符串
        for (int i = 0; i < s.length(); i++){
            //对比同一个位置的两个值
            if (s.charAt(i) != o.charAt(i)){
                //如果第一个DNA序列中与目标DNA序列的相同位置字符不同，且第一个序列的这个位置为A，则让其中一个中间变量+1（代表需要交换一次）
                if (s.charAt(i) == 'A') sNum++;
                // 否则让T对应的不一致的这组数据进行+1（代表需要交换一次）
                else oNum++;

            }

        }
        //选取其中最大的那一个，则为总体交换次数最小的，具体的可以画图象进行剖析验证
        counts = Math.max(sNum, oNum);

        return counts;

    }
}
