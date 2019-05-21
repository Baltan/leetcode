package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 119. Pascal's Triangle II
 * @author Baltan
 *
 * @date 2017/11/9 13:07
 */
public class GetRow {
    public static void main(String[] args) {
        int rowIndex1 = 3;
        int rowIndex2 = 0;
        System.out.println(getRow(rowIndex1));
        System.out.println(getRow(rowIndex2));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triangle = new ArrayList();
        for (int i = 1; i <= rowIndex + 1; i++) {
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
        return triangle.get(rowIndex);
    }
}
