package lecture.two_pointers;

import java.util.Scanner;

public class Main_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println(solution(n, k, a));
    }

    public static int solution(int n, int k, int[] a) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += a[i];
        }

        int answer = sum;
        for (int i = k; i < n; i++) {
            sum = sum + a[i] - a[i - k];
            if (answer < sum) {
                answer = sum;
            }
        }

        return answer;
    }

}
