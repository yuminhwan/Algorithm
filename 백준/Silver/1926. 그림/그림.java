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
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        adj = new int[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int x : main.solution()) {
            System.out.println(x);
        }
    }

    private int[] solution() {
        int[] answer = new int[2];
        int total = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && adj[i][j] == 1) {
                    max = Math.max(max, bfs(i, j));
                    total++;
                }
            }
        }

        answer[0] = total;
        if (total != 0) {
            answer[1] = max;
        }
        return answer;
    }

    private int bfs(int x, int y) {
        Queue<Location> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new Location(x, y));

        int cnt = 1;
        while (!q.isEmpty()) {
            Location location = q.remove();

            for (int i = 0; i < 4; i++) {
                int dx = location.x + move[i][0];
                int dy = location.y + move[i][1];

                if (isValidRange(dx, dy) && !visited[dx][dy] && adj[dx][dy] == 1) {
                    visited[dx][dy] = true;
                    q.add(new Location(dx, dy));
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private boolean isValidRange(int x, int y) {
        return 0 <= x && 0 <= y && x < M && y < N;
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
