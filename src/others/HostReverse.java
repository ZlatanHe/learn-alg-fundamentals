package others;

import java.util.Stack;

/**
 * Created by Zlatan on 19/3/7.
 */
public class HostReverse {

    public String reverse(String host) {
        if (host == null || host.trim().length() == 0) {
            throw new IllegalArgumentException();
        }
        String[] res = host.split("\\.");
        Stack<String> stack = new Stack<>();
        for (String re : res) {
            stack.add(re);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(".");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new HostReverse().reverse("www.baidu.com"));
    }
}
