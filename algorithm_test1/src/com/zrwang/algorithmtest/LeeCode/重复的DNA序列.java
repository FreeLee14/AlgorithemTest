package com.zrwang.algorithmtest.LeeCode;

import java.util.*;

/**
 * 所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 *
 * 编写一个函数来查找 DNA 分子中所有出现超过一次的 10 个字母长的序列（子串）。
 *
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC", "CCCCCAAAAA"]
 */
public class 重复的DNA序列 {
    public static void main(String[] args) {

        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        //初步思想存储再两个set容器中，已经遍历的存放在一个容器中，然后当出现重复的10个字符串的子序列时则存放在另外一个容器，这里主要是利用了set容器的不重复性
        Set<String> characterSet = findRepeatedDnaSequences(s);

        System.out.println(Arrays.toString(characterSet.toArray()));
    }

    private static Set<String> findRepeatedDnaSequences(String s) {


        //创建两个set容器
        //这个是存放所有遍历过的10个字符长的字符串
        Set<String> iterator = new HashSet<>();
        Set<String> depeated = new HashSet<>();
        if (s.length() < 10) return depeated;

        for (int i =0 ; i <= s.length()-10; i++){

            //用一个中间变量用来存储截取的字符串
            String temp = s.substring(i,i+10);

            if (iterator.contains(temp)){

                depeated.add(temp);

            }else {

                iterator.add(temp);

            }

        }
        List<String> result = new ArrayList<>();

        for (String d: depeated){

            result.add(d);

        }
        System.out.println(result);
        return depeated;

    }

}
