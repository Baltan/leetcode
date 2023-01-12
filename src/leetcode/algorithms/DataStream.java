package leetcode.algorithms;

/**
 * Description: 2526. Find Consecutive Integers from a Data Stream
 *
 * @author Baltan
 * @date 2023/1/8 12:22
 */
public class DataStream {
    private int value;
    private int k;
    /**
     * 数据流的最后一个数字
     */
    private int digit;
    /**
     * 数据流最后一个数字在尾部连续出现的次数
     */
    private int count;

    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
        this.digit = 0;
        this.count = 0;
    }

    public boolean consec(int num) {
        /**
         * 加入num后，数据流尾部有count个相同的数字digit
         */
        if (digit == num) {
            count++;
        } else {
            digit = num;
            count = 1;
        }
        return digit == value && count >= k;
    }

    public static void main(String[] args) {
        DataStream dataStream1 = new DataStream(4, 3);
        System.out.println(dataStream1.consec(4));
        System.out.println(dataStream1.consec(4));
        System.out.println(dataStream1.consec(4));
        System.out.println(dataStream1.consec(3));
    }
}
