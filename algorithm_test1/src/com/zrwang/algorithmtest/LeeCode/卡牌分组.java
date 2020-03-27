package com.zrwang.algorithmtest.LeeCode;

import javax.xml.stream.FactoryConfigurationError;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 914 卡牌分组
 * 给定一副牌，每张牌上都写着一个整数。
 *
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 *
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 *
 * 示例一
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 * 示例二
 * 输入：[1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例三
 * 输入：[1]
 * 输出：false
 * 解释：没有满足要求的分组。
 * 示例四
 * 输入：[1,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]
 * 示例五
 * 输入：[1,1,2,2,2,2]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
 * 提示： 1、1 <= deck.length <= 10000  2、0 <= deck[i] < 10000
 *
 * 解题思路： 个人大概的思路时，因为不会在结果中输出具体的分组实现，所以我采用创建一个容器用来存储不同数字的个数，最后进行求解每一种数字个数的最大公约数
 *
 */
public class 卡牌分组 {

    public static void main(String[] args) {

        int[] deck = new int[]{0,0,0,0,0,1,1,2,3,4};

        boolean result = hasGroupsSizeX(deck);

        System.out.println(result);
    }

    private static boolean hasGroupsSizeX(int[] deck) {
        // 创建出一个数组用来存储每个值的个数
        int[] count = new int[10000];

        for (int c: deck)
            count[c]++;

        int g = -1;

        for (int i = 0; i < 10000; ++i)

            if (count[i] > 0) {

                if (g == -1)
                    // 把第一个值拿进来
                    g = count[i];

                else
                    // 一次求解前一个数字的个数和当前数字个数的最大公约数
                    g = gcd(g, count[i]);

            }
        // 只有当最大公约数大于等于2时才能被划分
        return g >= 2;
    }

    public static int gcd(int x, int y) {

        return x == 0 ? y : gcd(y%x, x);

    }
}
