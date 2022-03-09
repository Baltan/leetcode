package leetcode.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 2194. Cells in a Range on an Excel Sheet
 *
 * @author Baltan
 * @date 2022/3/8 23:29
 */
public class CellsInRange {
    public static void main(String[] args) {
        System.out.println(cellsInRange("K1:L2"));
        System.out.println(cellsInRange("A1:F1"));
    }

    public static List<String> cellsInRange(String s) {
        char startCol = s.charAt(0);
        char endCol = s.charAt(3);
        char startRow = s.charAt(1);
        char endRow = s.charAt(4);
        List<String> result = new ArrayList<>((endRow - startRow) * (endCol - startCol));

        for (char i = startCol; i <= endCol; i++) {
            for (char j = startRow; j <= endRow; j++) {
                result.add(i + "" + j);
            }
        }
        return result;
    }
}
