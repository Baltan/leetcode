package leetcode.algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Description: 1625. Lexicographically Smallest String After Applying Operations
 *
 * @author Baltan
 * @date 2022/10/1 10:47
 */
public class FindLexSmallestString {
    public static void main(String[] args) {
        System.out.println(findLexSmallestString("5525", 9, 2));
        System.out.println(findLexSmallestString("74", 5, 1));
        System.out.println(findLexSmallestString("0011", 4, 2));
        System.out.println(findLexSmallestString("43987654", 7, 3));
    }

    /**
     * 参考：
     * <a href="https://leetcode.cn/problems/lexicographically-smallest-string-after-applying-operations/solution/chang-gui-bfsji-ke-by-kobe24o-2/"></a>
     *
     * @param s
     * @param a
     * @param b
     * @return
     */
    public static String findLexSmallestString(String s, int a, int b) {
        String result = s;
        int length = s.length();
        Queue<String> queue = new LinkedList<>();
        /**
         * 记录已经得到过的字符串
         */
        Set<String> isVisited = new HashSet<>();
        queue.offer(s);
        isVisited.add(s);

        while (!queue.isEmpty()) {
            String str = queue.poll();

            if (str.compareTo(result) < 0) {
                result = str;
            }
            char[] chars = str.toCharArray();
            /**
             * 将chars中的元素都向右移动b个位置得到的新数组
             */
            char[] rotateChars = new char[length];
            System.arraycopy(chars, b, rotateChars, 0, length - b);
            System.arraycopy(chars, 0, rotateChars, length - b, b);
            String rotateS = new String(rotateChars);

            if (!isVisited.contains(rotateS)) {
                queue.offer(rotateS);
                isVisited.add(rotateS);
            }
            /**
             * 将chars中奇数索引位置的元素都加上a后得到的新数组
             */
            char[] addChars = chars.clone();

            for (int i = 1; i < length; i += 2) {
                addChars[i] = (char) ((addChars[i] - '0' + a) % 10 + '0');
            }
            String addS = new String(addChars);

            if (!isVisited.contains(addS)) {
                queue.offer(addS);
                isVisited.add(addS);
            }
        }
        return result;
    }
}
