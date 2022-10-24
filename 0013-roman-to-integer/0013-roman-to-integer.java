import java.util.*;

class Solution {
    
    // 1. Map에 저장 
    static Map<Character, Integer> romanNumber = Map.of('I', 1, 'V', 5, 'X', 10, 'L',50, 'C',100,'D',500,'M',1000);
    
    public int romanToInt(String s) {
        int result = 0;
        
        // 2. 하나씩 순회 
        for(int i = 0; i<s.length(); i++) {    
            // 2-1. 만약 index가 끝부분이 아니고 다음 녀석이 더 클다면
            if(i != s.length() - 1 && isSubtractNumber(s, i)) {
                // 2-1-1. map에서 뒷에것 숫자 - 앞에것 숫자를 해준뒤 더한다.
                // 2-1-2. 이후 index를 ++해준다.              
                result += calculateSubtractNumber(s, i);
                i++;
            } else {
                // 2-2.map에서 숫자를 가져와 더한다
                result += romanNumber.get(s.charAt(i));
            }
        }
        return result;
    }
    
    private boolean isSubtractNumber(String s, int index) {
        char curWord = s.charAt(index);
        char nextWord = s.charAt(index+1);
        
        if(romanNumber.get(curWord) < romanNumber.get(nextWord)) {
            return true;
        }
        return false;
    }
    
    private int calculateSubtractNumber(String s, int index) {
        char curWord = s.charAt(index);
        char nextWord = s.charAt(index+1);
        
        return romanNumber.get(nextWord) - romanNumber.get(curWord);
    }
}