package leetcode.algorithms;

/**
 * Description: 2525. Categorize Box According to Criteria
 *
 * @author Baltan
 * @date 2023/2/2 14:20
 */
public class CategorizeBox {
    public static void main(String[] args) {
        System.out.println(categorizeBox(1000, 35, 700, 300));
        System.out.println(categorizeBox(200, 50, 800, 50));
    }

    public static String categorizeBox(int length, int width, int height, int mass) {
        /**
         * 箱子的体积
         */
        long volume = 1L * length * width * height;
        boolean isBulky = length >= 10000 || width >= 10000 || height >= 10000 || volume >= 1000000000;
        boolean isHeavy = mass >= 100;

        if (isBulky && isHeavy) {
            return "Both";
        } else if (isBulky) {
            return "Bulky";
        } else if (isHeavy) {
            return "Heavy";
        } else {
            return "Neither";
        }
    }
}
