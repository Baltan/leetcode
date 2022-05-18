package leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 1871. Jump Game VII
 *
 * @author Baltan
 * @date 2022/5/15 14:32
 */
public class CanReach1 {
    public static void main(String[] args) {
        System.out.println(canReach("00111010", 3, 5));
        System.out.println(canReach("011010", 2, 3));
        System.out.println(canReach("01101110", 2, 3));
    }

    public static boolean canReach(String s, int minJump, int maxJump) {
        if (s.charAt(s.length() - 1) == '1') {
            return false;
        }

        int length = s.length();
        List<Integer> indexList = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '0') {
                indexList.add(i);
            }
        }

        int[] window = {0, 0};

        while (window[0] < length) {
            if (window[0] + minJump > indexList.get(indexList.size() - 1)) {
                return false;
            }

            int[] nextWindow = nextWindow(indexList, window[0] + minJump, window[1] + maxJump);

            if (Arrays.equals(window, nextWindow)) {
                return false;
            }

            if (nextWindow[0] <= length - 1 && nextWindow[1] >= length - 1) {
                return true;
            }
            window = nextWindow;
        }
        return false;
    }

    public static int[] nextWindow(List<Integer> indexList, int start, int end) {
        int[] nextWindow = new int[2];
        int lo = 0;
        int hi = indexList.size() - 1;

        while (lo < hi) {
            int mid = (lo + hi) / 2;

            if (indexList.get(mid) < start) {
                lo++;
            } else {
                hi = mid;
            }
        }
        nextWindow[0] = indexList.get(lo);
        lo = 0;
        hi = indexList.size() - 1;

        while (lo < hi) {
            int mid = (int) Math.ceil((lo + hi) / 2.0);

            if (indexList.get(mid) > end) {
                hi--;
            } else {
                lo = mid;
            }
        }
        nextWindow[1] = indexList.get(lo);
        return nextWindow;
    }
}
