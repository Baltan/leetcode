package leetcode.algorithms;

/**
 * Description: 825. Friends Of Appropriate Ages
 *
 * @author Baltan
 * @date 2019-05-14 10:34
 */
public class NumFriendRequests {
    public static void main(String[] args) {
        System.out.println(numFriendRequests(new int[]{16, 16}));
        System.out.println(numFriendRequests(new int[]{16, 17, 18}));
        System.out.println(numFriendRequests(new int[]{20, 30, 100, 110, 120}));
        System.out.println(numFriendRequests(
                new int[]{43, 12, 34, 13, 42, 54, 57, 3, 41, 65, 87, 34, 87, 3, 13, 34, 76, 9, 42, 31,
                        57, 76, 100, 98, 105, 64, 42, 31, 64, 86, 97, 42, 31, 68, 98, 75}));
    }

    public static int numFriendRequests(int[] ages) {
        int result = 0;
        int num = ages.length;
        int agesNum = 121;
        int[] ageCount = new int[agesNum];

        for (int i = 0; i < num; i++) {
            ageCount[ages[i]]++;
        }

        for (int i = 1; i < agesNum; i++) {
            if (ageCount[i] == 0) {
                continue;
            }
            for (int j = 1; j < agesNum; j++) {
                if (ageCount[j] != 0 && j <= i && j > 0.5 * i + 7) {
                    if (i == j) {
                        result += ageCount[i] * (ageCount[i] - 1);
                    } else {
                        result += ageCount[i] * ageCount[j];
                    }
                }
            }
        }
        return result;
    }
}
