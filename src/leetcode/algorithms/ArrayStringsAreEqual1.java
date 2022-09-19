package leetcode.algorithms;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Description: 1662. Check If Two String Arrays are Equivalent
 *
 * @author Baltan
 * @date 2022/9/11 13:17
 * @see ArrayStringsAreEqual
 */
public class ArrayStringsAreEqual1 {
    public static void main(String[] args) {
        System.out.println(arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"}));
        System.out.println(arrayStringsAreEqual(new String[]{"a", "cb"}, new String[]{"ab", "c"}));
        System.out.println(arrayStringsAreEqual(new String[]{"abc", "d", "defg"}, new String[]{"abcddefg"}));
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return Objects.equals(
                Arrays.stream(word1).collect(Collectors.joining()),
                Arrays.stream(word2).collect(Collectors.joining())
        );
    }
}
