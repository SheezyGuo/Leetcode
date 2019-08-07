import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 图的克隆 {


    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        return DFSClone(node, map);
    }

    private Node DFSClone(Node node, Map<Node, Node> map) {
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node copy = new Node(node.val, new ArrayList<>());
        map.put(node, copy);
        for (Node nei : node.neighbors) {
            copy.neighbors.add(DFSClone(nei, map));
        }
        return copy;
    }
}
