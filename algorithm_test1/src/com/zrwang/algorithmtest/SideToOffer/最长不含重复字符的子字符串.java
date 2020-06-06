package com.zrwang.algorithmtest.SideToOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用滑动窗口的概念(底层概念依旧还是双指针的思想，借助哈希表 在移动的过程中遇到重度的字符就会更新左边的闭区间，
 * 同时每次移位都要检查当前的不重复子串的长度是否是最长的)
 */
public class 最长不含重复字符的子字符串 {

    public static void main(String[] args) {
        int res = lengthOfLongestSubstring("abcabcbb");
        System.out.println(res);
    }

    public static int lengthOfLongestSubstring(String s) {
        // 初始化结果
        int ans = 0;
        // 用hashmap来存储已经遍历过的字符
        Map<Character,Integer> map = new HashMap<>();
        // 定义双指针
        for (int i = 0, j = 0; j < s.length(); j++){
            if (map.containsKey(s.charAt(j))){
                // 如果哈希表中已经存在了这个字符，i就会更新
                i = Math.max(map.get(s.charAt(j)),i);
            }
            // 每次移位对比一下当前的长度是否需要更新为最长
            ans = Math.max(ans, j - i + 1);
            // 在此处存储j+1是为了在j指针遇到map中已经包含的字符时可以直接掠过重复字符，跳到重复字符的下一个位置。
            map.put(s.charAt(j),j + 1);
        }

        return ans;
    }
}
