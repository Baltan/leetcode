package leetcode.algorithms;

/**
 * Description: 171. Excel Sheet Column Number
 *
 * @author Baltan
 * @date 2018/1/2 15:28
 */
public class TitleToNumber {
    public static void main(String[] args) {
        System.out.println(titleToNumber("A"));
        System.out.println(titleToNumber("Z"));
        System.out.println(titleToNumber("AA"));
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("YZ"));
        System.out.println(titleToNumber("ZA"));
    }

    public static int titleToNumber(String s) {
        char[] letterArr = s.toCharArray();
        int num = 0;
        for (int i = 0; i < letterArr.length; i++) {
            num += (letterArr[i] - 64) * Math.pow(26, letterArr.length - 1 - i);
        }
        return num;
    }
}
