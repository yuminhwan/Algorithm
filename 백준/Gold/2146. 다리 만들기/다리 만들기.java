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
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(main.solution());
    }

    static int N;
    static int[][] board, dist;
    static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static boolean[][] visited;

    private int solution() {
        dist = new int[N][N];
        visited = new boolean[N][N];
        isLand();
        initDist();

        Queue<Location> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] != 0) {
                    dist[i][j] = 0;
                    q.add(new Location(i, j));
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Location cur = q.remove();

            for (int dir = 0; dir < 4; dir++) {
                int dx = cur.x + move[dir][0];
                int dy = cur.y + move[dir][1];

                if (isNotValidRange(dx, dy) || board[dx][dy] == board[cur.x][cur.y]) {
                    continue;
                }

                if (board[dx][dy] != 0) { // 인접한 다른 섬일 경우
                    answer = Math.min(answer, dist[dx][dy] + dist[cur.x][cur.y]);
                } else { // 바다일 경우
                    board[dx][dy] = board[cur.x][cur.y];
                    dist[dx][dy] = dist[cur.x][cur.y] + 1;
                    q.add(new Location(dx, dy));
                }
            }
        }
        return answer;
    }

    private void initDist() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1);
        }
    }

    private void isLand() {
        Queue<Location> q = new LinkedList<>();
        int landNumber = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0 || visited[i][j]) {
                    continue;
                }
                visited[i][j] = true;
                q.add(new Location(i, j));
                while (!q.isEmpty()) {
                    Location cur = q.remove();
                    board[cur.x][cur.y] = landNumber;

                    for (int dir = 0; dir < 4; dir++) {
                        int dx = cur.x + move[dir][0];
                        int dy = cur.y + move[dir][1];

                        if (isNotValidRange(dx, dy) || visited[dx][dy] || board[dx][dy] == 0) {
                            continue;
                        }

                        visited[dx][dy] = true;
                        q.add(new Location(dx, dy));
                    }
                }
                landNumber++;
            }
        }
    }

    private boolean isNotValidRange(int x, int y) {
        return 0 > x || 0 > y || x >= N || y >= N;
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
