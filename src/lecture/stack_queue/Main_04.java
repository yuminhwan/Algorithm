package lecture.stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class Main_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(solution(str));
    }

    private static int solution(String str) {
        Stack<Integer> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - 48);
            } else {
                int result = calculate(stack, c);
                stack.push(result);
            }
        }
        return stack.pop();
    }

    private static int solution2(String str) {
        Stack<Integer> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c - 48);
            } else {
                int rt = stack.pop();
                int lt = stack.pop();
                if (c == '+') {
                    stack.push(lt + rt);
                } else if (c == '-') {
                    stack.push(lt - rt);
                } else if (c == '*') {
                    stack.push(lt * rt);
                } else if (c == '/') {
                    stack.push(lt / rt);
                }
            }
        }
        return stack.get(0);
    }

    private static int calculate(Stack<Integer> stack, char c) {
        int second = stack.pop();
        int first = stack.pop();
        switch (c) {
            case '+':
                return first + second;
            case '-':
                return first - second;
            case '*':
                return first * second;
            case '/':
                return first / second;
            default:
                return 0;
        }
    }
}
