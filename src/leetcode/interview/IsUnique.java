package leetcode.interview;

/**
 * Description: 面试题 01.01. 判定字符是否唯一
 *
 * @author Baltan
 * @date 2020-03-10 14:25
 */
public class IsUnique {
    public static void main(String[] args) {
        System.out.println(isUnique("leetcode"));
        System.out.println(isUnique("abc"));
        System.out.println(isUnique("xyzx"));
        System.out.println(isUnique("xyz"));
    }

    public static boolean isUnique(String astr) {
        /**
         * value最低位为0表示'a'没有出现过，否则表示'a'出现过；
         * value倒数第2位为0表示'b'没有出现过，否则表示'b'出现过；
         * value倒数第3位为0表示'c'没有出现过，否则表示'c'出现过；
         * ……
         * value倒数第26位为0表示'z'没有出现过，否则表示'z'出现过；
         */
        long value = 0b00000000000000000000000000;
        int length = astr.length();

        for (int i = 0; i < length; i++) {
            char c = astr.charAt(i);
            /**
             * 对于字符c应当判断value的倒数第c-'a'+1位的情况，如果是1表示字符c已经出现过，返回false，否则将
             * value的该位取反，即0变为1
             */
            if ((value >> (c - 'a') & 1) == 1) {
                return false;
            } else {
                /**
                 * 将value的倒数第c-'a'+1位取反
                 */
                value ^= (1 << (c - 'a'));
            }
        }
        return true;
    }
}
