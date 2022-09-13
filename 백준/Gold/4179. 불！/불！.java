import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int M, N;
    static char[][] adj;
    static int[][] distForFire, distForHoon, move = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        adj = new char[M][N];
        distForFire = new int[M][N];
        distForHoon = new int[M][N];

        for (int i = 0; i < M; i++) {
            adj[i] = br.readLine().toCharArray();
        }

        main.bfs();
    }

    private void bfs() {
        Queue<Location> fire = new LinkedList<>();
        Queue<Location> hoon = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            Arrays.fill(distForFire[i], -1);
            Arrays.fill(distForHoon[i], -1);
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (adj[i][j] == 'F') {
                    fire.add(new Location(i, j));
                    distForFire[i][j] = 0;
                }

                if (adj[i][j] == 'J') {
                    hoon.add(new Location(i, j));
                    distForHoon[i][j] = 0;
                }
            }
        }

        calculateDistForFire(fire);

        while (!hoon.isEmpty()) {
            Location location = hoon.remove();

            for (int i = 0; i < 4; i++) {
                int dx = location.x + move[i][0];
                int dy = location.y + move[i][1];

                if (dx < 0 || dx >= M || dy < 0 | dy >= N) {
                    System.out.println(distForHoon[location.x][location.y] + 1);
                    return;
                }

                if (distForHoon[dx][dy] >= 0 || adj[dx][dy] == '#') {
                    continue;
                }

                if (distForFire[dx][dy] != -1 && distForFire[dx][dy] <= distForHoon[location.x][location.y] + 1) {
                    continue;
                }

                distForHoon[dx][dy] = distForHoon[location.x][location.y] + 1;
                hoon.add(new Location(dx, dy));
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    private void calculateDistForFire(Queue<Location> fire) {
        while (!fire.isEmpty()) {
            Location location = fire.remove();

            for (int i = 0; i < 4; i++) {
                int dx = location.x + move[i][0];
                int dy = location.y + move[i][1];

                if (isValidRange(dx, dy) && distForFire[dx][dy] == -1 && adj[dx][dy] != '#') {
                    distForFire[dx][dy] = distForFire[location.x][location.y] + 1;
                    fire.add(new Location(dx, dy));
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
