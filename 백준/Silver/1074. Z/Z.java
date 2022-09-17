import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        System.out.println(main.solution(N, r, c));
    }

    private int solution(int n, int r, int c) {
        if (n == 0) {
            return 0;
        }

        int half = 1 << (n - 1);   // 2 ^ n-1
        if (r < half && c < half) {
            return solution(n - 1, r, c);  // 1번
        }
        if (r < half && c >= half) {
            return half * half + solution(n - 1, r, c - half);  // 2번
        }
        if (r >= half && c < half) {
            return 2 * half * half + solution(n - 1, r - half, c);  // 3번
        }
        return 3 * half * half + solution(n - 1, r - half, c - half);  // 4번
    }
}
