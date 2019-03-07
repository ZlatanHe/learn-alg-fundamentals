package others;

/**
 * Created by Zlatan on 19/3/7.
 */
public class Node {

    int val;

    Node next;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
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
