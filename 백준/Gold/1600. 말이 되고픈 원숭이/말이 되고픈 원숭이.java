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
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(main.solution());
    }

    static int N, M, K;

    static int[][] board;
    static int[][][] dist;
    static int[][] move = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static int[][] horseMove = {{-2, 1}, {-2, -1}, {-1, 2}, {-1, -2}, {1, 2}, {1, -2}, {2, 1}, {2, -1}};

    private int solution() {
        dist = new int[K + 1][N][M];
        Queue<Location> q = new LinkedList<>();
        q.add(new Location(0, 0, 0));
        dist[0][0][0] = 1;

        while (!q.isEmpty()) {
            Location cur = q.remove();
            int x = cur.x;
            int y = cur.y;
            int horseCount = cur.horseCount;

            if (horseCount < K) {
                for (int i = 0; i < 8; i++) {
                    int dx = x + horseMove[i][0];
                    int dy = y + horseMove[i][1];

                    if (isNotValidRange(dx, dy) || board[dx][dy] == 1 || dist[horseCount + 1][dx][dy] != 0) {
                        continue;
                    }

                    dist[horseCount + 1][dx][dy] = dist[horseCount][x][y] + 1;
                    q.add(new Location(dx, dy, horseCount + 1));
                }
            }
            for (int i = 0; i < 4; i++) {
                int dx = x + move[i][0];
                int dy = y + move[i][1];

                if (isNotValidRange(dx, dy) || board[dx][dy] == 1 || dist[horseCount][dx][dy] != 0) {
                    continue;
                }

                dist[horseCount][dx][dy] = dist[horseCount][x][y] + 1;
                q.add(new Location(dx, dy, horseCount));
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < K + 1; i++) {
            int dist = Main.dist[i][N - 1][M - 1];
            if (dist != 0) {
                answer = Math.min(answer, dist);
            }
        }
        if (answer == Integer.MAX_VALUE) {
            return -1;
        }
        return answer - 1;
    }

    private boolean isNotValidRange(int x, int y) {
        return 0 > x || 0 > y || x >= N || y >= M;
    }

    static class Location {
        int x;
        int y;
        int horseCount;

        public Location(int x, int y, int horseCount) {
            this.x = x;
            this.y = y;
            this.horseCount = horseCount;
        }
    }
}
