package others;

import java.util.Stack;

/**
 * 两个链表做加法
 * Created by Zlatan on 19/3/7.
 */
public class ListAddup {

    public Node addUp(Node list1Head,
                     Node list2Head,
                     boolean carryIgnore) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Node curNode = list1Head;
        do {
            stack1.add(curNode.val);
        } while ((curNode = curNode.next) != null);
        curNode = list2Head;
        do {
            stack2.add(curNode.val);
        } while ((curNode = curNode.next) != null);

        Stack<Integer> resultStack = new Stack<>();
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int num1 = stack1.isEmpty() ? 0 : stack1.pop();
            int num2 = stack2.isEmpty() ? 0 : stack2.pop();
            int sum = num1 + num2 + carry;
            resultStack.add(sum > 9 ? sum % 10 : sum);
            carry = carryIgnore ? 0 : sum / 10;
        }

        Node res = new Node(resultStack.pop());
        Node cur = res;
        while (!resultStack.isEmpty()) {
            Node next = new Node(resultStack.pop());
            cur.next = next;
            cur = next;
        }
        return res;
    }

    public static void main(String[] args) {
        Node node1 = new Node(new int[] {1,3,4});
        Node node2 = new Node(new int[] {2,6});

        ListAddup listAddup = new ListAddup();
        System.out.println(listAddup.addUp(node1, node2, true));
        System.out.println(listAddup.addUp(node1, node2, false));
    }

    private static class Node {

        int val;

        Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int[] array) {
            this(array[0]);
            Node cur = this;
            for (int i = 1; i < array.length; i++) {
                Node next = new Node(array[i]);
                cur.next = next;
                cur = next;
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node cur = this;
            do {
                sb.append(cur.val).append("->");
            } while ((cur = cur.next) != null);
            sb.delete(sb.length() - 2, sb.length());
            return sb.toString();
        }
    }
}