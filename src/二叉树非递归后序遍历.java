import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 二叉树非递归后序遍历 {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> record = new ArrayList<>();
//        postorder(record, root);
//        return record;
//    }
//
//    private void postorder(List<Integer> record, TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        postorder(record, root.left);
//        postorder(record, root.right);
//        record.add(root.val);
//    }
//
//    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> record = new ArrayList<>();
//        if (root == null) {
//            return record;
//        }
//        LinkedList<TreeNode> stack = new LinkedList<>();
//        TreeNode cur = root, pre = root;
//        System.out.println(cur.val);
//        stack.push(cur);
//        while (!stack.isEmpty()) {
//            cur = stack.peek();
//            if (cur.left != null && pre != cur.left && pre != cur.right) {
//                System.out.println(cur.left.val);
//                stack.push(cur.left);
//            } else if (cur.right != null && pre != cur.right) {
//                System.out.println(cur.right.val);
//                stack.push(cur.right);
//            } else {
//                record.add(stack.pop().val);
//                pre = cur;
//            }
//        }
//        return record;
//    }

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> record = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            if (top != null) {
                record.addFirst(top.val);
                stack.push(top.left);
                stack.push(top.right);
            }
        }
        return record;

    }

}
