package string;

import java.util.Arrays;

/**
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * Created by Zlatan on 19/3/10.
 */
class CheckInclusion {

    public static boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        if (s1Len > s2Len) {
            return false;
        }

        int[] s1LetterCount = new int[26];
        for (int i = 0; i < s1Len; i++) {
            s1LetterCount[s1.charAt(i) - 'a']++;
        }
        int[] windowLetterCount = new int[26];
        for (int i = 0; i < s1Len - 1; i++) {
            windowLetterCount[s2.charAt(i) - 'a']++;
        }
        int cursor = s1Len - 1;
        while (cursor < s2Len) {
            windowLetterCount[s2.charAt(cursor) - 'a']++;
            if (Arrays.equals(windowLetterCount, s1LetterCount)) {
                return true;
            }
            windowLetterCount[s2.charAt(cursor + 1 - s1Len) - 'a']--;
            cursor++;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.print(checkInclusion("ab", "ndmba"));
    }
}
