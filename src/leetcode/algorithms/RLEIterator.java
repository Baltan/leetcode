package leetcode.algorithms;

/**
 * Description: 900. RLE Iterator
 *
 * @author Baltan
 * @date 2020-02-22 13:09
 */
public class RLEIterator {
    private int[] A;
    /**
     * 当前指向的偶数索引位置，即next()从index个A[index+1]开始消耗
     */
    private int index;

    public RLEIterator(int[] A) {
        this.A = A;
        this.index = 0;
    }

    public int next(int n) {
        while (index < A.length) {
            /**
             * 如果当前需要消耗的数量n不大于A[index]个，则直接从index个A[index+1]中减掉n个
             * A[index+1]即可，最后一个消耗的就是A[index+1]；否则消耗完index个A[index+1]
             * 后还要继续消耗，(index+2)个A[index+3]，(index+4)个A[index+5]……直到index
             * 大于等于A.length，此时已经没有元素可以消耗了，返回-1
             */
            if (A[index] >= n) {
                A[index] -= n;
                return A[index + 1];
            } else {
                n -= A[index];
                index += 2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        RLEIterator iterator1 = new RLEIterator(new int[]{3, 8, 0, 9, 2, 5});
        System.out.println(iterator1.next(2));
        System.out.println(iterator1.next(1));
        System.out.println(iterator1.next(1));
        System.out.println(iterator1.next(2));

        System.out.println("----------------");

        RLEIterator iterator2 = new RLEIterator(
                new int[]{635, 606, 576, 391, 370, 981, 36, 21, 961, 185, 124, 210, 801, 937, 22, 426, 101,
                        260, 221, 647, 350, 180, 504, 39, 101, 989, 199, 358, 732, 839, 919, 169, 673, 967,
                        58, 676, 846, 342, 250, 597, 442, 174, 472, 410, 569, 509, 311, 357, 838, 251});
        System.out.println(iterator2.next(5039));
        System.out.println(iterator2.next(62));
        System.out.println(iterator2.next(3640));
        System.out.println(iterator2.next(671));
        System.out.println(iterator2.next(67));
        System.out.println(iterator2.next(395));
        System.out.println(iterator2.next(262));
        System.out.println(iterator2.next(839));
        System.out.println(iterator2.next(74));
        System.out.println(iterator2.next(43));
        System.out.println(iterator2.next(42));
        System.out.println(iterator2.next(77));
        System.out.println(iterator2.next(13));
        System.out.println(iterator2.next(6));
        System.out.println(iterator2.next(3));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
        System.out.println(iterator2.next(1));
    }
}
