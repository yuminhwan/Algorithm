package lecture.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        for (int x : solution(a, b)) {
            System.out.print(x + " ");
        }

    }

    public static List<Integer> solution(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);

        List<Integer> answer = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;

        while (p1 < a.length && p2 < b.length) {
            if (a[p1] == b[p2]) {
                answer.add(a[p1]);
                p1++;
                p2++;
            } else if (a[p1] > b[p2]) {
                p2++;
            } else {
                p1++;
            }
        }

        return answer;
    }

}
