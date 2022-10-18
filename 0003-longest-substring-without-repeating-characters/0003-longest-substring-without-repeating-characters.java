import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> chars = new HashMap<>();
        
        int start = 0; 
        int end = 0;
        
        int answer = 0;
        
        while(end < s.length()) {
            char r = s.charAt(end);
            chars.put(r, chars.getOrDefault(r, 0) + 1);
            
            while(chars.get(r) > 1) {
                char l = s.charAt(start);
                chars.put(l, chars.get(l) - 1);
                start++;
            }
            
            answer = Math.max(answer, end - start + 1);
            end++;
        }
        return answer;
    }
}