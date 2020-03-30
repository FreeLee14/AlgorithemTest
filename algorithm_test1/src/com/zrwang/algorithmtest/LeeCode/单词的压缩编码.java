package com.zrwang.algorithmtest.LeeCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 *
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 *
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 *
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 *
 * 该题最后考虑使用循环对比字符串是否包另外一个进行解答，（注意：只有结尾部分较长的那个单词包含另外一个单词，才可以进行省略那个被包含的单词，考虑单词尾缀重复，前缀如果重复是不能进行分割的）
 *  测试用例："time", "me", "bell"
 */
public class 单词的压缩编码 {

    public static void main(String[] args) {

        String[] words = new String[]{"time","me","abe","el","bell"};

        int length = minimumLengthEncoding(words);

        System.out.println(length);

//        testContain();
    }

    // 采用官方题解中的字典树解法,创建一个字典数，每一个节点是一个26位的数组
    private static int minimumLengthEncoding(String[] words) {

        // 初始化一个单词树
        TrieNode trie = new TrieNode();
        // 创建一个字典用来存储一个单词的子树和其对应的索引
        HashMap<TrieNode,Integer> map = new HashMap<>();
        // 初始化最后单词的长度
        int length = 0;

        for (int i = 0; i < words.length; i++){

            String word = words[i];
            // 每次存储新单词，创建一个新的字典树子树分支
            TrieNode cur = trie;
            // 存储这个单词需要倒着进行存放
            for (int j = word.length()-1; j >= 0; j--){
                // 开始组建每个单词分支
                cur = cur.get(word.charAt(j));

            }
            // 形成我们所需要的字典
            map.put(cur,i);

        }
        // 遍历我们的字典，取出在创建单词子树时最后一个单词的位数，表示这个单词的长度
        for (TrieNode key: map.keySet()){

            if (key.count == 0){

                length += words[map.get(key)].length() + 1;

            }

        }
        return length;

    }




   /* private static int minimumLengthEncoding(String[] words) {

        //初始化最后非重复单词的长度总和
        int length = 0;

        for (int i = 0; i < words.length; i++){

            // 开始内部循环之前，我们先判断是否已经存在被置null的索引，如果有直接不进入内部循环
            if (words[i] == null || words[i].length()>7 || words[i].length() < 1){
                continue;
            }
            for (int j = 0; j < words.length; j++){
                if (i == j || words[j] == null || words[j].length()>7 || words[j].length() < 1){
                    // 自己就不和自己对比了,同时也要检测内部循环时有的是否为空
                    continue;
                }
                // 判断外层循环获取到的字符串是否包含内层循环的字符串
                if (words[i].endsWith(words[j])){
                    //如果包含则将内层循环被包含的字符串置为空
                    words[j] =null;

                }


            }

        }
        // 记录一下单词个数，也就是需要加#号的个数
        int counts = 0;

        for (String item: words){

            if (item != null){
                counts++;
                length += item.length();
            }
        }
        // 补充上#长度
        length += counts;


        return length;
    }*/


    // 测试采取哪种对比方法
    public static void testContain() {

        Set<String> set = new HashSet<>();
        String start = "time";
        set.add(start);
        String temp = "timeout";
        if (start.indexOf(temp) != -1){
            System.out.println("testsuccess");
        }
    }
}
// 创建单词节点
class TrieNode {
    // 给每个节点定义一个孩子数组
    TrieNode[] children;
    int count;  // 给每个节点添加一个位数，代表当前的字母是这个单词的第几位

    public TrieNode() {
        // 初始化一个26位的孩子数组
        children = new TrieNode[26];
        count = 0;

    }

    public TrieNode get(char c){
        // 首先先判断当前位是否存在着对象
        if (children[c - 'a'] == null){
            // 没有开始进行添加
            children[c - 'a'] = new TrieNode();
            count++;

        }

        return children[c - 'a'];

    }


}
