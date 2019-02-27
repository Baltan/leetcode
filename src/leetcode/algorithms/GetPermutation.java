package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Description: Permutation Sequence
 *
 * @author Baltan
 * @date 2018/9/19 10:10
 */
public class GetPermutation {
    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));
        System.out.println(getPermutation(4, 9));
        System.out.println(getPermutation(1, 1));
        System.out.println(getPermutation(2, 2));
    }

    public static String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder(n);
        List<Integer> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int totalCombinationNum = IntStream.rangeClosed(1, n).reduce(1, (a, b) -> a * b);

        while (list.size() > 0) {
            int tailCombinationNum = totalCombinationNum / n;
            int groupNum = (int) (Math.ceil(k * 1.0 / tailCombinationNum) - 1);
            int num = list.get(groupNum);
            sb.append(num);
            list.remove(new Integer(num));
            totalCombinationNum = tailCombinationNum;
            n--;
            k = k - groupNum * tailCombinationNum;
        }
        return sb.toString();
    }
}
