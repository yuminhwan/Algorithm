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

    static int N, M;
    static int[] pm;
    static StringBuilder sb = new StringBuilder();

    private String solution() {
        pm = new int[M];
        dfs(0, 1);
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

        for (int i = start; i <= N; i++) {
            pm[level] = i;
            dfs(level + 1, i);
        }
    }
}
