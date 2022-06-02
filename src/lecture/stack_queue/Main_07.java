package lecture.stack_queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String mushSubjects = scanner.next();
        String subjects = scanner.next();
        System.out.println(solution(mushSubjects, subjects));
    }

    private static String solution(String mushSubjects, String subjects) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : mushSubjects.toCharArray()) {
            deque.add(c);
        }

        for (char c : subjects.toCharArray()) {
            if (deque.contains(c)) {
                char subject = deque.remove();
                if (subject != c) {
                    return "NO";
                }
            }
        }

        if (!deque.isEmpty()) {
            return "NO";
        }
        return "YES";
    }

    private static String solution2(String need, String plan) {
        Queue<Character> queue = new LinkedList<>();
        for (char c : need.toCharArray()) {
            queue.offer(c);
        }

        for (char c : plan.toCharArray()) {
            if (queue.contains(c)) {
                if (queue.poll() != c) {
                    return "NO";
                }
            }
        }

        if (!queue.isEmpty()) {
            return "NO";
        }
        return "YES";
    }
}
