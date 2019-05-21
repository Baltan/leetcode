package leetcode.algorithms;

/**
 * Description: 868. Binary Gap
 *
 * @author Baltan
 * @date 2018/7/30 21:12
 */
public class BinaryGap {
    public static void main(String[] args) {
        System.out.println(binaryGap(22));
        System.out.println(binaryGap(5));
        System.out.println(binaryGap(6));
        System.out.println(binaryGap(8));
    }

    public static int binaryGap(int N) {
        int distance = 0;
        String str = Integer.toBinaryString(N);
        int index1 = str.indexOf("1");
        int index2;
        int firstIndex = index1;
        int lastIndex = str.lastIndexOf("1");
        for (int i = firstIndex + 1; i <= lastIndex; i++) {
            if (str.charAt(i) == '1') {
                index2 = i;
                distance = index2 - index1 > distance ? index2 - index1 : distance;
                index1 = i;
            }

        }
        return distance;
    }
}
