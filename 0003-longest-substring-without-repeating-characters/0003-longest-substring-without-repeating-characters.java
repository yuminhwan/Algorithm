import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int answer = 0;
        Map<Character, Integer> chars = new HashMap<>();

        int start = 0;
        for (int end = 0; end < n; end++) {
            if (chars.containsKey(s.charAt(end))) {
                start = Math.max(start, chars.get(s.charAt(end)) + 1);
            }

            chars.put(s.charAt(end), end);
            answer = Math.max(answer, end - start + 1);
        }
        return answer;
    }
}