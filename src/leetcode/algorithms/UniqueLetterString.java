package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 828. Count Unique Characters of All Substrings of a Given String
 *
 * @author Baltan
 * @date 2020-05-29 16:44
 */
public class UniqueLetterString {
    public static void main(String[] args) {
        System.out.println(uniqueLetterString("ABC"));
        System.out.println(uniqueLetterString("ABA"));
        System.out.println(uniqueLetterString("LEETCODE"));
    }

    public static int uniqueLetterString(String s) {
        int result = 0;
        int mod = 1000000007;
        int length = s.length();
        /**
         * indexLists[i]为字符(char)(0+'A')在字符串s中出现的索引位置列表
         */
        List<Integer>[] indexLists = new List[26];

        for (int i = 0; i < 26; i++) {
            indexLists[i] = new ArrayList<>();
            /**
             * 避免对第一次出现的位置做特殊处理，假设每个字母第一次出现的索引位置为-1
             */
            indexLists[i].add(-1);
        }

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            indexLists[c - 'A'].add(i);
        }

        for (int i = 0; i < 26; i++) {
            /**
             * 避免对最后一次出现的位置做特殊处理，假设每个字母最后一次出现的索引位置为s.length
             */
            indexLists[i].add(length);
        }

        for (int i = 0; i < 26; i++) {
            List<Integer> indexList = indexLists[i];
            int size = indexList.size();
            /**
             * indexList除去头尾两个索引位置（-1和s.length），计算包含其他各个索引位置上字符的子串的个数
             */
            for (int j = 1; j < size - 1; j++) {
                /**
                 * 当前字母只出现过一次的子串的个数
                 */
                int count = 0;
                /**
                 * 以当前字母结尾且当前字母只出现过一次的子串
                 */
                count += (indexList.get(j) - indexList.get(j - 1) - 1);
                /**
                 * 当前字母子串
                 */
                count += 1;
                /**
                 * 以当前字母开头且当前字母只出现过一次的子串
                 */
                count += (indexList.get(j + 1) - indexList.get(j) - 1);
                /**
                 * 当前字母不在开头和结尾且当前字母只出现过一次的子串
                 */
                count += (indexList.get(j) - indexList.get(j - 1) - 1) *
                        (indexList.get(j + 1) - indexList.get(j) - 1);
                result = (result + count) % mod;
            }
        }
        return result;
    }
}
