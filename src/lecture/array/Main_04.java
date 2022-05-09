package lecture.array;

import java.util.Scanner;

public class Main_04 {
    public static void main(String[] args) {
        Main_04 t = new Main_04();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int x : t.solution(n)) {
            System.out.print(x + " ");
        }
    }

    public int[] solution(int n) {
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return arr;
    }

    public void solution2(int n) {
        int a = 1;
        int b = 1;
        int c;
        System.out.print(a + " " + b);
        for (int i = 2; i < n; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }

}
