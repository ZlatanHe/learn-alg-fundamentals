package string;

import java.util.Stack;

/**
 * Created by Zlatan on 19/3/11.
 */
class SimplifyPath {

    public String simplifyPath(String path) {
        int len = path.length();
        if (len == 0) {
            return "";
        }
        Stack<String> layers = new Stack<>();
        String[] dirs = path.split("/");
        for (String dir : dirs) {
            if (dir.equals("")) {
                continue;
            }
            if (dir.equals(".")) {
                continue;
            }
            if (dir.equals("..")) {
                if (!layers.isEmpty()) {
                    layers.pop();
                }
                continue;
            }
            layers.add(dir);
        }
        if (layers.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder("/");
        for (String layer : layers) {
            sb.append(layer).append("/");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new SimplifyPath().simplifyPath("/a/./b/../../c/"));
    }
}
