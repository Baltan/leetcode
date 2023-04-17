package leetcode.algorithms;

/**
 * Description: 2645. Minimum Additions to Make Valid String
 *
 * @author Baltan
 * @date 2023/4/16 13:34
 */
public class AddMinimum {
    public static void main(String[] args) {
        System.out.println(addMinimum("b"));
        System.out.println(addMinimum("aaa"));
        System.out.println(addMinimum("abc"));
    }

    public static int addMinimum(String word) {
        int result = 0;
        char[] charArray = word.toCharArray();
        int length = charArray.length;
        /**
         * 将字符串word变为有效字符串后，每一位上的字符
         */
        char target = 'a';

        for (int i = 0; i < length; ) {
            if (charArray[i] != target) {
                /**
                 * 当前字符charArray[i]和目标字符target，只能进行一次插入操作插入字符target
                 */
                result++;
            } else {
                /**
                 * 当前字符charArray[i]和目标字符target匹配，不需要进行任何操作，继续向下匹配
                 */
                i++;
            }
            /**
             * 下一个目标字符
             */
            target = target == 'a' ? 'b' : (target == 'b' ? 'c' : 'a');
        }
        /**
         * 有效字符后缀也必须是"abc"，如果当前后缀是"ab"，需要进行一次插入操作追加字符c；如果当前后缀是"a"，需要进行两次插入操作追加字符b和c
         */
        return result + (target == 'a' ? 0 : (target == 'b' ? 2 : 1));
    }
}
