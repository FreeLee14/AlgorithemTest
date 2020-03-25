package com.zrwang.algorithmtest.LeeCode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 我们买了一些糖果 candies，打算把它们分给排好队的 n = num_people 个小朋友。
 *
 * 给第一个小朋友 1 颗糖果，第二个小朋友 2 颗，依此类推，直到给最后一个小朋友 n 颗糖果。
 *
 * 然后，我们再回到队伍的起点，给第一个小朋友 n + 1 颗糖果，第二个小朋友 n + 2 颗，依此类推，直到给最后一个小朋友 2 * n 颗糖果。
 *
 * 重复上述过程（每次都比上一次多给出一颗糖果，当到达队伍终点后再次从队伍起点开始），直到我们分完所有的糖果。注意，就算我们手中的剩下糖果数不够（不比前一次发出的糖果多），这些糖果也会全部发给当前的小朋友。
 *
 * 返回一个长度为 num_people、元素之和为 candies 的数组，以表示糖果的最终分发情况（即 ans[i] 表示第 i 个小朋友分到的糖果数）
 *
 */

/**
 * 解题思路：核心思想就是每次循环时需要定义一个额外的增加变量，是当前（分发次数-1）*人数，还有就是注意每次循环进行分发时需要判断当前剩余糖果数量是否符合分发数量的标准，如果不符合则将所有的糖果分发给当前数组的索引处，并将糖果书置0
 */
public class 分糖果Ⅱ {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入糖果的数量");

        int candies = sc.nextInt();

        System.out.println("请输入小朋友的数量");
        int num_people = sc.nextInt();

        int[] arr = distributeCandies(  candies,  num_people);

        System.out.println(Arrays.toString(arr));


    }

    // 定义分糖果的方法
    public static int[] distributeCandies(int candies, int num_people) {

        int[] array = new int[num_people];
        //定义一个临时变量用来记录每次额外添加的n
        int n = 0;
        //定义一个参数存储外部循环的次数
        int count = 0;
        //只要糖果不小于0就一直循环下去
        while(candies > 0){

            for (int i = 0; i < array.length; i++){

                int singleDistribute = i+n+1;

                // 先判断当前的糖果数量是否符合发放标准
                if(candies < singleDistribute){
                    //如果不符合则把当前的所有糖果的给这个小朋友
                    array[i] = candies+array[i];
                    // 把当前所有的糖果分发出去后直接给剩余糖果数量赋值为0
                    candies = 0;

                }else {
                    // 如果符合则将原本该小朋友的糖果加上新发过来的糖果对该处从新进行赋值
                    array[i] = singleDistribute+array[i];
                    candies -= (singleDistribute);
                }


            }
            // 结束完一轮分发，count记录一次
            count++;
            // 重新定义下一个分发的n的数量
            n = count*num_people;

        }

        return array;

    }
}
