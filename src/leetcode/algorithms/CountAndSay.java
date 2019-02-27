package leetcode.algorithms;

/**
 * Description: Count and Say
 *
 * @author Baltan
 * @date 2018/8/9 21:35
 */
public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
        System.out.println(countAndSay(7));
    }

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        } else if (n == 2) {
            return "11";
        }
        String preString = countAndSay(n - 1);
        char[] preCharArray = preString.toCharArray();
        int length = preCharArray.length;
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i < length; i++) {
            if (preCharArray[i] == preCharArray[i - 1]) {
                count++;
                if (i == length - 1) {
                    sb.append(count).append(preCharArray[i]);
                }
            } else {
                sb.append(count).append(preCharArray[i - 1]);
                count = 1;
                if (i == length - 1) {
                    sb.append(count).append(preCharArray[i]);
                }
            }
        }
        return sb.toString();
    }
}
