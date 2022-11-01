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
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(main.solution(N, S, arr));
    }

    private int solution(int n, int s, int[] arr) {
        int answer = Integer.MAX_VALUE;

        int sum = arr[0];
        int en = 0;
        for (int st = 0; st < n; st++) {
            while (en < n && sum < s) {
                en++;
                if (en != n) {
                    sum += arr[en];
                }
            }

            if (en == n) {
                break;
            }
            answer = Math.min(answer, en - st + 1);
            sum -= arr[st];
        }

        if (answer == Integer.MAX_VALUE) {
            return 0;
        }
        return answer;
    }
}
