package leetcode.algorithms;

/**
 * Description: 1784. Check if Binary String Has at Most One Segment of Ones
 *
 * @author Baltan
 * @date 2022/7/9 13:14
 */
public class CheckOnesSegment {
    public static void main(String[] args) {
        System.out.println(checkOnesSegment("1001"));
        System.out.println(checkOnesSegment("110"));
    }

    public static boolean checkOnesSegment(String s) {
        /**
         * 字符串s中是否出现过"0"
         */
        boolean hasZero = false;
        /**
         * 因为字符串s中没有前导0，所以肯定以"1"开头，如果遍历s的过程中在"0"后面出现了"1"，则至少就有两个由若干"1"组成的连续字
         * 段，直接返回false
         */
        for (char c : s.toCharArray()) {
            if (c == '0') {
                hasZero = true;
            } else if (hasZero) {
                return false;
            }
        }
        return true;
    }
}
