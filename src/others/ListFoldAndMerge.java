package others;

import java.util.Stack;

/**
 * 一个链表 a1->a2->a3...a(n-3)->a(n-2)->a(n-1)->an ,对折，后部分逆序和前部分合并
 * Created by Zlatan on 19/3/7.
 */
public class ListFoldAndMerge {

    public Node foldAndMerge(Node node) {
        int length = 0;
        Node cur = node;
        do {
            length++;
        } while ((cur = cur.next) != null);
        if (length < 3) {
            return node;
        }

        cur = node;
        int midIndex = length % 2  == 0 ? length / 2 - 1 : length / 2;
        Stack<Integer> secondHalf = new Stack<>();
        for (int i = 0; i < length; i++) {
            if (i > midIndex) {
                secondHalf.add(cur.val);
            }
            Node next = cur.next;
            if (i == midIndex) {
                cur.next = null;
            }
            cur = next;
        }


        Node secondHalfHead = new Node(secondHalf.pop());
        cur = secondHalfHead;
        while (!secondHalf.isEmpty()) {
            cur.next = new Node(secondHalf.pop());
            cur = cur.next;
        }

        Node list1Cur = node; Node list2Cur = secondHalfHead;
        boolean odd = true;
        int count;
        while (list2Cur != null) {
            if (odd) {
                Node tmp = list1Cur.next;
                list1Cur.next = list2Cur;
                list1Cur = tmp;
            } else {
                Node tmp = list2Cur.next;
                list2Cur.next = list1Cur;
                list2Cur = tmp;
            }
            odd = !odd;
        }

        return node;
    }

    public static void main(String[] args) {
        ListFoldAndMerge listFoldAndMerge = new ListFoldAndMerge();
        System.out.println(new Node(new int[] {1,2,3,4,5,6,7,8,9,0}));
        System.out.println(listFoldAndMerge.foldAndMerge(new Node(new int[] {1,2,3,4,5,6,7,8,9,0})));
        System.out.println(new Node(new int[] {1,2,3,4,5,6,7,8,9}));
        System.out.println(listFoldAndMerge.foldAndMerge(new Node(new int[] {1,2,3,4,5,6,7,8,9})));
    }

    private static class Node {

        int val;

        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

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