package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Description: 6. ZigZag Conversion
 * @author Baltan
 *
 * @date 2017/11/7 11:29
 */
public class Convert {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个英文字符串：");
        String string = scanner.next();
        System.out.println("请输入之字形的行数：");
        int rows = scanner.nextInt();
        System.out.println(convert(string, rows));
    }

    public static String convert(String s, int numRows) {
        String[] charArray = s.split("");
        int charNum = charArray.length;
        String resultStr = null;
        if (numRows > 1) {
            int base = numRows - 1;
            int length = 2 * base;
            StringBuffer newStr = new StringBuffer();
            ArrayList<String> arrayList = new ArrayList<String>();
            for (int i = 0; i <= base; i++) {
                for (int j = 0; j < charNum; j++) {
                    if (j % length == i || length - j % length == i) {
                        arrayList.add(charArray[j]);
                    }
                }
            }
            for (String str : arrayList) {
                newStr.append(str);
            }
            resultStr = newStr.toString();
        } else if (numRows == 1) {
            resultStr = s;
        }
        return resultStr;
    }
}
