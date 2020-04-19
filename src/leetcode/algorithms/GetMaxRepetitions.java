package leetcode.algorithms;

/**
 * Description: 466. Count The Repetitions
 *
 * @author Baltan
 * @date 2020-04-19 11:06
 */
public class GetMaxRepetitions {
    public static void main(String[] args) {
        System.out.println(getMaxRepetitions("baba", 11, "baab", 1));
        System.out.println(getMaxRepetitions("aaa", 3, "aa", 1));
        System.out.println(getMaxRepetitions("acb", 4, "ab", 2));
        System.out.println(getMaxRepetitions(
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                1000000,
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                1000000));
    }

    /**
     * 参考：
     * <a href="https://leetcode-cn.com/problems/count-the-repetitions/solution/javajie-fa-by-liu-jia-liang-9/"></a>
     *
     * @param s1
     * @param n1
     * @param s2
     * @param n2
     * @return
     */
    public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        /**
         * s2的索引
         */
        int index = 0;
        /**
         * 当前使用的s1的个数
         */
        int count1 = 0;
        /**
         * 当前匹配到的s2的个数
         */
        int count2 = 0;
        int length1 = s1.length();
        int length2 = s2.length();
        /**
         * 计算[s1,n1]共可匹配s2的个数
         */
        while (count1 < n1) {
            for (int i = 0; i < length1; i++) {
                /**
                 * 此处如果不使用charArray[i]，而是使用s.charAt(i)会TLE
                 */
                if (c1[i] == c2[index]) {
                    /**
                     * 如果此时匹配到s2的最后一个字符了从头开始匹配s2
                     */
                    if (index == length2 - 1) {
                        index = 0;
                        count2++;
                    } else {
                        index++;
                    }
                }
            }
            count1++;
        }
        return count2 / n2;
    }
}
