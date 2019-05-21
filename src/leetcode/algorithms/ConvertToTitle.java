package leetcode.algorithms;

/**
 * Description: 168. Excel Sheet Column Title
 *
 * @author Baltan
 * @date 2018/1/2 10:52
 */
public class ConvertToTitle {
    public static void main(String[] args) {
        System.out.println(convertToTitle(26));
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(676));
        System.out.println(convertToTitle(677));
    }

    public static String convertToTitle(int n) {
        StringBuilder columnTitle = new StringBuilder("");
        while (n != 0) {
            columnTitle.append((char) ('A' + (n - 1) % 26));
            n = (n - 1) / 26;
        }
        return columnTitle.reverse().toString();
    }
}
