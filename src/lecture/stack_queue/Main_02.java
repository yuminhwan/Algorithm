package lecture.stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class Main_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(solution(str));
    }

    private static String solution(String str) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                stack.pop();
            } else {
                if (stack.isEmpty()) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
    }

    private static String solution2(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == ')') {
                while (stack.pop() != '(') {
                }
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stack.size(); i++) {
            sb.append(stack.get(i));
        }

        // for (char c : stack) {
        //     sb.append(c);
        // }
        return sb.toString();
    }
}
