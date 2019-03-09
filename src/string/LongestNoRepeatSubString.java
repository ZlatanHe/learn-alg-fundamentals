package string;

import java.util.*;

/**
 * 寻找字符串最大不重复子串的长度
 *
 */
public class LongestNoRepeatSubString {

    /**
     * time O(N)
     * space O(N)
     */
    public static int solution1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> charMostRightIndex = new HashMap<>();
        int maxLen = Integer.MIN_VALUE;
        int currentLen = 0;
        int currentSubStringBegin = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            Integer cLastIndex = charMostRightIndex.get(c);
            if (cLastIndex != null
                    && cLastIndex >= currentSubStringBegin) {
                currentSubStringBegin = cLastIndex + 1;
                currentLen = i - currentSubStringBegin + 1;
            } else {
                currentLen++;
            }
            if (currentLen > maxLen) {
                maxLen = currentLen;
            }
            charMostRightIndex.put(c, i);
        }
        return maxLen;
    }

    /**
     * time O(N)
     * space O(1)
     */
    public static int solution2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 如果提前知道是标准ascii码, 那就只有128种可能
        Integer[] lastIndex = new Integer[128];
        int maxLen = Integer.MIN_VALUE;
        int currentLen = 0;
        int currentSubStringBegin = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            Integer cLastIndex = lastIndex[c];
            if (cLastIndex != null
                    && cLastIndex >= currentSubStringBegin) {
                currentSubStringBegin = cLastIndex + 1;
                currentLen = i - currentSubStringBegin + 1;
            } else {
                currentLen++;
                maxLen = Math.max(currentLen, maxLen);
            }
            lastIndex[c] = i;
        }
        return maxLen;
    }

}
