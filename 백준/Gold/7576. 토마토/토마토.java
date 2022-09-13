import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int M, N;
    static int[][] adj, dist;
    static int[][] move = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    static Queue<Location> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new int[M][N];
        dist = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                adj[i][j] = Integer.parseInt(st.nextToken());
                if (adj[i][j] == 1) {
                    q.add(new Location(i, j));
                }
            }
        }

        main.dfs();
        System.out.println(main.getAnswer());
    }

    private int getAnswer() {
        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (adj[i][j] == 0) {
                    return -1;
                }
                answer = Math.max(answer, dist[i][j]);
            }
        }
        return answer;
    }

    private void dfs() {
        while (!q.isEmpty()) {
            Location location = q.remove();

            for (int i = 0; i < 4; i++) {
                int dx = location.x + move[i][0];
                int dy = location.y + move[i][1];

                if (isValidRange(dx, dy) && adj[dx][dy] == 0) {
                    adj[dx][dy] = 1;
                    dist[dx][dy] = dist[location.x][location.y] + 1;
                    q.add(new Location(dx, dy));
                }
            }
        }
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
