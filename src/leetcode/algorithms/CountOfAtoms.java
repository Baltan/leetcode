package leetcode.algorithms;

import java.util.*;

/**
 * Description: 726. Number of Atoms
 *
 * @author Baltan
 * @date 2024/7/14 12:13
 */
public class CountOfAtoms {
    public static void main(String[] args) {
        System.out.println(countOfAtoms("Mg(H2O)N"));
        System.out.println(countOfAtoms("H2O"));
        System.out.println(countOfAtoms("Mg(OH)2"));
        System.out.println(countOfAtoms("K4(ON(SO3)2)2"));
    }

    public static String countOfAtoms(String formula) {
        StringBuilder builder = new StringBuilder();
        /**
         * 将各原子的名字按照字典顺序升序排列
         */
        Map<String, Long> treeMap = new TreeMap<>(split(formula));
        /**
         * 如果原子的数量为1，则在原子的名字后面不需要跟数字
         */
        treeMap.forEach((k, v) -> builder.append(k).append(v == 1 ? "" : v));
        return builder.toString();
    }

    /**
     * 对化学式formula进行分解并计算原子个数，并且这些原子的数量都要乘以subscript
     *
     * @param formula
     * @param subscript
     * @return
     */
    public static Map<String, Long> help(String formula, long subscript) {
        Map<String, Long> countMap = new HashMap<>();

        if (formula.length() == 1 || (formula.length() == 2 && Character.isUpperCase(formula.charAt(0)) && Character.isLowerCase(formula.charAt(1)))) {
            /**
             * 如果字符串formula的长度为1（即【一个大写字母】的形式）或【一个大写字母+一个小写字母】的形式，则formula本身是一个原子的名字，
             * 不能再进行拆分，可以直接对这个原子进行计数
             */
            countMap.put(formula, subscript);
        } else {
            /**
             * 对化学式formula进行分解并计算原子个数，并且这些原子的数量都要乘以subscript
             */
            split(formula).forEach((k, v) -> countMap.put(k, v * subscript));
        }
        return countMap;
    }

    /**
     * 将化学式formula拆分为若干个相互连接的更小的化学式进行原子的计数
     *
     * @param formula
     * @return
     */
    public static Map<String, Long> split(String formula) {
        Map<String, Long> countMap = new HashMap<>();
        int index = formula.length() - 1;

        while (index >= 0) {
            /**
             * 如果化学式末尾是数字，说明这部分化学式为【"("+一段化学式+")"+数字】或【一个原子的名字+数字】的形式
             */
            if (Character.isDigit(formula.charAt(index))) {
                /**
                 * 化学式末尾的数字
                 */
                int value = 0;
                int weight = 1;
                /**
                 * 从后向前判断每个字符，直到遇到不是数字的字符为止，此时可以完整得到化学式末尾的数字value
                 */
                while (Character.isDigit(formula.charAt(index))) {
                    value += weight * (formula.charAt(index) - '0');
                    weight *= 10;
                    index--;
                }
                /**
                 * 数字前面是")"，说明这部分化学式为【"("+一段化学式+")"+数字】的形式
                 */
                if (formula.charAt(index) == ')') {
                    /**
                     * 这部分化学式中最后一个")"的索引值
                     */
                    int end = index;
                    /**
                     * 从后向前查找这部分完整的化学式，每次遇到")"将brackets加1，遇到"("将brackets减1，否则brackets不变
                     */
                    int brackets = 1;
                    /**
                     * 从后向前查找这部分完整的化学式，直到brackets为0为止，此时刚好得到这部分化学式的第一个"("的索引值
                     */
                    while (brackets != 0) {
                        index--;
                        brackets += formula.charAt(index) == '(' ? -1 : (formula.charAt(index) == ')' ? 1 : 0);
                    }
                    /**
                     * 对第一个"("和")"之间的这部分化学式formula.substring(index+1,end)进行原子的计数，并且这些原子的数量都要乘以
                     * value
                     */
                    help(formula.substring(index + 1, end), value)
                            .forEach((k, v) -> countMap.put(k, countMap.getOrDefault(k, 0L) + v));
                    index--;
                    /**
                     * 数字前面是一个小写字母，说明这部分化学式为【一个大写字母+一个小写字母+数字】的形式
                     */
                } else if (Character.isLowerCase(formula.charAt(index))) {
                    help(formula.substring(index - 1, index + 1), value)
                            .forEach((k, v) -> countMap.put(k, countMap.getOrDefault(k, 0L) + v));
                    index -= 2;
                    /**
                     * 数字前面是一个大写字母，说明这部分化学式为【一个大写字母+数字】的形式
                     */
                } else {
                    help(formula.substring(index, index + 1), value)
                            .forEach((k, v) -> countMap.put(k, countMap.getOrDefault(k, 0L) + v));
                    index--;
                }
                /**
                 * 如果化学式末尾是小写字母，说明这部分化学式为【一个大写字母+一个小写字母】的形式，这部分化学式本身就是一个原子的名字
                 */
            } else if (Character.isLowerCase(formula.charAt(index))) {
                String atom = formula.substring(index - 1, index + 1);
                countMap.put(atom, countMap.getOrDefault(atom, 0L) + 1);
                index -= 2;
                /**
                 * 如果化学式末尾是大写字母，说明这部分化学式为【一个大写字母】的形式，这部分化学式本身就是一个原子的名字
                 */
            } else if (Character.isUpperCase(formula.charAt(index))) {
                String atom = formula.substring(index, index + 1);
                countMap.put(atom, countMap.getOrDefault(atom, 0L) + 1);
                index--;
                /**
                 * 如果化学式末尾是")"，说明这部分化学式为【"("+一段化学式+")"+数字】的形式
                 */
            } else {
                /**
                 * 这部分化学式中最后一个")"的索引值
                 */
                int end = index;
                /**
                 * 从后向前查找这部分完整的化学式，每次遇到")"将brackets加1，遇到"("将brackets减1，否则brackets不变
                 */
                int brackets = 1;
                /**
                 * 从后向前查找这部分完整的化学式，直到brackets为0为止，此时刚好得到这部分化学式的第一个"("的索引值
                 */
                while (brackets != 0) {
                    index--;
                    brackets += formula.charAt(index) == '(' ? -1 : (formula.charAt(index) == ')' ? 1 : 0);
                }
                /**
                 * 对第一个"("和")"之间的这部分化学式formula.substring(index+1,end)进行原子的计数，并且这些原子的数量都要乘以1
                 */
                help(formula.substring(index + 1, end), 1)
                        .forEach((k, v) -> countMap.put(k, countMap.getOrDefault(k, 0L) + v));
                index--;
            }
        }
        return countMap;
    }
}
