package leetcode.algorithms;

/**
 * Description: 2749. Minimum Operations to Make the Integer Zero
 *
 * @author Baltan
 * @date 2023/7/1 11:02
 */
public class MakeTheIntegerZero {
    public static void main(String[] args) {
        System.out.println(makeTheIntegerZero(85, 42));
        System.out.println(makeTheIntegerZero(112577768, -501662198));
        System.out.println(makeTheIntegerZero(3, -2));
        System.out.println(makeTheIntegerZero(5, 7));
    }

    public static int makeTheIntegerZero(int num1, int num2) {
        /**
         * 因为num1-(num2+2^i1)-(num2+2^i2)-……-(num2+2^in)=0
         * 所以num1-n*num2=diff=2^i1+2^i2+……+2^in
         */
        for (int i = 0; ; i++) {
            long diff = num1 - (long) num2 * i;
            /**
             * 当diff小于等于0时，继续减去num2，diff只会更加小，不可能表示为若干个2的幂的和
             */
            if (diff <= 0) {
                break;
            }
            /**
             * 根据题意，任意一个2的幂至少为1，所以diff必须大于等于i；其次，如果diff可以表示为i个2的幂，则diff的二进制值中至多只有i个1
             * （当i个2的幂都不相等时，diff的二进制值中有i个1，否则小于i个，例如：0b1+0b1=0b10）
             */
            if (Long.bitCount(diff) <= i && diff >= i) {
                return i;
            }
        }
        return -1;
    }
}
