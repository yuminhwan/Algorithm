import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int M, N, max = Integer.MIN_VALUE;
    static boolean[][] visited;
    static int[][] adj;
    static int[][] move = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                adj[i][j] = Integer.parseInt(line[j]);
            }
        }

        System.out.println(main.solution(0, 0));
    }

    private int solution(int x, int y) {
        Queue<Location> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new Location(x, y));

        while (!q.isEmpty()) {
            Location location = q.remove();

            for (int i = 0; i < 4; i++) {
                int dx = location.x + move[i][0];
                int dy = location.y + move[i][1];

                if (isValidRange(dx, dy) && adj[dx][dy] == 1 && !visited[dx][dy]) {
                    visited[dx][dy] = true;
                    adj[dx][dy] = adj[location.x][location.y] + 1;
                    q.add(new Location(dx, dy));
                }
            }
        }
        return adj[N - 1][M - 1];
    }

    private boolean isValidRange(int x, int y) {
        return 0 <= x && 0 <= y && x < N && y < M;
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
