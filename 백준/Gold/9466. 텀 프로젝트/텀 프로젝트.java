import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            System.out.println(main.solution());
        }
    }

    static int n;
    static int[] arr, state;
    static final int NOT_VISITED = 0;
    static final int CYCLE_IN = -1;

    private int solution() {
        state = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (state[i] == NOT_VISITED) {
                calculate(i);
            }
        }

        int cnt = 0;
        for (int i = 1; i < n + 1; i++) {
            if (state[i] != CYCLE_IN) {
                cnt++;
            }
        }
        return cnt;
    }

    private void calculate(int x) {
        int cur = x;
        while (true) {
            state[cur] = x;
            cur = arr[cur];

            if (state[cur] == x) {
                while (state[cur] != CYCLE_IN) {
                    state[cur] = CYCLE_IN;
                    cur = arr[cur];
                }
                return;
            }

            if (state[cur] != NOT_VISITED) {
                return;
            }
        }
    }
}
