package leetcode.algorithms;

import leetcode.entity.QuadTreeNode;

/**
 * Description: 427. Construct Quad Tree
 *
 * @author Baltan
 * @date 2018/8/5 13:55
 */
public class Construct {
    public static void main(String[] args) {
        int[][] grid1 = {{1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 0,
                0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}, {1, 1, 1, 1, 0, 0, 0, 0}};
        System.out.println(construct(grid1));

        int[][] grid2 =
                {{1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1,
                        0}, {0, 1, 0, 1, 0, 1, 0, 1,
                        0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0,
                                1, 0, 1, 0},
                        {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1,
                                0, 1, 0, 1},
                        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0,
                                1, 0, 1, 0},
                        {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1,
                                0, 1, 0, 1},
                        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0,
                                1, 0, 1, 0},
                        {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1,
                                0, 1, 0, 1},
                        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0,
                                1, 0, 1, 0},
                        {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1,
                                0, 1, 0, 1},
                        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0,
                                1, 0, 1, 0},
                        {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1,
                                0, 1, 0, 1},
                        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0,
                                1, 0, 1, 0},
                        {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1,
                                0, 1, 0, 1},
                        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0,
                                1, 0, 1, 0},
                        {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1,
                                0, 1, 0, 1},
                        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0,
                                1, 0, 1, 0},
                        {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1,
                                0, 1, 0, 1},
                        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0,
                                1, 0, 1, 0},
                        {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1,
                                0, 1, 0, 1},
                        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0,
                                1, 0, 1, 0},
                        {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1,
                                0, 1, 0, 1},
                        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0,
                                1, 0, 1, 0},
                        {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1,
                                0, 1, 0, 1},
                        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0,
                                1, 0, 1, 0},
                        {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1,
                                0, 1, 0, 1},
                        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0,
                                1, 0, 1, 0},
                        {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1,
                                0, 1, 0, 1},
                        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0,
                                1, 0, 1, 0},
                        {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1,
                                0, 1, 0, 1},
                        {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0,
                                1, 0, 1, 0},
                        {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1,
                                0, 1, 0, 1}};
        System.out.println(construct(grid2));
    }

    public static QuadTreeNode construct(int[][] grid) {
        if (grid.length == 1) {
            if (grid[0][0] == 0) {
                return new QuadTreeNode(false, true, null, null, null, null);
            } else if (grid[0][0] == 1) {
                return new QuadTreeNode(true, true, null, null, null, null);
            }
        }

        int length = grid[0].length;
        int halfLength = length / 2;
        int[][] leftTopGrid = new int[halfLength][halfLength];
        int[][] rightTopGrid = new int[halfLength][halfLength];
        int[][] leftBottomGrid = new int[halfLength][halfLength];
        int[][] rightBottomGrid = new int[halfLength][halfLength];

        int gridSum;
        int leftTopGridSum = 0;
        int rightTopGridSum = 0;
        int leftBottomGridSum = 0;
        int rightBottomGridSum = 0;

        for (int i = 0; i < halfLength; i++) {
            for (int j = 0; j < halfLength; j++) {
                leftTopGridSum += grid[i][j];
                rightTopGridSum += grid[i][j + halfLength];
                leftBottomGridSum += grid[i + halfLength][j];
                rightBottomGridSum += grid[i + halfLength][j + halfLength];
            }
        }

        gridSum = leftTopGridSum + rightTopGridSum + leftBottomGridSum + rightBottomGridSum;

        if (gridSum == length * length) {
            return new QuadTreeNode(true, true, null, null, null, null);
        } else if (gridSum == 0) {
            return new QuadTreeNode(false, true, null, null, null, null);
        }

        QuadTreeNode root = new QuadTreeNode(true, false, null, null, null, null);

        if (leftTopGridSum == halfLength * halfLength) {
            QuadTreeNode leftTopNode = new QuadTreeNode(true, true, null, null, null, null);
            root.topLeft = leftTopNode;
        } else if (leftTopGridSum == 0) {
            QuadTreeNode leftTopNode = new QuadTreeNode(false, true, null, null, null, null);
            root.topLeft = leftTopNode;
        } else {
            for (int i = 0; i < halfLength; i++) {
                for (int j = 0; j < halfLength; j++) {
                    leftTopGrid[i][j] = grid[i][j];
                }
            }
            QuadTreeNode leftTopNode = construct(leftTopGrid);
            root.topLeft = leftTopNode;
        }

        if (rightTopGridSum == halfLength * halfLength) {
            QuadTreeNode rightTopNode = new QuadTreeNode(true, true, null, null, null, null);
            root.topRight = rightTopNode;
        }
        if (rightTopGridSum == 0) {
            QuadTreeNode rightTopNode = new QuadTreeNode(false, true, null, null, null, null);
            root.topRight = rightTopNode;
        } else {
            for (int i = 0; i < halfLength; i++) {
                for (int j = 0; j < halfLength; j++) {
                    rightTopGrid[i][j] = grid[i][j + halfLength];
                }
            }
            QuadTreeNode rightTopNode = construct(rightTopGrid);
            root.topRight = rightTopNode;
        }

        if (leftBottomGridSum == halfLength * halfLength) {
            QuadTreeNode leftBottomNode = new QuadTreeNode(true, true, null, null, null, null);
            root.bottomLeft = leftBottomNode;
        }
        if (leftBottomGridSum == 0) {
            QuadTreeNode leftBottomNode = new QuadTreeNode(false, true, null, null, null, null);
            root.bottomLeft = leftBottomNode;
        } else {
            for (int i = 0; i < halfLength; i++) {
                for (int j = 0; j < halfLength; j++) {
                    leftBottomGrid[i][j] = grid[i + halfLength][j];
                }
            }
            QuadTreeNode leftBottomNode = construct(leftBottomGrid);
            root.bottomLeft = leftBottomNode;
        }

        if (rightBottomGridSum == halfLength * halfLength) {
            QuadTreeNode rightBottomNode = new QuadTreeNode(true, true, null, null, null, null);
            root.bottomRight = rightBottomNode;
        }
        if (rightBottomGridSum == 0) {
            QuadTreeNode rightBottomNode = new QuadTreeNode(false, true, null, null, null, null);
            root.bottomRight = rightBottomNode;
        } else {
            for (int i = 0; i < halfLength; i++) {
                for (int j = 0; j < halfLength; j++) {
                    rightBottomGrid[i][j] = grid[i + halfLength][j + halfLength];
                }
            }
            QuadTreeNode rightBottomNode = construct(rightBottomGrid);
            root.bottomRight = rightBottomNode;
        }
        return root;
    }
}
