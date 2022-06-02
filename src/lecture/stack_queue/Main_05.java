package lecture.stack_queue;

import java.util.Scanner;
import java.util.Stack;

public class Main_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(solution(str));
    }

    private static int solution(String str) {
        int answer = 0;
        boolean isLazer = false;
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                isLazer = true;
            } else {
                stack.pop();
                if (isLazer) {
                    answer += stack.size();
                } else {
                    answer++;
                }
                isLazer = false;
            }
        }
        return answer;
    }

    private static int solution2(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            } else {
                stack.pop();
                if (str.charAt(i - 1) == '(') {
                    answer += stack.size();
                } else {
                    answer++;
                }
            }
        }
        return answer;
    }
}
