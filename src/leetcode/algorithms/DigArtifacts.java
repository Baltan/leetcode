package leetcode.algorithms;

/**
 * Description: 2201. Count Artifacts That Can Be Extracted
 *
 * @author Baltan
 * @date 2022/3/14 22:57
 */
public class DigArtifacts {
    public static void main(String[] args) {
        int n1 = 2;
        int[][] artifacts1 = {{0, 0, 0, 0}, {0, 1, 1, 1}};
        int[][] dig1 = {{0, 0}, {0, 1}};
        System.out.println(digArtifacts(n1, artifacts1, dig1));

        int n2 = 2;
        int[][] artifacts2 = {{0, 0, 0, 0}, {0, 1, 1, 1}};
        int[][] dig2 = {{0, 0}, {0, 1}, {1, 1}};
        System.out.println(digArtifacts(n2, artifacts2, dig2));
    }

    public static int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int result = 0;
        /**
         * isDug[i][j]表示坐标为(i,j)的单元格能否被挖掘
         */
        boolean[][] isDug = new boolean[n][n];

        for (int[] coordinate : dig) {
            isDug[coordinate[0]][coordinate[1]] = true;
        }
        /**
         * 逐一判断每个工件覆盖的每个单元格是否都能被挖掘
         */
        outer:
        for (int[] artifact : artifacts) {
            for (int i = artifact[0]; i <= artifact[2]; i++) {
                for (int j = artifact[1]; j <= artifact[3]; j++) {
                    if (!isDug[i][j]) {
                        continue outer;
                    }
                }
            }
            result++;
        }
        return result;
    }
}
