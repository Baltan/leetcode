package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:Pascal's Triangle
 * @author Baltan
 *
 * @date 2017/11/8 15:56
 */
public class Generate {
    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList();
            triangle.add(list);
            list.add(0, 1);
            if (i > 1) {
                for (int j = 1; j <= (i - 1) / 2; j++) {
                    list.add(j, triangle.get(i - 2).get(j - 1) + triangle.get(i - 2).get(j));
                }
                for (int j = (int) ((i + 1) / 2); j < i; j++) {
                    list.add(j, triangle.get(i - 1).get(i - 1 - j));
                }
            }
        }
        return triangle;
    }
}
