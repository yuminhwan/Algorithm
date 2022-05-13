package lecture.array;

import java.util.Scanner;

public class Main_08 {
    public static void main(String[] args) {
        Main_08 t = new Main_08();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        for (int x : t.solution(n, arr)) {
            System.out.print(x + " ");
        }
    }

    private int[] solution(int n, int[] arr) {
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n; j++) {
                if (arr[i] < arr[j]) {
                    cnt++;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }

}
