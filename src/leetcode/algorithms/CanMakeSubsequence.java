package leetcode.algorithms;


/**
 * Description: 2825. Make String a Subsequence Using Cyclic Increments
 *
 * @author Baltan
 * @date 2023/8/21 21:53
 */
public class CanMakeSubsequence {
    public static void main(String[] args) {
        System.out.println(canMakeSubsequence("om", "nm"));
        System.out.println(canMakeSubsequence("abc", "abcd"));
        System.out.println(canMakeSubsequence("abc", "ad"));
        System.out.println(canMakeSubsequence("zc", "ad"));
        System.out.println(canMakeSubsequence("ab", "d"));
    }

    public static boolean canMakeSubsequence(String str1, String str2) {
        /**
         * 如果str1的长度小于str2，在对str1进行操作后，长度不可能更大，所以肯定无法得到str2
         */
        if (str1.length() < str2.length()) {
            return false;
        }
        int index1 = 0;
        int index2 = 0;
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        while (index2 < charArray2.length) {
            /**
             * 假设str2当前指向的字符为c，移动str1的指针，直到遇到一个字符等于c或比c小1或比c大25
             */
            while (index1 < charArray1.length && charArray1[index1] != charArray2[index2] && charArray2[index2] - charArray1[index1] != 1 && charArray1[index1] - charArray2[index2] != 25) {
                index1++;
            }
            /**
             * str1中没有字符可以通过操作或不变得到str2当前指向的字符，所以肯定无法通过一次操作得到str2
             */
            if (index1 == charArray1.length) {
                return false;
            }
            /**
             * 继续在str1中匹配str2当前指向的字符的下一个字符
             */
            index1++;
            index2++;
        }
        return true;
    }
}
