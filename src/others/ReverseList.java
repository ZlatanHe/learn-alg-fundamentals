package others;

/**
 * 原地反转单链表
 * Created by Zlatan on 19/3/7.
 */
public class ReverseList {

    public Node reverse(Node node) {
        Node cur = node;
        Node before = null;
        Node after;
        while (cur != null) {
            after = cur.next;
            cur.next = before; // 上一个变成下一个

            before = cur; // 新的迭代值
            cur = after; // 新的迭代值
        }
        return before;
    }

    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        Node node = new Node(new int[] {1,2,3,4,5,6,7,8,9});
        System.out.println(node);
        System.out.println(reverseList.reverse(node));
    }
}
