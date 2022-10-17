import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = 6;

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if (K == 0) {
                return;
            }

            arr = new int[K];
            for (int i = 0; i < K; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            System.out.println(main.solution());
        }
    }

    static int K, M;
    static int[] arr, pm;
    static StringBuilder sb;

    private String solution() {
        sb = new StringBuilder();
        pm = new int[M];

        dfs(0, 0);
        return sb.toString();
    }

    private void dfs(int level, int start) {
        if (level == M) {
            for (int x : pm) {
                sb.append(x).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < K; i++) {
            pm[level] = arr[i];
            dfs(level + 1, i + 1);
        }
    }
}
