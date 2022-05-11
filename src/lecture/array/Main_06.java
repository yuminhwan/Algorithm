package lecture.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_06 {
    public static void main(String[] args) {
        Main_06 t = new Main_06();
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

    public List<Integer> solution(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String reverse = new StringBuilder(String.valueOf(arr[i])).reverse().toString();
            int num = Integer.parseInt(reverse);
            if (isPrime(num)) {
                answer.add(num);
            }
        }
        return answer;
    }

    public boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> solution2(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            int res = 0;
            while (tmp > 0) {
                int t = tmp % 10;
                res = res * 10 + t;
                tmp = tmp / 10;
            }

            if (isPrime(res)) {
                answer.add(res);
            }
        }
        return answer;
    }

}
