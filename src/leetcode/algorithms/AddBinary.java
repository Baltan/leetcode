package leetcode.algorithms;

/**
 * Description: 67. Add Binary
 *
 * @author Baltan
 * @date 2017/11/24 20:58
 */
public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("0", "0"));
    }

    public static String addBinary(String a, String b) {
        int lengthA = a.length();
        int lengthB = b.length();
        int longLength = lengthA > lengthB ? lengthA : lengthB;
        int[] sumArr = new int[longLength + 1];
        int temp = 0;
        while (lengthA >= 0 || lengthB >= 0) {
            int sum = 0;
            int addentA = 0;
            int addentB = 0;
            if (lengthA >= 1) {
                addentA = Integer.valueOf(a.substring(lengthA - 1, lengthA));
            }
            if (lengthB >= 1) {
                addentB = Integer.valueOf(b.substring(lengthB - 1, lengthB));
            }
            int tempSum = addentA + addentB + temp;
            if (tempSum == 0) {
                sum = 0;
                temp = 0;
            } else if (tempSum == 1) {
                sum = 1;
                temp = 0;
            } else if (tempSum == 2) {
                sum = 0;
                temp = 1;
            } else if (tempSum == 3) {
                sum = 1;
                temp = 1;
            }
            sumArr[longLength] = sum;
            lengthA--;
            lengthB--;
            longLength--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : sumArr) {
            sb = sb.append(i);
        }
        return "0".equals(sb.toString().substring(0, 1)) ? sb.toString().substring(1) : sb.toString();
    }
}
