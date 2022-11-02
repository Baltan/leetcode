package leetcode.algorithms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Description: 1560. Most Visited Sector in a Circular Track
 *
 * @author Baltan
 * @date 2022/10/25 11:10
 */
public class MostVisited {
    public static void main(String[] args) {
        System.out.println(mostVisited(4, new int[]{1, 3, 1, 2}));
        System.out.println(mostVisited(2, new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2}));
        System.out.println(mostVisited(7, new int[]{1, 3, 5, 7}));
    }

    public static List<Integer> mostVisited(int n, int[] rounds) {
        int start = rounds[0];
        int end = rounds[rounds.length - 1];
        /**
         * 1、如果起点扇区编号start不大于结束扇区编号end，则[start,end]这部分扇区比其他扇区多经过一次
         * 2、如果起点扇区编号start大于结束扇区编号end，则[1,end]和[start,n]这部分扇区比其他扇区多经过一次
         */
        if (start <= end) {
            return IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
        } else {
            List<Integer> arr1 = IntStream.rangeClosed(1, end).boxed().collect(Collectors.toList());
            List<Integer> arr2 = IntStream.rangeClosed(start, n).boxed().collect(Collectors.toList());
            arr1.addAll(arr2);
            return arr1;
        }
    }
}
