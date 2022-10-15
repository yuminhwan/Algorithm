import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        System.out.println(main.solution());
    }

    static StringBuilder sb = new StringBuilder();
    static int[] pm;
    static int N, M;

    private String solution() {
        pm = new int[M];
        dfs(0);
        return sb.toString();
    }

    private void dfs(int level) {
        if (level == M) {
            for (int x : pm) {
                sb.append(x).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 1; i <= N; i++) {
            pm[level] = i;
            dfs(level + 1);
        }
    }
}
