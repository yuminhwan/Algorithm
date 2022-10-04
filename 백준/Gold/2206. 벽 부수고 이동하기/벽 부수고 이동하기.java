import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }
        System.out.println(main.solution());
    }

    static int N, M;
    static int[][] board;
    static int[][][] dist;
    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private int solution() {
        dist = new int[N][M][2];

        Queue<Location> q = new LinkedList<>();
        q.add(new Location(0, 0, 0));
        dist[0][0][0] = dist[0][0][1] = 1;

        while (!q.isEmpty()) {
            Location cur = q.remove();
            int broken = cur.broken;
            int x = cur.x;
            int y = cur.y;
            if (x == N - 1 && y == M - 1) {
                return dist[x][y][broken];
            }

            int nextDist = dist[x][y][broken] + 1;
            for (int i = 0; i < 4; i++) {
                int dx = x + move[i][0];
                int dy = y + move[i][1];

                if (isNotValidRange(dx, dy)) {
                    continue;
                }

                if (board[dx][dy] == 0 && dist[dx][dy][broken] == 0) {
                    dist[dx][dy][broken] = nextDist;
                    q.add(new Location(dx, dy, broken));
                }

                if (cur.canBroken() && board[dx][dy] == 1 && dist[dx][dy][1] == 0) {
                    dist[dx][dy][1] = nextDist;
                    q.add(new Location(dx, dy, 1));
                }

            }
        }
        return -1;
    }

    private boolean isNotValidRange(int x, int y) {
        return 0 > x || 0 > y || x >= N || y >= M;
    }

    static class Location {
        int x;
        int y;
        int broken;

        public Location(int x, int y, int broken) {
            this.x = x;
            this.y = y;
            this.broken = broken;
        }

        public boolean canBroken() {
            return broken == 0;
        }
    }
}
