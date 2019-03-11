package string;

import java.util.*;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 例如:
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 * 深度优先遍历DFS
 * <p>
 * Created by Zlatan on 19/3/11.
 */
class RestoreIpAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        findNextIp(s.toCharArray(), 0, 1, "", res);
        return res;
    }

    private void findNextIp(char[] chars,
                            int pointer,
                            int seq,
                            String s,
                            List<String> list) {
        if (pointer == chars.length) {
            return;
        }

        if (seq == 4) {
            if (chars[pointer] == '0' && pointer + 1 < chars.length) {
                return;
            }
            if (pointer + 3 < chars.length) {
                return;
            }
            int res = Integer.parseInt(new String(chars, pointer, chars.length - pointer));
            if (res > 255) {
                return;
            }
            list.add(s + res);
            return;
        }

        int maxLen = Math.min(3, chars.length - pointer);
        for (int i = 1; i <= maxLen; i++) {
            int cur = Integer.parseInt(new String(chars, pointer, i));
            if (cur > 255) {
                return;
            }
            findNextIp(chars, pointer + i, seq + 1, s + cur + ".", list);
            if (cur == 0) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        List<String> list = new RestoreIpAddresses().restoreIpAddresses("25525511135");
        System.out.println(list);
        list = new RestoreIpAddresses().restoreIpAddresses("0000");
        System.out.println(list);
        list = new RestoreIpAddresses().restoreIpAddresses("00000");
        System.out.println(list);
        list = new RestoreIpAddresses().restoreIpAddresses("25110110110");
        System.out.println(list);
    }
}
