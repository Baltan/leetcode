package leetcode.algorithms;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Description: 3081. Replace Question Marks in String to Minimize Its Value
 *
 * @author Baltan
 * @date 2024/3/18 22:24
 */
public class MinimizeStringValue {
    public static void main(String[] args) {
        System.out.println(minimizeStringValue("abcdefghijklmnopqrstuvwxy??"));
        System.out.println(minimizeStringValue("???"));
        System.out.println(minimizeStringValue("a?a?"));
    }

    public static String minimizeStringValue(String s) {
        char[] charArray = s.toCharArray();
        /**
         * counts[0]-count[25]依次表示字符串s中字符a-z的个数
         */
        int[] counts = new int[26];
        /**
         * counts[0]-count[25]依次表示替换字符串s中的"?"的字符a-z的个数
         */
        int[] replacements = new int[26];
        /**
         * 将所有小写字母的索引（0-25）优先按照在字符串s中出现的次数升序排列，如果出现次数相同则按照索引大小升序排列
         */
        Queue<Integer> pq = new PriorityQueue<>((x, y) -> counts[x] == counts[y] ? x - y : counts[x] - counts[y]);
        /**
         * 将要替换字符串s中的"?"的小写字母的索引
         */
        int replacementIndex = 0;
        /**
         * 对初始时字符串s中字符a-z的个数计数
         */
        for (char c : charArray) {
            if (c == '?') {
                continue;
            }
            counts[c - 'a']++;
        }
        /**
         * 将所有小写字母的索引排序
         */
        for (int i = 0; i < 26; i++) {
            pq.offer(i);
        }
        /**
         * 对于最终字符串s的分数而言，某一个出现n次的小写字母的总得分只与它出现的次数有关，与位置无关，因为这些小写字母的得分依次为[0,n-1]。
         * 所以，总是希望替换"?"的小写字母最终在字符串s中出现的次数越少越好。又因为多种方案时，希望最终字符串s的字典顺序最小，所以优先选择当
         * 前字符串s中出现次数最少的字母替换"?"，如有多种字母可选则选择字典顺序最小的
         */
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '?') {
                int index = pq.poll();
                /**
                 * 更新字符串s中小写字母(char)('a'+index)出现的次数
                 */
                counts[index]++;
                /**
                 * 更新替换字符串s中的"?"的小写字母(char)('a'+index)的个数
                 */
                replacements[index]++;
                pq.offer(index);
            }
        }
        /**
         * 将已知将要被替换进字符串s中的所有小写字母按照字典顺序逐个替换s中"?"
         */
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '?') {
                /**
                 * 找到下一个将要替换字符串s中的"?"的小写字母的索引
                 */
                while (replacements[replacementIndex] == 0) {
                    replacementIndex++;
                }
                charArray[i] = (char) ('a' + replacementIndex);
                replacements[replacementIndex]--;
            }
        }
        return new String(charArray);
    }
}
