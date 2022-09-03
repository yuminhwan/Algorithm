import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int S = scanner.nextInt();
        int[] arr = new int[N + 1];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(main.solution(N, S, arr));
    }

    private int solution(int N, int S, int[] arr) {
        int sum = 0;
        int answer = Integer.MAX_VALUE;

        int start = 0;
        int end = 0;
        while (end <= N) {
            if (sum >= S) {
                answer = Math.min(answer, end - start);
                sum -= arr[start++];
            } else {
                sum += arr[end++];
            }
        }
        // for (int end = 0; end <= N; end++) {
        //     sum += arr[end];
        //
        //     while (sum >= S && start < end) {
        //         answer = Math.min(answer, end - start + 1);
        //         sum -= arr[start++];
        //     }
        // }
        if (answer == Integer.MAX_VALUE) {
            return 0;
        }
        return answer;
    }

    private int solution1(int N, int S, int[] arr) {
        int R = 0, sum = 0, ans = Integer.MAX_VALUE;

        for (int L = 0; L < N; L++) {
            if (L != 0) {
                sum -= arr[L];
            }

            while (R + 1 < N && sum < S) {
                sum += arr[R++];
            }

            if (sum >= S) {
                ans = Math.min(ans, R - L + 1);
            }
        }

        if (ans == Integer.MAX_VALUE) {
            return 0;
        }
        return ans;
    }
}
