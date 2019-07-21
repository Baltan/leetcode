package leetcode.algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Description: 990. Satisfiability of Equality Equations
 *
 * @author Baltan
 * @date 2019-07-21 10:18
 */
public class EquationsPossible {
    public static void main(String[] args) {
        String[] equations1 = {"a==b", "b!=a"};
        System.out.println(equationsPossible(equations1));

        String[] equations2 = {"b==a", "a==b"};
        System.out.println(equationsPossible(equations2));

        String[] equations3 = {"a==b", "b==c", "a==c"};
        System.out.println(equationsPossible(equations3));

        String[] equations4 = {"a==b", "b!=c", "c==a"};
        System.out.println(equationsPossible(equations4));

        String[] equations5 = {"c==c", "b==d", "x!=z"};
        System.out.println(equationsPossible(equations5));

        String[] equations6 = {"c==c", "f!=a", "f==b", "b==c"};
        System.out.println(equationsPossible(equations6));

        String[] equations7 = {"a==b", "e==c", "b==c", "a!=e"};
        System.out.println(equationsPossible(equations7));
    }

    public static boolean equationsPossible(String[] equations) {
        Set<Character>[] sets = new Set[26];
        /**
         * 定义一个数组包含26个Set，
         * 第0个Set存储和变量a相等的变量值，
         * 第1个Set存储和变量b相等的变量值，
         * 第2个Set存储和变量c相等的变量值，
         * ……
         * 第25个Set存储和变量z相等的变量值
         */
        for (int i = 0; i < 26; i++) {
            sets[i] = new HashSet<>();
        }

        for (String equation : equations) {
            char variable1 = equation.charAt(0);
            char variable2 = equation.charAt(3);
            char sign = equation.charAt(1);
            /**
             * 出现相同变量的不等式，直接返回false
             */
            if (variable1 == variable2 && sign == '!') {
                return false;
            }
            /**
             * 先处理左右的等式：
             * 将等式两边的变量各自加入对应的Set中
             */
            if (sign == '=') {
                sets[variable1 - 'a'].add(variable2);
                sets[variable2 - 'a'].add(variable1);
            }
        }

        for (String equation : equations) {
            char sign = equation.charAt(1);
            /**
             * 再处理所有的不等式：
             * 对于每一个不等式，若左边的变量为variable1，右边的变量为variable2，
             * 如果在和variable1相等的变量中找到了variable2，返回false，
             * 若没找到，如果和variable1相等的变量有v3、v4、v5、v6……
             * 需要在和v3、v4、v5、v6相等的变量中继续查找，如果找到了variable2，返回false，
             * 如果都没有找到variable2，说明该不等式可以成立，可以继续判定下一个不等式，
             * 如果所有不等式都可以成立，返回true
             */
            if (sign == '!') {
                char variable1 = equation.charAt(0);
                char variable2 = equation.charAt(3);
                boolean[] book = new boolean[26];
                Queue<Character> queue = new LinkedList<>();
                queue.offer(variable1);

                while (!queue.isEmpty()) {
                    char c = queue.poll();
                    book[c - 'a'] = true;

                    if (sets[c - 'a'].contains(variable2)) {
                        return false;
                    }

                    for (char c1 : sets[c - 'a']) {
                        if (!book[c1 - 'a']) {
                            queue.offer(c1);
                        }
                    }
                }
            }
        }
        return true;
    }
}
