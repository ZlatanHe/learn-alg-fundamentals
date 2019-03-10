package string;

import java.util.Stack;

/**
 * Created by Zlatan on 19/3/10.
 */
public class ReverseWords {

    public String reverse(String s) {
        return solution2(s);
    }

    private String solution2(String s) {
        if (s == null || s.equals("")) {
            return s;
        }
        String[] strings = s.split(" ");
        boolean wordStart = false;
        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (!wordStart) {
                if (strings[i].equals("")) {
                    continue;
                }
                wordStart = true;
            }
            if (strings[i].equals("")) {
                continue;
            }
            sb.append(strings[i]).append(" ");
        }
        if (wordStart) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private String solution1(String s) {

        char[] chars = s.toCharArray();

        StringBuilder sb = new StringBuilder();

        boolean inBlank = false;
        boolean startWords = false;

        Stack<Character> stack = new Stack<>();
        for (int i = chars.length - 1; i >= 0; i--) {
            char ch = chars[i];

            if (!startWords && ch != ' ') {
                startWords = true;
            }
            if (!startWords) {
                continue;
            }
            if (inBlank) {
                if (ch != ' ') {
                    sb.append(" ");
                    stack.add(ch);
                    inBlank = false;
                }
                continue;
            }

            if (ch == ' ') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                inBlank = true;
                continue;
            }

            stack.add(ch);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverse("  hello world!  ") + "/");
        System.out.println(reverseWords.reverse("a good   example") + "/");
    }
}
