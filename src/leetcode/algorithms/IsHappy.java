package leetcode.algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * Description:Happy Number
 *
 * @author Baltan
 * @date 2018/1/4 15:59
 */
public class IsHappy {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            String nString = String.valueOf(n);
            n = 0;
            for (int i = 0; i < nString.length(); i++) {
                n += (int) Math.pow(Integer.valueOf(nString.substring(i, i + 1)), 2);
            }
        }
        return n == 1;
    }
}
