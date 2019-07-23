package leetcode.algorithms;

import leetcode.entity.QuadTreeNode;

/**
 * Description: 558. Quad Tree Intersection
 *
 * @author Baltan
 * @date 2019-07-23 15:46
 */
public class Intersect1 {
    public static void main(String[] args) {
        QuadTreeNode node1 = new QuadTreeNode(true, true, null, null, null, null);
        QuadTreeNode node2 = new QuadTreeNode(true, true, null, null, null, null);
        QuadTreeNode node3 = new QuadTreeNode(false, true, null, null, null, null);
        QuadTreeNode node4 = new QuadTreeNode(false, true, null, null, null, null);
        QuadTreeNode node5 = new QuadTreeNode(false, false, node1, node2, node3, node4);

        QuadTreeNode node6 = new QuadTreeNode(false, true, null, null, null, null);
        QuadTreeNode node7 = new QuadTreeNode(false, true, null, null, null, null);
        QuadTreeNode node8 = new QuadTreeNode(true, true, null, null, null, null);
        QuadTreeNode node9 = new QuadTreeNode(true, true, null, null, null, null);
        QuadTreeNode node10 = new QuadTreeNode(false, false, node6, node7, node8, node9);
        QuadTreeNode node11 = new QuadTreeNode(true, true, null, null, null, null);
        QuadTreeNode node12 = new QuadTreeNode(true, true, null, null, null, null);
        QuadTreeNode node13 = new QuadTreeNode(false, true, null, null, null, null);
        QuadTreeNode node14 = new QuadTreeNode(false, false, node11, node10, node12, node13);

        System.out.println(intersect(node5, node14));
    }

    public static QuadTreeNode intersect(QuadTreeNode quadTree1, QuadTreeNode quadTree2) {
        QuadTreeNode node;

        if (quadTree1 == null || quadTree2 == null) {
            return null;
        } else if (quadTree1.isLeaf && quadTree2.isLeaf) {
            node = new QuadTreeNode();
            node.val = quadTree1.val || quadTree2.val;
            node.isLeaf = true;
        } else if (quadTree1.isLeaf) {
            if (quadTree1.val) {
                node = new QuadTreeNode();
                node.val = true;
                node.isLeaf = true;
            } else {
                node = quadTree2;
            }
        } else if (quadTree2.isLeaf) {
            if (quadTree2.val) {
                node = new QuadTreeNode();
                node.val = true;
                node.isLeaf = true;
            } else {
                node = quadTree1;
            }
        } else {
            QuadTreeNode topLeft = intersect(quadTree1.topLeft, quadTree2.topLeft);
            QuadTreeNode topRight = intersect(quadTree1.topRight, quadTree2.topRight);
            QuadTreeNode bottomLeft = intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
            QuadTreeNode bottomRight = intersect(quadTree1.bottomRight, quadTree2.bottomRight);

            if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf) {
                if (topLeft.val && topRight.val && bottomLeft.val && bottomRight.val) {
                    node = new QuadTreeNode(true, true, null, null, null, null);
                } else if (!(topLeft.val || topRight.val || bottomLeft.val || bottomRight.val)) {
                    node = new QuadTreeNode(false, true, null, null, null, null);
                } else {
                    node = new QuadTreeNode(false, false, topLeft, topRight, bottomLeft, bottomRight);
                }
            } else {
                node = new QuadTreeNode(false, false, topLeft, topRight, bottomLeft, bottomRight);

            }
        }
        return node;
    }
}
