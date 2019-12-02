package leetcode.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Description: 1276. Number of Burgers with No Waste of Ingredients
 *
 * @author Baltan
 * @date 2019-12-02 12:34
 */
public class NumOfBurgers {
    public static void main(String[] args) {
        System.out.println(numOfBurgers(16, 7));
        System.out.println(numOfBurgers(17, 4));
        System.out.println(numOfBurgers(4, 17));
        System.out.println(numOfBurgers(0, 0));
        System.out.println(numOfBurgers(2, 1));
    }

    public static List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        /**
         * 即求方程组的非负整数解
         * 4x+2y=tomatoSlices
         * x+y=cheeseSlices
         */
        double jumboBurgerCount = 1.0 * (tomatoSlices - cheeseSlices * 2) / 2;
        double smallBurgerCount = cheeseSlices - jumboBurgerCount;
        /**
         * 判断两种汉堡的个数是不是都为非负整数
         */
        if (jumboBurgerCount >= 0 && jumboBurgerCount % 1 == 0 && smallBurgerCount >= 0 &&
                smallBurgerCount % 1 == 0) {
            return Arrays.asList((int) jumboBurgerCount, (int) smallBurgerCount);
        }
        return Collections.emptyList();
    }
}
