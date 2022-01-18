package leetcode.algorithms;

import java.util.Arrays;

/**
 * Description: 1996. The Number of Weak Characters in the Game
 *
 * @author Baltan
 * @date 2022/1/18 16:00
 */
public class NumberOfWeakCharacters {
    public static void main(String[] args) {
        int[][] properties1 = {{5, 5}, {6, 3}, {3, 6}};
        System.out.println(numberOfWeakCharacters(properties1));

        int[][] properties2 = {{2, 2}, {3, 3}};
        System.out.println(numberOfWeakCharacters(properties2));

        int[][] properties3 = {{1, 5}, {10, 4}, {4, 3}};
        System.out.println(numberOfWeakCharacters(properties3));

        int[][] properties4 = {{7, 9}, {10, 7}, {6, 9}, {10, 4}, {7, 5}, {7, 10}};
        System.out.println(numberOfWeakCharacters(properties4));
    }

    public static int numberOfWeakCharacters(int[][] properties) {
        int result = 0;
        /**
         * 将所有角色按照攻击力倒序排列
         */
        Arrays.sort(properties, (x, y) -> y[0] - x[0]);
        /**
         * 攻击力大于当前角色的所有角色中的防御力最大值
         */
        int maxDefense = 0;
        /**
         * 攻击力等于当前角色的所有角色中的防御力最大值
         */
        int maxDefenseSameAttack = properties[0][1];

        for (int i = 1; i < properties.length; i++) {
            if (properties[i][0] == properties[i - 1][0]) {
                maxDefenseSameAttack = Math.max(maxDefenseSameAttack, properties[i][1]);
            } else {
                /**
                 * 当前角色的攻击力已小于前面的所有角色，需要更新maxDefense
                 */
                maxDefense = Math.max(maxDefense, maxDefenseSameAttack);
                maxDefenseSameAttack = properties[i][1];
            }
            /**
             * 因为防御力为maxDefense的角色X攻击力肯定大于当前角色，所以角色X的攻击力和防御力都大于当前角色
             */
            if (properties[i][1] < maxDefense) {
                result++;
            }
        }
        return result;
    }
}
