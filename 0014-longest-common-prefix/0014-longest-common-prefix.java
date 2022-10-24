import java.util.*;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        // 제일 짧은 문자열 길이 계산
        // 공통된 것이 없거나 제일 짧은 문자열이 0이라면 빈 문자열 반환
        int minWordLength = getMinLength(strs);  // 4
        if (minWordLength == 0 || hasNoCommonPrefix(strs)) {
            return "";
        }

        StringBuilder commonPrefix = new StringBuilder();
        // 2. 제일 짧은 문자열 길이 만큼 순회
        for (int i = 0; i < minWordLength; i++) {
            // 2.1 만약 모든 문자열 배열이 같은 문자를 가지고 있다면
            if (isAllSameWord(strs, i)) {
                // 2.1-1 해당 문자열 저장
                commonPrefix.append(strs[0].charAt(i));
            } else {
                // 2.2 바로 return
                return commonPrefix.toString();
            }
        }
        return commonPrefix.toString();
    }

    private boolean hasNoCommonPrefix(String[] strs) {
        return !isAllSameWord(strs, 0);
    }

    private int getMinLength(String[] strs) {
        int minLength = strs[0].length();

        for (int i = 1; i < strs.length; i++) {
            if (minLength > strs[i].length()) {
                minLength = strs[i].length();
            }
        }
        return minLength;
    }

    private boolean isAllSameWord(String[] strs, int index) {
        char word = strs[0].charAt(index);

        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            if (str.charAt(index) != word) {
                return false;
            }
        }
        return true;
    }
}