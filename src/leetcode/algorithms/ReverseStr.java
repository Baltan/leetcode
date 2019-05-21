package leetcode.algorithms;

/**
 * Description: 541. Reverse String II
 *
 * @author Baltan
 * @date 2017/11/24 10:57
 */
public class ReverseStr {
    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));
    }

    public static String reverseStr(String s, int k) {
        String[] sArr = s.split("");
        for (int start = 0; start < sArr.length; start += 2 * k) {
            int end = start + k - 1 > sArr.length - 1 ? sArr.length - 1 : start + k - 1;
            for (int i = start; i < (start + end) / 2.0; i++) {
                String temp = sArr[i];
                sArr[i] = sArr[start + end - i];
                sArr[start + end - i] = temp;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String str : sArr) {
            sb.append(str);
        }
        return sb.toString();
    }
}
