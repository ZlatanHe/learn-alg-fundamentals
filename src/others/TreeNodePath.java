package others;

import java.util.Stack;

/**
 * Created by Zlatan on 19/3/7.
 */
public class TreeNodePath {

    public static void main(String[] arhs) {
        Node leaf4 = new Node(4);
        Node leaf5 = new Node(5);
        Node leaf6 = new Node(6);
        Node node2 = new Node(leaf4, leaf5, 2);
        Node node3 = new Node(leaf6, null, 3);
        Node root = new Node(node2, node3, 1);

        new TreeNodePath().path(root, 6);
    }

    public void path(Node root, int target) {
        Stack<Integer> path = new Stack<>();
        path(root, target, path);
        StringBuilder sb = new StringBuilder();
        while (!path.isEmpty()) {
            sb.append(path.pop()).append("-");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    /**
     * 前序遍历, 深度优先
     */
    private void path(Node node, int target, Stack<Integer> stack) {
        if (node.val == target) {
            stack.add(target);
            return;
        }
        if (node.left != null) {
            path(node.left, target, stack);
            if (!stack.isEmpty()) {
                stack.add(node.val);
                return;
            }
        }
        if (node.right != null) {
            path(node.right, target, stack);
            if (!stack.isEmpty()) {
                stack.add(node.val);
                return;
            }
        }
    }

    private static class Node {

        Node left;

        Node right;

        int val;

        public Node(int val) {
            this.val = val;
        }

        public Node(Node left, Node right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }
}
