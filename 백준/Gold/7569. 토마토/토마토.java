import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int M, N, H;
    static int[][][] board;
    static int[][][] dist;
    static int[][] move = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, 1}, {0, 0, -1}};

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        board = new int[N][M][H];
        dist = new int[N][M][H];
        Queue<Location> q = new LinkedList<>();
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    board[i][j][h] = Integer.parseInt(st.nextToken());
                    if (board[i][j][h] == 1) {
                        q.add(new Location(i, j, h));
                    } else if (board[i][j][h] == 0) {
                        dist[i][j][h] = -1;
                    }
                }
            }
        }

        main.solution(q);
        System.out.println(main.getAnswer());
    }

    private void solution(Queue<Location> q) {
        while (!q.isEmpty()) {
            Location cur = q.remove();

            for (int i = 0; i < 6; i++) {
                int dx = cur.x + move[i][0];
                int dy = cur.y + move[i][1];
                int dh = cur.h + move[i][2];

                if (isNotValidRange(dx, dy, dh) || dist[dx][dy][dh] >= 0) {
                    continue;
                }

                dist[dx][dy][dh] = dist[cur.x][cur.y][cur.h] + 1;
                q.add(new Location(dx, dy, dh));
            }
        }
    }

    private int getAnswer() {
        int answer = Integer.MIN_VALUE;
        for (int h = 0; h < H; h++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (dist[i][j][h] == -1) {
                        return -1;
                    }
                    answer = Math.max(answer, dist[i][j][h]);
                }
            }
        }
        return answer;
    }

    private static boolean isNotValidRange(int x, int y, int h) {
        return x < 0 || y < 0 || h < 0 || x >= N || y >= M || h >= H;
    }

    static class Location {
        int x;
        int y;
        int h;

        public Location(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
}
