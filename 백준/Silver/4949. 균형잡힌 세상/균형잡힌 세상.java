import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String str = br.readLine();
            if (str.equals(".")) {
                break;
            }
            sb.append(main.solution(str)).append('\n');
        }
        System.out.println(sb);
    }

    public String solution(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.add(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return "no";
                }
                stack.pop();
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return "no";
                }
                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            return "no";
        }
        return "yes";
    }
}
