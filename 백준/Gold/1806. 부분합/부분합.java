import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int S = scanner.nextInt();
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(main.solution(N, S, arr));
    }

    private int solution(int N, int S, int[] arr) {
        int R = 0, sum = 0, ans = Integer.MAX_VALUE;
        for (int L = 1; L <= N; L++) {
            sum -= arr[L - 1];

            while (R + 1 <= N && sum < S)
                sum += arr[++R];

            if (sum >= S)
                ans = Math.min(ans, R - L + 1);
        }

        if (ans == Integer.MAX_VALUE) {
            return 0;
        }
        return ans;
    }
}
