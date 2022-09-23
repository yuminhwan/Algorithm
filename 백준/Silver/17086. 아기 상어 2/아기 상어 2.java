import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(main.solution(N, M, arr));
    }

    static int[][] board;
    static int N, M, answer = Integer.MIN_VALUE;

    private int solution(int n, int m, int[][] arr) {
        N = n;
        M = m;
        board = arr;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    int distance = bfs(i, j);
                    answer = Math.max(answer, distance);
                }
            }
        }
        return answer;
    }

    static int[][] dist;
    static int[][] move = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    private int bfs(int x, int y) {
        dist = new int[N][M];
        for (int[] dis : dist) {
            Arrays.fill(dis, -1);
        }

        Queue<Location> q = new LinkedList<>();
        dist[x][y] = 0;
        q.add(new Location(x, y));

        while (!q.isEmpty()) {
            Location cur = q.remove();

            for (int i = 0; i < 8; i++) {
                int dx = cur.x + move[i][0];
                int dy = cur.y + move[i][1];

                if (isNotValidRange(dx, dy) || dist[dx][dy] != -1) {
                    continue;
                }

                if (board[dx][dy] == 1) {
                    return dist[cur.x][cur.y] + 1;
                }

                dist[dx][dy] = dist[cur.x][cur.y] + 1;
                q.add(new Location(dx, dy));
            }
        }

        return -1;
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
