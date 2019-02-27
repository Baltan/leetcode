package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:Self Dividing Numbers
 *
 * @author Baltan
 * @date 2017/11/29 17:02
 */
public class SelfDividingNumbers {
    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1, 22));
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> al = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int j = i;
            for (; j > 0; j /= 10) {
                if (j % 10 == 0 || i % (j % 10) != 0) {
                    break;
                }
            }
            if (j == 0) {
                al.add(i);
            }
        }
//        for (int i = left; i <= right; i++) {
//            String[] arr = String.valueOf(i).split("");
//            boolean flag = true;
//            for (int j = 0; j < arr.length; j++) {
//                if (Integer.valueOf(arr[j]) == 0 || i % Integer.valueOf(arr[j]) != 0) {
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag) {
//                al.add(i);
//            }
//        }
        return al;
    }
}
