package leetcode.algorithms;

/**
 * Description: 1897. Redistribute Characters to Make All Strings Equal
 *
 * @author Baltan
 * @date 2022/3/17 21:02
 */
public class MakeEqual {
    public static void main(String[] args) {
        System.out.println(makeEqual(
                new String[]{"caaaaa", "aaaaaaaaa", "a", "bbb", "bbbbbbbbb", "bbb", "cc", "cccccccccccc",
                        "ccccccc", "ccccccc", "cc", "cccc", "c", "cccccccc", "c"}));
        System.out.println(makeEqual(new String[]{"abc", "aabc", "bc"}));
        System.out.println(makeEqual(new String[]{"ab", "a"}));
        System.out.println(makeEqual(new String[]{"abbab"}));
    }

    public static boolean makeEqual(String[] words) {
        if (words.length == 1) {
            return true;
        }
        /**
         * count[0]到count[25]依次代表所有字符串中'a'到'z'各自出现的总次数
         */
        int[] count = new int[26];

        for (String word : words) {
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }
        }

        for (int num : count) {
            /**
             * 如果某个字符出现的次数不为数组words中单词数量的整数倍，一定不能使最终每个字符串都相等，直接返回false
             */
            if (num % words.length != 0) {
                return false;
            }
        }
        return true;
    }
}
