package leetcode.algorithms;

import leetcode.entity.GraphNode;
import leetcode.util.OutputUtils;

import java.util.*;

/**
 * Description: 133. Clone Graph
 *
 * @author Baltan
 * @date 2019-05-29 10:35
 */
public class CloneGraph {
    public static void main(String[] args) {
        GraphNode graphNode11 = new GraphNode();
        graphNode11.val = 1;
        GraphNode graphNode12 = new GraphNode();
        graphNode12.val = 2;
        GraphNode graphNode13 = new GraphNode();
        graphNode13.val = 3;
        GraphNode graphNode14 = new GraphNode();
        graphNode14.val = 4;
        graphNode11.neighbors = Arrays.asList(new GraphNode[]{graphNode12, graphNode14});
        graphNode12.neighbors = Arrays.asList(new GraphNode[]{graphNode11, graphNode13});
        graphNode13.neighbors = Arrays.asList(new GraphNode[]{graphNode12, graphNode14});
        graphNode14.neighbors = Arrays.asList(new GraphNode[]{graphNode11, graphNode13});
        GraphNode copy_graphNode11 = cloneGraph(graphNode11);
        System.out.println(copy_graphNode11.val);
        OutputUtils.printGraphNode(copy_graphNode11);

        System.out.println("------------------------------");

        GraphNode graphNode21 = new GraphNode();
        graphNode21.val = 1;
        graphNode21.neighbors = new ArrayList<>();
        GraphNode copy_graphNode21 = cloneGraph(graphNode21);
        System.out.println(copy_graphNode21.val);
        OutputUtils.printGraphNode(copy_graphNode21);

        System.out.println("------------------------------");

        GraphNode graphNode31 = new GraphNode();
        graphNode31.val = 1;
        GraphNode graphNode32 = new GraphNode();
        graphNode32.val = 2;
        graphNode31.neighbors = Arrays.asList(new GraphNode[]{graphNode32});
        graphNode32.neighbors = Arrays.asList(new GraphNode[]{graphNode31});
        GraphNode copy_graphNode31 = cloneGraph(graphNode31);
        System.out.println(copy_graphNode31.val);
        OutputUtils.printGraphNode(copy_graphNode31);
    }

    public static GraphNode cloneGraph(GraphNode node) {
        if (node == null) {
            return null;
        }

        Map<GraphNode, GraphNode> map = new HashMap<>();
        Queue<GraphNode> queue = new LinkedList<>();
        GraphNode _node = new GraphNode(node.val, new ArrayList<>());
        map.put(node, _node);
        queue.offer(node);

        while (!queue.isEmpty()) {
            GraphNode gn = queue.poll();
            List<GraphNode> neighbors = gn.neighbors;

            if (neighbors != null) {
                for (GraphNode neighbor : neighbors) {
                    if (!map.containsKey(neighbor)) {
                        GraphNode _gn = new GraphNode(neighbor.val, new ArrayList<>());
                        map.get(gn).neighbors.add(_gn);
                        map.put(neighbor, _gn);
                        queue.offer(neighbor);
                    } else {
                        map.get(gn).neighbors.add(map.get(neighbor));
                    }
                }
            }
        }
        return _node;
    }
}
