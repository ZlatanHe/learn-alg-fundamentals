package string;


/**
 * Created by Zlatan on 19/3/9.
 */
public class LongestCommonPrefix {

    /**
     * time: O(S) S为字符总数
     * time: O(1)
     *
     */
    public String solution(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int len = Integer.MAX_VALUE;
        int leastLongStrIndx = 0;
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            int strLen = str.length();
            if (strLen < len) {
                len = strLen;
                leastLongStrIndx = i;
            }
        }
        for (String str : strs) {
            for (int i = 0; i < len; i++) {
                if (str.charAt(i) != strs[leastLongStrIndx].charAt(i)) {
                    len = i;
                    break;
                }
            }
            if (len == 0) {
                break;
            }
        }
        return strs[leastLongStrIndx].substring(0, len);
    }
}
