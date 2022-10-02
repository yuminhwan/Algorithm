import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K;
    static int[][] adj;
    static boolean[][] visited;
    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            adj = new int[N][M];
            visited = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                adj[y][x] = 1;
            }

            System.out.println(main.solution());
        }
    }

    private int solution() {
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && adj[i][j] == 1) {
                    bfs(i, j);
                    answer++;
                }
            }
        }
        return answer;
    }

    private void bfs(int x, int y) {
        Queue<Location> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new Location(x, y));

        while (!q.isEmpty()) {
            Location cur = q.remove();

            for (int i = 0; i < 4; i++) {
                int dx = cur.x + move[i][0];
                int dy = cur.y + move[i][1];

                if (isNotValidRange(dx, dy) || visited[dx][dy] || adj[dx][dy] == 0) {
                    continue;
                }

                visited[dx][dy] = true;
                q.add(new Location(dx, dy));
            }
        }
    }

    private boolean isNotValidRange(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= M;
    }

    static class Location {
        int x;
        int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
