import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int TRASH = 1;
    static int N, M, K;
    static int[][] adj;
    static int[][] move = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int trashLength;

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        adj = new int[N + 1][M + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x][y] = TRASH;
        }

        System.out.println(main.solution());
    }

    private int solution() {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                if (adj[i][j] == TRASH) {
                    trashLength = 0;
                    dfs(i, j);
                    max = Math.max(trashLength, max);
                }
            }
        }
        return max;
    }

    private void dfs(int x, int y) {
        adj[x][y] = 0;
        trashLength++;

        for (int i = 0; i < 4; i++) {
            int dx = x + move[i][0];
            int dy = y + move[i][1];

            if (isValidRange(dx, dy) && adj[dx][dy] == 1) {
                dfs(dx, dy);
            }
        }
    }

    private boolean isValidRange(int x, int y) {
        return 0 < x && 0 < y && x <= N && y <= M;
    }
}
