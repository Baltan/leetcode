package leetcode.interview;

/**
 * Description: 面试题 01.05. 一次编辑
 *
 * @author Baltan
 * @date 2020-03-11 16:24
 */
public class OneEditAway {
    public static void main(String[] args) {
        System.out.println(oneEditAway("pale", "ple"));
        System.out.println(oneEditAway("pales", "pal"));
        System.out.println(oneEditAway("teacher", "bleacher"));
    }

    public static boolean oneEditAway(String first, String second) {
        int length1 = first.length();
        int length2 = second.length();
        /**
         * 如果两个字符串长度之差大于1，肯定不能通过1次编辑使两个字符串相等
         */
        if (Math.abs(length1 - length2) > 1) {
            return false;
        }

        if (length1 == length2) {
            return replece(first, second);
        } else {
            return delete(first, second);
        }
    }

    /**
     * 判断两个长度相等的字符串对应位置上不相等的字符对数量是否大于1
     *
     * @param first
     * @param second
     * @return
     */
    public static boolean replece(String first, String second) {
        int length = first.length();
        int editCount = 0;

        for (int i = 0; i < length; i++) {
            if (first.charAt(i) != second.charAt(i)) {
                editCount++;
            }

            if (editCount > 1) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断两个长度相差1的字符串是否可以通过从较长字符串中删除一个字符得到较短字符串
     *
     * @param first
     * @param second
     * @return
     */
    public static boolean delete(String first, String second) {
        int index1 = 0;
        int index2 = 0;
        int length1 = first.length();
        int length2 = second.length();
        int editCount = 0;

        if (length1 < length2) {
            while (index1 < length1 && index2 < length2) {
                /**
                 * 如果两个字符不相等，需要从较长字符串中将当前指向的字符删除
                 */
                if (first.charAt(index1) != second.charAt(index2)) {
                    index2++;
                    editCount++;

                    if (editCount > 1) {
                        return false;
                    }
                } else {
                    index1++;
                    index2++;
                }
            }
        } else {
            while (index1 < length1 && index2 < length2) {
                /**
                 * 如果两个字符不相等，需要从较长字符串中将当前指向的字符删除
                 */
                if (first.charAt(index1) != second.charAt(index2)) {
                    index1++;
                    editCount++;

                    if (editCount > 1) {
                        return false;
                    }
                } else {
                    index1++;
                    index2++;
                }
            }
        }
        return true;
    }
}
