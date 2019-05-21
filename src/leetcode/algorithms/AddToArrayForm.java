package leetcode.algorithms;

import java.util.LinkedList;
import java.util.List;

/**
 * Description: 989. Add to Array-Form of Integer
 *
 * @author Baltan
 * @date 2019-03-16 13:16
 */
public class AddToArrayForm {
    public static void main(String[] args) {
        System.out.println(addToArrayForm(new int[]{1, 2, 0, 0}, 34));
        System.out.println(addToArrayForm(new int[]{2, 7, 4}, 181));
        System.out.println(addToArrayForm(new int[]{2, 1, 5}, 806));
        System.out.println(addToArrayForm(new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}, 1));
    }

    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> list = new LinkedList<>();
        int arrayIndex = A.length - 1;
        int unit;
        int carry = 0;

        while (arrayIndex >= 0 && K > 0) {
            if (A[arrayIndex] + K % 10 + carry >= 10) {
                unit = A[arrayIndex] + K % 10 + carry - 10;
                carry = 1;
            } else {
                unit = A[arrayIndex] + K % 10 + carry;
                carry = 0;
            }
            arrayIndex--;
            K /= 10;
            ((LinkedList<Integer>) list).addFirst(unit);
        }

        while (arrayIndex >= 0) {
            if (A[arrayIndex] + carry >= 10) {
                unit = A[arrayIndex] + carry - 10;
                carry = 1;
            } else {
                unit = A[arrayIndex] + carry;
                carry = 0;
            }
            ((LinkedList<Integer>) list).addFirst(unit);
            arrayIndex--;
        }

        while (K > 0) {
            if (K % 10 + carry >= 10) {
                unit = K % 10 + carry - 10;
                carry = 1;
            } else {
                unit = K % 10 + carry;
                carry = 0;
            }
            ((LinkedList<Integer>) list).addFirst(unit);
            K /= 10;
        }

        if (carry == 1) {
            ((LinkedList<Integer>) list).addFirst(1);
        }
        return list;
    }
}
