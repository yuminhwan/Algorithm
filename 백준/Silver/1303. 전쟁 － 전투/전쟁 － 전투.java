import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static String[] adj;
    static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static boolean[][] visited;
    static int count, N, M;

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new String[M];
        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            adj[i] = br.readLine();
        }

        int white = 0;
        int black = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    count = 0;
                    char color = adj[i].charAt(j);
                    main.dfs(i, j, color);

                    int power = count * count;
                    if (color == 'W') {
                        white += power;
                    } else {
                        black += power;
                    }
                }
            }
        }

        System.out.println(white + " " + black);
    }

    private void dfs(int x, int y, char color) {
        visited[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int dx = x + move[i][0];
            int dy = y + move[i][1];

            if (isValidRange(dx, dy) && !visited[dx][dy] && adj[dx].charAt(dy) == color) {
                dfs(dx, dy, color);
            }
        }
    }

    private boolean isValidRange(int x, int y) {
        return 0 <= x && 0 <= y && x < M && y < N;
    }
}
