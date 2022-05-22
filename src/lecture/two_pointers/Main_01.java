package lecture.two_pointers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] first = new int[n];
        for (int i = 0; i < n; i++) {
            first[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] second = new int[m];
        for (int i = 0; i < m; i++) {
            second[i] = scanner.nextInt();
        }
        for (int x : solution2(first, second)) {
            System.out.print(x + " ");
        }
    }

    private static int[] solution(int[] first, int[] second) {
        int[] answer = new int[first.length + second.length];
        int p1 = 0;
        int p2 = 0;
        for (int i = 0; i < answer.length; i++) {
            if (p1 == first.length) {
                answer[i] = second[p2];
                p2++;
                continue;
            } else if (p2 == second.length) {
                answer[i] = first[p1];
                p1++;
                continue;
            }

            if (first[p1] >= second[p2]) {
                answer[i] = second[p2];
                p2++;
            } else if (first[p1] < second[p2]) {
                answer[i] = first[p1];
                p1++;
            }
        }
        return answer;
    }

    private static List<Integer> solution2(int[] first, int[] second) {
        List<Integer> answer = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        while (p1 < first.length && p2 < second.length) {
            if (first[p1] < second[p2]) {
                answer.add(first[p1++]);
            } else {
                answer.add(second[p2++]);
            }
        }
        while (p1 < first.length) {
            answer.add(first[p1++]);
        }
        while (p2 < second.length) {
            answer.add(second[p2++]);
        }

        return answer;
    }

}
