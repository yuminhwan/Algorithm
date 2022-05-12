package lecture.array;

import java.util.Scanner;

public class Main_07 {
    public static void main(String[] args) {
        Main_07 t = new Main_07();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(t.solution(n, arr));
    }

    private int solution(int n, int[] arr) {
        int prev = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                prev += 1;
            } else {
                prev = 0;
            }
            sum += prev;
        }

        return sum;
    }

}
