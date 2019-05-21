package leetcode.algorithms;

/**
 * Description: 605. Can Place Flowers
 * @author Baltan
 *
 * @date 2017/11/12 14:24
 */
public class CanPlaceFlowers {
    public static void main(String[] args) {
        int[] flowerbed1 = {1, 0, 0, 0, 1};
        int[] flowerbed2 = {1, 0, 0, 0, 1};
        int[] flowerbed3 = {1, 0, 0, 0, 1, 0, 0};
        int[] flowerbed4 = {1, 0, 0, 0, 0, 0, 1};
        int[] flowerbed5 = {1, 0, 0, 0, 0, 1};
        int[] flowerbed6 = {0};
        int n1 = 1;
        int n2 = 2;
        int n3 = 2;
        int n4 = 2;
        int n5 = 2;
        int n6 = 1;
        System.out.println(canPlaceFlowers(flowerbed1, n1));
        System.out.println(canPlaceFlowers(flowerbed2, n2));
        System.out.println(canPlaceFlowers(flowerbed3, n3));
        System.out.println(canPlaceFlowers(flowerbed4, n4));
        System.out.println(canPlaceFlowers(flowerbed5, n5));
        System.out.println(canPlaceFlowers(flowerbed6, n6));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int currentStart = 0;
        int canPlaceNumber = 0;
        if (flowerbed[currentStart] == 0 && flowerbed.length == 1) {
            canPlaceNumber++;
            return true;
        }
        while (currentStart < flowerbed.length - 1) {
            if (flowerbed[currentStart] == 1 && flowerbed[currentStart + 1] == 0) {
                currentStart += 2;
            } else if (flowerbed[currentStart] == 0 && flowerbed[currentStart + 1] == 1) {
                currentStart += 3;
            } else if (flowerbed[currentStart] == 0 && flowerbed[currentStart + 1] == 0) {
                flowerbed[currentStart] = 1;
                canPlaceNumber++;
                currentStart += 2;
            }
        }
        if (flowerbed[flowerbed.length - 1] == 0 && flowerbed[flowerbed.length - 2] == 0) {
            flowerbed[flowerbed.length - 1] = 1;
            canPlaceNumber++;
        }
        return canPlaceNumber >= n;
    }
}
