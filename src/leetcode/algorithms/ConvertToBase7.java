package leetcode.algorithms;

/**
 * Description:Base 7
 *
 * @author Baltan
 * @date 2018/1/4 14:54
 */
public class ConvertToBase7 {
    public static void main(String[] args) {
        System.out.println(convertToBase7(100));
        System.out.println(convertToBase7(-7));
        System.out.println(convertToBase7(0));
    }

    public static String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        int numAbsoluteValue = Math.abs(num);
        StringBuilder sb = new StringBuilder();
        while (numAbsoluteValue > 0) {
            int remainder = numAbsoluteValue % 7;
            sb.append(remainder);
            numAbsoluteValue = numAbsoluteValue / 7;
        }
        String numBase7 = num >= 0 ? sb.reverse().toString() : "-" + sb.reverse().toString();
        return numBase7;
    }
}
