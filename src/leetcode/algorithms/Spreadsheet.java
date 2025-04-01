package leetcode.algorithms;

/**
 * Description: 3484. Design Spreadsheet
 *
 * @author Baltan
 * @date 2025/4/1 23:20
 */
public class Spreadsheet {
    private final int[][] spreadsheet;

    public Spreadsheet(int rows) {
        spreadsheet = new int[rows][26];
    }

    public void setCell(String cell, int value) {
        int row = Integer.parseInt(cell.substring(1)) - 1;
        int col = cell.charAt(0) - 'A';
        spreadsheet[row][col] = value;
    }

    public void resetCell(String cell) {
        /**
         * 重置单元格，即将单元格的值设置为0
         */
        setCell(cell, 0);
    }

    public int getValue(String formula) {
        int plusIndex = formula.indexOf("+");
        /**
         * "="和"+"之间子串表示的值
         */
        int value = Character.isDigit(formula.charAt(1)) ? Integer.parseInt(formula.substring(1, plusIndex))
                : spreadsheet[Integer.parseInt(formula.substring(2, plusIndex)) - 1][formula.charAt(1) - 'A'];
        /**
         * "+"之后子串表示的值
         */
        return value + (Character.isDigit(formula.charAt(plusIndex + 1)) ? Integer.parseInt(formula.substring(plusIndex + 1))
                : spreadsheet[Integer.parseInt(formula.substring(plusIndex + 2)) - 1][formula.charAt(plusIndex + 1) - 'A']);
    }

    public static void main(String[] args) {
        Spreadsheet spreadsheet1 = new Spreadsheet(3);
        System.out.println(spreadsheet1.getValue("=5+7"));
        spreadsheet1.setCell("A1", 10);
        System.out.println(spreadsheet1.getValue("=A1+6"));
        spreadsheet1.setCell("B2", 15);
        System.out.println(spreadsheet1.getValue("=A1+B2"));
        spreadsheet1.resetCell("A1");
        System.out.println(spreadsheet1.getValue("=A1+B2"));

        System.out.println("-------------------------------------");

        Spreadsheet spreadsheet2 = new Spreadsheet(862);
        spreadsheet2.setCell("V846", 52719);

        System.out.println("-------------------------------------");

        Spreadsheet spreadsheet3 = new Spreadsheet(458);
        System.out.println(spreadsheet3.getValue("=O126+10272"));
    }
}
