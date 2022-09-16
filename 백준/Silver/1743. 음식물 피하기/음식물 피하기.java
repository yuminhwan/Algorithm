import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int TRASH = 1;
    static int N, M, K;
    static int[][] adj;
    static int[][] move = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

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
                    int trashLength = bfs(i, j);
                    max = Math.max(trashLength, max);
                }
            }
        }
        return max;
    }

    private int bfs(int x, int y) {
        Queue<Location> q = new LinkedList<>();
        adj[x][y] = 0;
        q.add(new Location(x, y));

        int trashCount = 1;
        while (!q.isEmpty()) {
            Location cur = q.remove();

            for (int i = 0; i < 4; i++) {
                int dx = cur.x + move[i][0];
                int dy = cur.y + move[i][1];

                if (isValidRange(dx, dy) && adj[dx][dy] == TRASH) {
                    trashCount++;
                    adj[dx][dy] = 0;
                    q.add(new Location(dx, dy));
                }
            }
        }
        return trashCount;
    }

    private boolean isValidRange(int x, int y) {
        return 0 < x && 0 < y && x <= N && y <= M;
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
