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
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(main.solution());
    }

    static int N, M;
    static int[][] board;
    static int[][] move = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    static boolean[][] visited;

    private int solution() {
        visited = new boolean[N][M];
        int year = 0;

        while (true) {
            year++;
            melting();
            visited = new boolean[N][M];
            int check = status();
            if (check == 0) {
                return 0;
            }
            if (check == 2) {
                break;
            }
        }
        return year;
    }

    private int status() {
        int x = -1;
        int y = -1;
        int leftIceCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] != 0) {
                    x = i;
                    y = j;
                    leftIceCount++;
                }
            }
        }

        if (leftIceCount == 0) {
            return 0;
        }

        int withIceCount = 0;
        Queue<Location> q = new LinkedList<>();
        q.add(new Location(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Location cur = q.remove();
            withIceCount++;

            for (int i = 0; i < 4; i++) {
                int dx = cur.x + move[i][0];
                int dy = cur.y + move[i][1];
                if (isNotValidRange(dx, dy) || visited[dx][dy] || board[dx][dy] == 0) {
                    continue;
                }

                visited[dx][dy] = true;
                q.add(new Location(dx, dy));
            }
        }

        if (leftIceCount == withIceCount) {
            return 1;
        }
        return 2;
    }

    private void melting() {
        int[][] zero = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    continue;
                }

                for (int dir = 0; dir < 4; dir++) {
                    int dx = i + move[dir][0];
                    int dy = j + move[dir][1];

                    if (isNotValidRange(dx, dy)) {
                        continue;
                    }

                    if (board[dx][dy] == 0) {
                        zero[i][j]++;
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = Math.max(0, board[i][j] - zero[i][j]);
            }
        }
    }

    private boolean isNotValidRange(int x, int y) {
        return 0 > x || 0 > y || x >= N || y >= M;
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
