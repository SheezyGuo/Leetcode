import java.util.*;

public class 华为 {

//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String line = sc.nextLine();
//        String[] parts = line.split("@");
//        Map<String, Integer> qlmap = new LinkedHashMap<>();
//        Map<String, Integer> zymap = new LinkedHashMap<>();
//        for (String small : parts[0].split(",")) {
//            String[] localParts = small.split(":");
//            String key = localParts[0];
//            Integer value = Integer.parseInt(localParts[1]);
//            qlmap.put(key, value);
//        }
//        if (parts.length == 2) {
//            for (String small : parts[1].split(",")) {
//                String[] localParts = small.split(":");
//                String key = localParts[0];
//                Integer value = Integer.parseInt(localParts[1]);
//                qlmap.put(key, qlmap.get(key) - value);
//            }
//        }
//        List<String> list = new ArrayList<>();
//        for (String key : qlmap.keySet()) {
//            int count = qlmap.get(key);
//            if (count >= 1) {
//                list.add(String.format("%s:%d", key, count));
//            }
//        }
//        if (list.size() == 0) {
//            System.out.println("");
//        } else {
//            System.out.println(String.join(",", list));
//        }
//    }

    private static class Node {
        public Map<Integer, Node> childs;
        public Map<Integer, Integer> values;

        public Node() {
            childs = new LinkedHashMap<>();
            values = new LinkedHashMap<>();
        }

        public Node(int key, int val) {
            this();
            this.values.put(key, val);

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int[] Labels = new int[M];
        int[] HasChild = new int[M];
        int[] Pouds = new int[M];
        for (int i = 0; i < M; i++) {
            Labels[i] = sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            HasChild[i] = sc.nextInt();
        }
        for (int i = 0; i < M; i++) {
            Pouds[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }
        int p = sc.nextInt();
        int[] keys = new int[p];
        for (int i = 0; i < p; i++) {
            keys[i] = sc.nextInt();
        }
        LinkedList<Node> leafQ = new LinkedList<>();
        LinkedList<Node> nodeQ = new LinkedList<>();
        Node last = null;
        int valueI = 0;
        for (int i = 0; i < M; i++) {
            if (HasChild[i] == 0 && Pouds[i] == 1) {
                int key = Labels[i];
                int val = values[valueI++];
                Node node = new Node(key, val);
                last = node;
                leafQ.add(node);
            } else if (HasChild[i] == 0 && Pouds[i] == 0) {
                int key = Labels[i];
                int val = values[valueI++];
                last.values.put(key, val);
            } else if (HasChild[i] == 1 && Pouds[i] == 1) {
                int key = Labels[i];
                Node node = new Node();
                Node child = leafQ.isEmpty() ? nodeQ.pollFirst() : leafQ.pollFirst();
                node.childs.put(key, child);
                last = node;
                nodeQ.add(node);
            } else if (HasChild[i] == 1 && Pouds[i] == 0) {
                int key = Labels[i];
                Node child = leafQ.isEmpty() ? nodeQ.pollFirst() : leafQ.pollFirst();
                last.childs.put(key, child);
            }
        }
        Node root = last;
        for (int i = 0; i < p - 1; i++) {
            int key = keys[i];
            if (!root.childs.containsKey(key)) {
                System.out.println(0);
                return;
            } else {
                root = root.childs.get(key);
            }
        }
        int key = keys[p - 1];
        if (!root.values.containsKey(key)) {
            System.out.println(0);
        } else {
            System.out.println(root.values.get(key));
        }
    }
}
