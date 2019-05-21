package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 412. Fizz Buzz
 *
 * @author Baltan
 * @date 2017/12/29 16:18
 */
public class FizzBuzz {
    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
        System.out.println(fizzBuzz(0));
    }

    public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();
        if (n < 1) {
            return list;
        }
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
}
