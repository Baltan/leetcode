package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 2166. Design Bitset
 *
 * @author Baltan
 * @date 2022/2/9 17:24
 */
public class Bitset {
    /**
     * 保存每一位的值
     */
    private char[] value;
    /**
     * 保存每一位翻转后的值
     */
    private char[] reversedValue;
    /**
     * 用于交换value和reversedValue
     */
    private char[] tempValue;
    /**
     * value中值为0的位数
     */
    private int zeroCount;
    /**
     * value中值为1的位数
     */
    private int oneCount;
    private static final char ZERO_BIT = '0';
    private static final char ONE_BIT = '1';

    public Bitset(int size) {
        value = new char[size];
        reversedValue = new char[size];
        zeroCount = size;
        oneCount = 0;
        Arrays.fill(value, ZERO_BIT);
        Arrays.fill(reversedValue, ONE_BIT);
    }

    /**
     * 将第idx位设置为1
     *
     * @param idx
     */
    public void fix(int idx) {
        if (value[idx] != ONE_BIT) {
            value[idx] = ONE_BIT;
            reversedValue[idx] = ZERO_BIT;
            oneCount++;
            zeroCount--;
        }
    }

    /**
     * 将第idx位设置为0
     *
     * @param idx
     */
    public void unfix(int idx) {
        if (value[idx] != ZERO_BIT) {
            value[idx] = ZERO_BIT;
            reversedValue[idx] = ONE_BIT;
            oneCount--;
            zeroCount++;
        }
    }

    /**
     * 如果某位为0，则设置为1；如果某位为1，则设置为0
     */
    public void flip() {
        /**
         * 交换值为0的位数和值为1的位数
         */
        int temp = oneCount;
        oneCount = zeroCount;
        zeroCount = temp;
        /**
         * 交换value和reversedValue，相当于把value中的每一位翻转
         */
        tempValue = value;
        value = reversedValue;
        reversedValue = tempValue;
    }

    /**
     * 判断是否每位都为1
     *
     * @return
     */
    public boolean all() {
        return zeroCount == 0;
    }

    /**
     * 判断是否存在某一位为1
     *
     * @return
     */
    public boolean one() {
        return oneCount > 0;
    }

    /**
     * 值为1的位数
     *
     * @return
     */
    public int count() {
        return oneCount;
    }

    @Override
    public String toString() {
        return new String(value);
    }

    public static void main(String[] args) {
        Bitset bitset1 = new Bitset(5);
        bitset1.fix(3);
        bitset1.fix(1);
        bitset1.flip();
        System.out.println(bitset1.all());
        bitset1.unfix(0);
        bitset1.flip();
        System.out.println(bitset1.one());
        bitset1.unfix(0);
        System.out.println(bitset1.count());
        System.out.println(bitset1.toString());
    }
}
