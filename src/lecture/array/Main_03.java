package lecture.array;

import java.util.Scanner;

public class Main_03 {
    public static void main(String[] args) {
        Main_03 t = new Main_03();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(t.solution(n, a, b));
    }

    public String solution(int n, int[] a, int[] b) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) {
                sb.append("D\n");
            } else if (a[i] == 1 && b[i] == 3) {
                sb.append("A\n");
            } else if (a[i] == 2 && b[i] == 1) {
                sb.append("A\n");
            } else if (a[i] == 3 && b[i] == 2) {
                sb.append("A\n");
            } else {
                sb.append("B\n");
            }
        }
        return sb.toString();
    }

}
