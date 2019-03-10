package string;

import java.util.Stack;

/**
 * Created by Zlatan on 19/3/10.
 */
public class ReverseWords {

    public String reverse(String s) {
        Stack<String> stack = new Stack<>();
        char[] chars = s.toCharArray();

        StringBuilder sb = new StringBuilder();

        boolean inBlank = false;
        boolean startWords = false;

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
                    stack.add(" ");
                    sb = new StringBuilder().append(ch);
                    inBlank = false;
                }
                continue;
            }

            if (ch == ' ') {
                stack.add(sb.toString());
                sb = new StringBuilder();
                inBlank = true;
                continue;
            }

            sb.append(chars[i]);
        }
        if (!inBlank) {
            stack.add(sb.toString());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ReverseWords reverseWords = new ReverseWords();
        System.out.println(reverseWords.reverse("  hello world!  ") + "/");
        System.out.println(reverseWords.reverse("a good   example") + "/");
    }
}
