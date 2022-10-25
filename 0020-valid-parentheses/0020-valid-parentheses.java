import java.util.*;

class Solution {
    
    static Map<Character, Character> brackets = Map.of('(', ')', '{', '}', '[', ']');
    
    public boolean isValid(String s) {
        // FILO 방식의 stack을 사용 
        Stack<Character> stack = new Stack<>();
        
        for(char bracket : s.toCharArray()) {
         // 1.만약 열린 괄호라면 
        // 1-1.stack에 push 
            if(brackets.containsKey(bracket)) {
                stack.push(bracket);
            } else {
                // 2.닫힌 괄호라면 
                // 2.1 비어있다면 false
                if(stack.isEmpty()) {
                    return false;
                }
        
                // 2-2. 스택의 앞단이 해당 괄호와 매핑이 되지 않는다면 false            
                if(brackets.get(stack.peek()) != bracket) {
                    return false;
                }
        
                // 2-3. 매핑이 된다면 stack에서 pop
                stack.pop();
            }
        }
        
        // 3. 스택에 남아있는 괄호가 있다면 false 
        if(!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}