package leetcode.algorithms;

/**
 * Description: 640. Solve the Equation
 *
 * @author Baltan
 * @date 2019-11-24 18:27
 */
public class SolveEquation {
    public static void main(String[] args) {
        System.out.println(solveEquation("x+5-3+x=6+x-2"));
        System.out.println(solveEquation("x=x"));
        System.out.println(solveEquation("2x=x"));
        System.out.println(solveEquation("2x+3x-6x=x+2"));
        System.out.println(solveEquation("x=x+2"));
        System.out.println(solveEquation("-x=-1"));
        System.out.println(solveEquation("-x=1"));
    }

    public static String solveEquation(String equation) {
        /**
         * 等式最后加一个空格可以保证下面的循环可以处理完原来等式的最后一个字符
         */
        equation += " ";
        /**
         * 一次项x的系数
         */
        int coefficient = 0;
        /**
         * 常数项系数
         */
        int constant = 0;
        /**
         * 等式左边的系数都要乘以1，等式右边的系数都要乘以-1
         */
        int factor = 1;
        StringBuilder builder = new StringBuilder();

        for (char c : equation.toCharArray()) {
            if (c >= '0' && c <= '9' || c == 'x') {
                builder.append(c);
            } else {
                int length = builder.length();
                /**
                 * 如果builder此时没有任何字符，说明等式的第一个字符就是"+"或"-"
                 */
                if (length == 0) {
                    builder.append(c);
                    continue;
                    /**
                     * 如果builder最后一个字符为"x"，如果builder的长度为1，说明builder为"x"，此时一次项x的系数
                     * 为1*factor；如果builder的长度为2并且builder第一个字符为"+"，说明builder为"+x"，此时一次
                     * 项x的系数为1*factor；如果builder的长度为2并且builder第一个字符为"-"，说明builder为"-x"，
                     * 此时一次项x的系数为-1*factor，除以上情况外，一次项x的系数为builder最后一个字符前的值*factor
                     */
                } else if (builder.charAt(length - 1) == 'x') {
                    if (length == 1) {
                        coefficient += factor;
                    } else if (length == 2 && builder.charAt(0) == '+') {
                        coefficient += factor;
                    } else if (length == 2 && builder.charAt(0) == '-') {
                        coefficient -= factor;
                    } else {
                        coefficient += Integer.valueOf(builder.substring(0, length - 1)) * factor;
                    }
                } else {
                    /**
                     * 如果builder最后一个字符不为"x"，builder的值*factor为常数项系数
                     */
                    constant += Integer.valueOf(builder.toString()) * factor;
                }

                builder = new StringBuilder();
                /**
                 * 如果此时的字符为"="，接下去的循环将开始处理等式右边的表达式，需要将factor设为-1
                 */
                if (c == '=') {
                    factor = -1;
                } else {
                    builder.append(c);
                }
            }
        }

        if (coefficient == 0 && constant != 0) {
            return "No solution";
        } else if (coefficient == 0 && constant == 0) {
            return "Infinite solutions";
        } else {
            return "x=" + (-constant / coefficient);
        }
    }
}
