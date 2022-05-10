package lecture.array;

import java.util.Scanner;

public class Main_05 {
    public static void main(String[] args) {
        Main_05 t = new Main_05();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(t.solution(n));
    }

    public int solution(int n) {
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                answer += 1;
            }
        }
        return answer;
    }

    public boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int solution2(int n) {
        int answer = 0;
        int[] ch = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (ch[i] == 0) {
                answer++;
                for (int j = i; j <= n; j += i) {
                    ch[j] = 1;
                }
            }
        }
        return answer;
    }

}
