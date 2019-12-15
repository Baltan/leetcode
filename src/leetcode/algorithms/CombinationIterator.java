package leetcode.algorithms;

/**
 * Description: 1286. Iterator for Combination
 *
 * @author Baltan
 * @date 2019-12-15 11:55
 */
public class CombinationIterator {
    private String characters;
    private int combinationLength;
    private int length;
    /**
     * 标记组合字符串中每个字符依次在原字符串中的索引位置
     */
    private int[] indexes;
    /**
     * 是否还有下一个组合字符串
     */
    private boolean hasNext;

    public CombinationIterator(String characters, int combinationLength) {
        this.characters = characters;
        this.combinationLength = combinationLength;
        this.length = characters.length();
        this.indexes = new int[combinationLength];
        this.hasNext = true;

        for (int i = 0; i < combinationLength; i++) {
            indexes[i] = i;
        }
    }

    /**
     * 下一个组合字符串
     *
     * @return
     */
    public String next() {
        StringBuilder builder = new StringBuilder(combinationLength);
        /**
         * 将当前indexes中索引对应原字符串中的字符逐一拼接
         */
        for (int index : indexes) {
            builder.append(characters.charAt(index));
        }
        /**
         * 查找下一个组合字符串的索引情况
         */
        plusOne(indexes);
        return builder.toString();
    }

    /**
     * 是否还有下一个组合字符串
     *
     * @return
     */
    public boolean hasNext() {
        return hasNext;
    }

    /**
     * 查找下一个组合字符串的索引情况
     *
     * @param indexes
     */
    private void plusOne(int[] indexes) {
        /**
         * 先假设没有更大的字符串了
         */
        hasNext = false;
        /**
         * 从后向前查找第一个还能增大字符的位置
         */
        for (int i = combinationLength - 1; i >= 0; i--) {
            /**
             * 组合字符串第i个位置可以放的最大的字符在原字符串中的索引位置为i+length-combinationLength
             */
            if (indexes[i] < i + length - combinationLength) {
                indexes[i]++;
                /**
                 * 如果找到了可以增大字符的位置，说明还有更大的字符串
                 */
                hasNext = true;
                /**
                 * 找到的位置后面的字符要逐一增大，例如："abcdefghijklmn"的当前组合字符串为"abcden"，则
                 * 下一个组合字符串为"abcdfg"
                 */
                for (int j = i + 1; j < combinationLength; j++) {
                    indexes[j] = indexes[j - 1] + 1;
                }
                break;
            }
        }
    }

    public static void main(String[] args) {
        CombinationIterator combinationIterator1 = new CombinationIterator("abc", 2);
        System.out.println(combinationIterator1.next());
        System.out.println(combinationIterator1.hasNext());
        System.out.println(combinationIterator1.next());
        System.out.println(combinationIterator1.hasNext());
        System.out.println(combinationIterator1.next());
        System.out.println(combinationIterator1.hasNext());

        System.out.println("---------------------------");

        CombinationIterator combinationIterator2 = new CombinationIterator("abcdefghijklmn", 6);
        System.out.println(combinationIterator2.next());
        System.out.println(combinationIterator2.hasNext());
        System.out.println(combinationIterator2.next());
        System.out.println(combinationIterator2.hasNext());
        System.out.println(combinationIterator2.next());
        System.out.println(combinationIterator2.hasNext());
        System.out.println(combinationIterator2.next());
        System.out.println(combinationIterator2.hasNext());
        System.out.println(combinationIterator2.next());
        System.out.println(combinationIterator2.hasNext());
        System.out.println(combinationIterator2.next());
        System.out.println(combinationIterator2.hasNext());
        System.out.println(combinationIterator2.next());
        System.out.println(combinationIterator2.hasNext());
        System.out.println(combinationIterator2.next());
        System.out.println(combinationIterator2.hasNext());
        System.out.println(combinationIterator2.next());
        System.out.println(combinationIterator2.hasNext());
        System.out.println(combinationIterator2.next());
        System.out.println(combinationIterator2.hasNext());
        System.out.println(combinationIterator2.next());
        System.out.println(combinationIterator2.hasNext());
        System.out.println(combinationIterator2.next());
        System.out.println(combinationIterator2.hasNext());
        System.out.println(combinationIterator2.next());
        System.out.println(combinationIterator2.hasNext());
        System.out.println(combinationIterator2.next());
        System.out.println(combinationIterator2.hasNext());
        System.out.println(combinationIterator2.next());
        System.out.println(combinationIterator2.hasNext());
        System.out.println(combinationIterator2.next());
        System.out.println(combinationIterator2.hasNext());
        System.out.println(combinationIterator2.next());
        System.out.println(combinationIterator2.hasNext());
        System.out.println(combinationIterator2.next());
        System.out.println(combinationIterator2.hasNext());
        System.out.println(combinationIterator2.next());
        System.out.println(combinationIterator2.hasNext());
        System.out.println(combinationIterator2.next());
        System.out.println(combinationIterator2.hasNext());
        System.out.println(combinationIterator2.next());
        System.out.println(combinationIterator2.hasNext());
        System.out.println(combinationIterator2.next());
        System.out.println(combinationIterator2.hasNext());
        System.out.println(combinationIterator2.next());
        System.out.println(combinationIterator2.hasNext());
        System.out.println(combinationIterator2.next());
        System.out.println(combinationIterator2.hasNext());
        System.out.println(combinationIterator2.next());
        System.out.println(combinationIterator2.hasNext());
    }
}
