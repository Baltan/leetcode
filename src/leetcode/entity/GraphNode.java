package leetcode.entity;

import java.util.List;

/**
 * Description:
 *
 * @author Baltan
 * @date 2019-05-29 10:34
 */
public class GraphNode {
    public int val;
    public List<GraphNode> neighbors;

    public GraphNode() {
    }

    public GraphNode(int _val, List<GraphNode> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }

    @Override
    public String toString() {
        return "val=" + val;
    }
}
